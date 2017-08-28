package org.locke.superkit.language;

import java.util.Random;

import org.locke.superkit.language.count.Count;
import org.locke.superkit.language.index.Index;

public class RandomValueFactory
{
	public static RandomValueFactory INSTANCE = new RandomValueFactory();

	private final Random random = new Random();

	public double randomDouble()
	{
		return this.random.nextDouble();
	}

	public double randomDouble(double minimum, double maximum)
	{
		return minimum + this.random.nextDouble() * (maximum - minimum);
	}

	public Index randomIndex(Count maximum)
	{
		return Index.of(Math.abs(this.random.nextLong() % maximum.get()));
	}
}
