package superkit.language.bits;

import java.util.Iterator;

import superkit.language.NaturalNumber;
import superkit.language.count.Count;
import superkit.language.count.CountValue;

public class Bits extends CountValue
{
	private static Bits[] cache = new Bits[65];

	static
	{
		for (int i = 0; i < cache.length; i++)
		{
			cache[i] = new Bits(i);
		}
	}

	public static Bits ZERO = of(0);
	public static Bits ONE = of(1);
	public static Bits TWO = of(2);
	public static Bits THREE = of(3);
	public static Bits FOUR = of(4);
	public static Bits FIVE = of(5);
	public static Bits SIX = of(6);
	public static Bits SEVEN = of(7);
	public static Bits EIGHT = of(8);
	public static Bits SIXTEEN = of(16);
	public static Bits TWENTY_FOUR = of(24);
	public static Bits THIRTY_TWO = of(32);
	public static Bits FORTY_EIGHT = of(48);
	public static Bits SIXTY_FOUR = of(64);

	public static Bits of(long count)
	{
		if (count < 0)
		{
			throw new IllegalArgumentException("Bit count must be >= 0");
		}
		if (count < Long.SIZE)
		{
			return cache[(int) count];
		}
		return new Bits(count);
	}

	public static Bits perByte()
	{
		return Bits.of(Byte.SIZE);
	}

	public static Bits perCharacter()
	{
		return Bits.of(Character.SIZE);
	}

	public static Bits perInteger()
	{
		return Bits.of(Integer.SIZE);
	}

	public static Bits perLong()
	{
		return Bits.of(Long.SIZE);
	}

	public static Bits perShort()
	{
		return Bits.of(Short.SIZE);
	}

	public static Bits toRepresent(long value)
	{
		return new Bits(Long.SIZE - Long.numberOfLeadingZeros(value));
	}

	private long mask;

	private Bits(long count)
	{
		super(count);
		for (int i = 0; i < count; i++)
		{
			this.mask <<= 1;
			this.mask |= 1;
		}
	}

	/**
	 * @return The number of elements of the given element size required to
	 *         store this number of bits
	 */
	public Count arraySize(Bits elementSize)
	{
		return plus(elementSize.decremented()).dividedBy(elementSize);
	}

	public Iterable<Bits> bitsLessThan()
	{
		return new Iterable<Bits>()
		{
			@Override
			public Iterator<Bits> iterator()
			{
				return new Iterator<Bits>()
				{
					private int bits = 1;

					@Override
					public boolean hasNext()
					{
						return this.bits < get();
					}

					@Override
					public Bits next()
					{
						return Bits.of(this.bits++);
					}
				};
			}
		};
	}

	public long mask()
	{
		return this.mask;
	}

	public long maximumValue()
	{
		return this.mask;
	}

	@Override
	public Bits times(NaturalNumber value)
	{
		return of(get() * value.get());
	}
}
