package superkit.math;

import superkit.language.Comparison;

public class ZeroToOne implements Comparison<ZeroToOne>
{
	public static final ZeroToOne ZERO = new ZeroToOne(0);
	public static final ZeroToOne ONE = new ZeroToOne(1);

	private final double value;

	public ZeroToOne(final double value)
	{
		if (value < 0)
		{
			throw new IllegalArgumentException("Value " + value + " cannot be less than zero");
		}
		if (value > 1)
		{
			throw new IllegalArgumentException("Value " + value + " cannot be greater than one");
		}
		this.value = value;
	}

	public ZeroToOne add(ZeroToOne that)
	{
		return new ZeroToOne(this.value + that.value);
	}

	public double asDouble()
	{
		return this.value;
	}

	@Override
	public boolean isEqualTo(ZeroToOne that)
	{
		return this.value == that.value;
	}

	@Override
	public boolean isGreaterThan(ZeroToOne that)
	{
		return this.value > that.value;
	}

	@Override
	public boolean isGreaterThanOrEqualTo(ZeroToOne that)
	{
		return this.value >= that.value;
	}

	@Override
	public boolean isLessThan(ZeroToOne that)
	{
		return this.value < that.value;
	}

	@Override
	public boolean isLessThanOrEqualTo(ZeroToOne that)
	{
		return this.value <= that.value;
	}

	@Override
	public String toString()
	{
		return Double.toString(this.value);
	}
}
