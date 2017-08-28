package org.locke.superkit.math.probability;

import org.locke.superkit.math.ZeroToOne;

public class Probability extends ZeroToOne
{
	public static final Probability ZERO = new Probability(0);
	public static final Probability ONE = new Probability(1);

	public Probability(double value)
	{
		super(value);
	}

	@Override
	public Probability add(ZeroToOne that)
	{
		return new Probability(asDouble() + that.asDouble());
	}
}
