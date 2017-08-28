package org.locke.superkit.math;

public class Percentage
{
	public static final Percentage ZERO = Percentage.of(0);
	public static final Percentage FIFTY = Percentage.of(50);
	public static final Percentage ONE_HUNDRED = Percentage.of(100);

	public static Percentage of(double percentage)
	{
		return new Percentage(percentage);
	}

	private final double percentage;

	protected Percentage(double percentage)
	{
		if (percentage < 0 || percentage > 100.0)
		{
			throw new IllegalArgumentException();
		}
		this.percentage = percentage;
	}

	@Override
	public String toString()
	{
		return percentage + "%";
	}

	ZeroToOne asZeroToOne()
	{
		return ZeroToOne.of(percentage / 100.0);
	}
}
