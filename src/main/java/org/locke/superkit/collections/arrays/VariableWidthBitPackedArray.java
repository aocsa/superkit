package org.locke.superkit.collections.arrays;

import java.util.Iterator;

import org.locke.superkit.language.bits.Bits;
import org.locke.superkit.language.count.Count;
import org.locke.superkit.language.index.Index;

/**
 * A bit packed array that automatically "upgrades" the element bit width when a
 * value is added that is too large to store.
 *
 * @author Jonathan Locke
 */
public class VariableWidthBitPackedArray implements Iterable<Long>
{
	private BitPackedArray array;
	private long invertedMask;

	/**
	 * @param bits
	 *            The number of bits per element
	 * @param size
	 *            The size of the array in elements
	 */
	public VariableWidthBitPackedArray(Bits bits, Count size)
	{
		this.array = new BitPackedArray(bits, size);
		this.invertedMask = ~bits.mask();
	}

	public Bits bits()
	{
		return this.array.bits();
	}

	public long get(Index index)
	{
		return this.array.get(index);
	}

	public Iterable<Index> indexes()
	{
		return this.array.indexes();
	}

	@Override
	public Iterator<Long> iterator()
	{
		return this.array.iterator();
	}

	public Long safeGet(Index index)
	{
		return this.array.safeGet(index);
	}

	public void set(Index index, long value)
	{
		// If the value is out of range
		if ((value & this.invertedMask) != 0)
		{
			final Bits bits = Bits.toRepresent(value);
			this.array = this.array.copyTo(new BitPackedArray(bits, this.array.size()));
			this.invertedMask = ~bits.mask();
		}
		this.array.set(index, value);
	}

	public Count size()
	{
		return this.array.size();
	}

	@Override
	public String toString()
	{
		return this.array.toString();
	}
}
