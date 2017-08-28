package org.locke.superkit.collections.arrays;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;
import org.locke.superkit.collections.lists.ObjectList;
import org.locke.superkit.language.bits.Bits;
import org.locke.superkit.language.count.Count;
import org.locke.superkit.language.index.Index;
import org.locke.superkit.testing.UnitTest;

public class BitPackedArrayTest extends UnitTest
{
	private final Random random = random();

	@Test
	public void testRandom()
	{
		final Count LENGTH = Count.ONE_THOUSAND;
		for (final Bits bits : Bits.perLong().bitsLessThan())
		{
			final BitPackedArray array = new BitPackedArray(bits, LENGTH);
			final ObjectList<Long> testValues = new ObjectList<>();
			for (final Index index : LENGTH)
			{
				final long value = Math.abs(random.nextLong() % bits.maximumValue() + 1);
				testValues.set(index, value);
				array.set(index, value);
			}
			assertEquals(LENGTH, array.size());
			for (final Index index : LENGTH)
			{
				assertEquals(testValues.get(index), (Long) array.get(index));
			}
		}
	}

	@Test
	public void testValues()
	{
		final Count LENGTH = Count.SIXTY_FOUR;
		for (final Bits bits : Bits.perLong().bitsLessThan())
		{
			final BitPackedArray array = new BitPackedArray(bits, LENGTH);
			LENGTH.forEach(index -> {
				final long maximum = Math.max(Long.MAX_VALUE, bits.maximumValue());
				final long steps = 10000;
				final long step = Math.max(1, maximum / steps);
				for (long value = 0; value > 0 && value < maximum; value += step)
				{
					array.set(index, value);
					assertEquals(value, array.get(index));
				}
			});
		}
	}
}
