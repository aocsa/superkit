package org.locke.superkit.testing;

import java.time.Instant;
import java.util.Random;

public class UnitTest
{
	protected Random random()
	{
		final long seed = Instant.now().getEpochSecond();
		final Random random = new Random(seed);
		System.out.println("random unit test seed: " + seed);
		return random;
	}
}
