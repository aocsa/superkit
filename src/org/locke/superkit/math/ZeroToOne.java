package org.locke.superkit.math;

import java.util.Objects;

import org.locke.superkit.language.Comparison;

public class ZeroToOne implements Comparison<ZeroToOne>
{
	public static final ZeroToOne ZERO = new ZeroToOne(0);
	public static final ZeroToOne ONE_HALF = new ZeroToOne(0.5);
	public static final ZeroToOne ONE_QUARTER = new ZeroToOne(0.25);
	public static final ZeroToOne ONE_EIGHTH = new ZeroToOne(0.125);
	public static final ZeroToOne ONE = new ZeroToOne(1);

	public static ZeroToOne of(double value)
	{
		return new ZeroToOne(value);
	}

	private final double value;

	protected ZeroToOne(final double value)
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
		return new ZeroToOne(value + that.value);
	}

	public double asDouble()
	{
		return value;
	}

	@Override
	public boolean equals(Object object)
	{
		if (object instanceof ZeroToOne)
		{
			final ZeroToOne that = (ZeroToOne) object;
			return value == that.value;
		}
		return false;
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(value);
	}

	@Override
	public boolean isEqualTo(ZeroToOne that)
	{
		return value == that.value;
	}

	@Override
	public boolean isGreaterThan(ZeroToOne that)
	{
		return value > that.value;
	}

	@Override
	public boolean isGreaterThanOrEqualTo(ZeroToOne that)
	{
		return value >= that.value;
	}

	@Override
	public boolean isLessThan(ZeroToOne that)
	{
		return value < that.value;
	}

	@Override
	public boolean isLessThanOrEqualTo(ZeroToOne that)
	{
		return value <= that.value;
	}

	@Override
	public String toString()
	{
		return Double.toString(value);
	}
}
