package superkit.collections.arrays;

import java.util.Iterator;
import java.util.Objects;

import superkit.collections.AbstractIterator;
import superkit.collections.lists.ObjectList;
import superkit.language.count.Bits;
import superkit.language.count.Count;
import superkit.language.count.MutableCount;
import superkit.language.index.Index;

public class DynamicBitPackedArray implements Iterable<Long>
{
	private final ObjectList<VariableWidthBitPackedArray> arrays = new ObjectList<>();

	private final MutableCount size = new MutableCount();
	private final Bits subArrayInitialBits;
	private final Count subArraySize;

	public DynamicBitPackedArray(Bits subArrayInitialBits)
	{
		this(subArrayInitialBits, Count.of(4096));
	}

	public DynamicBitPackedArray(Bits subArrayInitialBits, Count subArraySize)
	{
		this.subArrayInitialBits = subArrayInitialBits;
		this.subArraySize = subArraySize;
	}

	public void add(long value)
	{
		set(this.size.asIndex(), value);
	}

	public long decrement(Index index)
	{
		final Long value = safeGet(index);
		final long decremented = value == null ? -1 : value - 1;
		set(index, decremented);
		return decremented;
	}

	@Override
	public boolean equals(Object object)
	{
		if (object instanceof DynamicBitPackedArray)
		{
			final DynamicBitPackedArray that = (DynamicBitPackedArray) object;
			if (this.size == that.size)
			{
				for (final Index index : size())
				{
					if (get(index) != that.get(index))
					{
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	public long get(Index index)
	{
		if (index.isLessThan(this.size))
		{
			final VariableWidthBitPackedArray array = readArray(index);
			if (array != null)
			{
				return array.get(offset(index));
			}
			return 0;
		}
		throw new IllegalArgumentException("Index out of bounds");
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(this.arrays);
	}

	public void increment(Index index)
	{
		final Long value = safeGet(index);
		if (value == null)
		{
			set(index, 1);
		}
		else
		{
			set(index, value + 1);
		}
	}

	public Iterable<Index> indexes()
	{
		return new Iterable<Index>()
		{
			@Override
			public Iterator<Index> iterator()
			{
				return DynamicBitPackedArray.this.size.iterator();
			}
		};
	}

	@Override
	public Iterator<Long> iterator()
	{
		return new AbstractIterator<Long>()
		{
			Index index = Index.ZERO;
			Count size = size();

			@Override
			protected Long findNext()
			{
				if (this.index.isLessThan(this.size))
				{
					return get(this.index);
				}
				return null;
			}
		};
	}

	public long maximumValue()
	{
		long maximum = Integer.MIN_VALUE;
		for (final Index index : indexes())
		{
			maximum = Math.max(maximum, get(index));
		}
		return maximum;
	}

	public Long safeGet(Index index)
	{
		if (index.isLessThan(this.size))
		{
			final VariableWidthBitPackedArray array = readArray(index);
			if (array != null)
			{
				return array.safeGet(offset(index));
			}
		}
		return null;
	}

	public void set(Index index, long value)
	{
		if (index.isGreaterThanOrEqualTo(this.size))
		{
			this.size.set(index.incremented());
		}
		writeArray(index, value).set(offset(index), value);
	}

	public Count size()
	{
		return this.size;
	}

	@Override
	public String toString()
	{
		final ObjectList<Long> values = new ObjectList<>();
		for (final Index index : this.size.asCount())
		{
			values.add(get(index));
		}
		return values.join();
	}

	private Index offset(Index index)
	{
		return Index.of(index.get() % this.subArraySize.asInteger());
	}

	private VariableWidthBitPackedArray readArray(Index index)
	{
		final int whichArray = (int) (index.get() / this.subArraySize.asInteger());
		return this.arrays.safeGet(whichArray);
	}

	private VariableWidthBitPackedArray writeArray(Index index, long value)
	{
		// Find the right array for this index
		final int whichArray = (int) (index.get() / this.subArraySize.asInteger());
		VariableWidthBitPackedArray array = this.arrays.safeGet(whichArray);

		// If there's no array yet,
		if (array == null)
		{
			// create one
			this.arrays.set(whichArray,
			        array = new VariableWidthBitPackedArray(this.subArrayInitialBits, this.subArraySize));
		}
		return array;
	}
}
