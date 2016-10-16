package superkit.collections.arrays;

import java.util.Iterator;

import superkit.collections.AbstractIterator;
import superkit.collections.lists.ObjectList;
import superkit.language.bits.Bits;
import superkit.language.count.Count;
import superkit.language.index.Index;
import superkit.language.strings.Strings;

/**
 * Stores values of an arbitrary bit length by packing them end-to-end into an
 * array of long values. For example, this is how sixteen 5 bit values would be
 * split across longs in the array, where the bits for each value are numbered
 * from 0 to F:
 *
 * <pre>
 * Bit Index [ 01234567 01234567 01234567 01234567 01234567 01234567 01234567 01234567 ] <-- 64 bits
 * Long[0] = [ 00000111 11222223 33334444 45555566 66677777 88888999 99AAAAAB BBBBCCCC ]
 * Long[1] = [ CDDDDDEE EEEFFFFF 00000000 00000000 00000000 00000000 00000000 00000000 ]
 * </pre>
 *
 * @author Jonathan Locke
 */
public class BitPackedArray implements Iterable<Long>
{
	private static final Bits ARRAY_ELEMENT_SIZE = Bits.perLong();

	private final long[] data;
	private final int bits;
	private final long mask;
	private final Count size;

	/**
	 * @param bits
	 *            The number of bits per element
	 * @param size
	 *            The size of the array in elements
	 */
	public BitPackedArray(Bits bits, Count size)
	{
		if (bits.isGreaterThan(ARRAY_ELEMENT_SIZE))
		{
			throw new IllegalArgumentException("Bits per element must be less than or equal to " + ARRAY_ELEMENT_SIZE);
		}
		final Count arraySize = bits.times(size).arraySize(ARRAY_ELEMENT_SIZE);
		if (arraySize.isGreaterThan(Count.MAXIMUM_INTEGER))
		{
			throw new IllegalArgumentException("Array size of " + arraySize + " is too large");
		}
		this.data = new long[arraySize.asInteger()];
		this.size = size;
		this.bits = bits.asInteger();
		this.mask = bits.mask();
	}

	public Bits bits()
	{
		return Bits.of(this.bits);
	}

	public BitPackedArray copyTo(BitPackedArray copy)
	{
		for (final Index index : indexes())
		{
			copy.set(index, get(index));
		}
		return copy;
	}

	public long get(Index index)
	{
		final int size = ARRAY_ELEMENT_SIZE.asInteger();
		final int bitIndex = index.asInteger() * this.bits;
		final int dataIndex = bitIndex / size;
		final int dataBitOffset = bitIndex % size;
		if (dataBitOffset + this.bits <= size)
		{
			return (this.data[dataIndex] >>> (size - dataBitOffset - this.bits)) & this.mask;
		}
		else
		{
			final int highBits = size - dataBitOffset;
			final int lowBits = this.bits - highBits;
			final long high = this.data[dataIndex] & (this.mask >>> lowBits);
			final long low = (this.data[dataIndex + 1] >>> (size - lowBits));
			return (high << lowBits) | low;
		}
	}

	public Iterable<Index> indexes()
	{
		return new Iterable<Index>()
		{
			@Override
			public Iterator<Index> iterator()
			{
				return BitPackedArray.this.size.iterator();
			}
		};
	}

	@Override
	public Iterator<Long> iterator()
	{
		return new AbstractIterator<Long>()
		{
			Index index = Index.ZERO;

			@Override
			protected Long findNext()
			{
				if (this.index.isLessThan(BitPackedArray.this.size))
				{
					return get(this.index);
				}
				return null;
			}
		};
	}

	public Long safeGet(Index index)
	{
		if (index.isLessThan(this.size))
		{
			return get(index);
		}
		return null;
	}

	public void set(Index index, long value)
	{
		final int size = ARRAY_ELEMENT_SIZE.asInteger();
		final int bitIndex = index.asInteger() * this.bits;
		final int dataIndex = bitIndex / size;
		final int dataBitOffset = bitIndex % size;
		if (dataBitOffset + this.bits <= size)
		{
			final int leftShift = size - dataBitOffset - this.bits;
			final long mask = this.mask << leftShift;
			this.data[dataIndex] = (this.data[dataIndex] & ~mask) | (value << leftShift);
		}
		else
		{
			final int highBits = size - dataBitOffset;
			final int lowBits = this.bits - highBits;
			final int leftShift = size - lowBits;
			final long highMask = this.mask >>> lowBits;
			final long lowMask = this.mask << leftShift;
			this.data[dataIndex] = (this.data[dataIndex] & ~highMask) | (value >> lowBits);
			this.data[dataIndex + 1] = (this.data[dataIndex + 1] & ~lowMask) | (value << leftShift);
		}
	}

	public Count size()
	{
		return this.size;
	}

	@Override
	public String toString()
	{
		final ObjectList<String> values = new ObjectList<>();
		for (final Index index : size())
		{
			values.add(Strings.leftPad(Long.toBinaryString(get(index)), '0', this.bits));
		}
		return values.join();
	}
}
