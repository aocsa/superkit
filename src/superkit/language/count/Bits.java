package superkit.language.count;

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

	public static Bits of(int count)
	{
		if (count < 0 || count > Long.SIZE)
		{
			throw new IllegalArgumentException("Bit count must be >= 0 and <= " + Long.SIZE);
		}
		return cache[count];
	}

	public static Bits toRepresent(long value)
	{
		return new Bits(Long.SIZE - Long.numberOfLeadingZeros(value));
	}

	private long mask;

	private Bits(int count)
	{
		super(count);
		for (int i = 0; i < count; i++)
		{
			this.mask <<= 1;
			this.mask |= 1;
		}
	}

	public long mask()
	{
		return this.mask;
	}

	public long maximumValue()
	{
		return this.mask;
	}
}
