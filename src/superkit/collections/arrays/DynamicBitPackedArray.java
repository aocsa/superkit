package superkit.collections.arrays;

import java.util.Iterator;
import java.util.Objects;

import superkit.collections.lists.ObjectList;
import superkit.language.count.Bits;
import superkit.language.count.Count;
import superkit.language.count.MutableCount;
import superkit.language.index.Index;

public class DynamicBitPackedArray implements Iterable<Index>
{
	private final ObjectList<VariableWidthBitPackedArray> arrays = new ObjectList<>();

	private final MutableCount size = new MutableCount();
	private final Bits subArrayInitialBits;
	private final Count subArraySize;

	public DynamicBitPackedArray(Bits subArrayInitialBits, Count subArraySize)
	{
		this.subArrayInitialBits = subArrayInitialBits;
		this.subArraySize = subArraySize;
	}

	public void add(long value)
	{
		set(this.size.asIndex(), value);
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
		return readArray(index).get(offset(index));
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(this.arrays);
	}

	@Override
	public Iterator<Index> iterator()
	{
		return this.size.iterator();
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
		return this.arrays.get(whichArray);
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
