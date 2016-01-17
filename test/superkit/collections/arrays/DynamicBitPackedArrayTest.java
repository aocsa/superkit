package superkit.collections.arrays;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import superkit.collections.lists.ObjectList;
import superkit.language.bits.Bits;
import superkit.language.count.Count;
import superkit.language.index.Index;
import superkit.testing.UnitTest;

public class DynamicBitPackedArrayTest extends UnitTest
{
	private final Random random = random();

	@Test
	public void testRandom()
	{
		final Count LENGTH = Count.ONE_THOUSAND;
		for (final Bits bits : Bits.perLong().bitsLessThan())
		{
			final DynamicBitPackedArray array = new DynamicBitPackedArray(bits, LENGTH.dividedBy(Count.TEN));
			final ObjectList<Long> testValues = new ObjectList<>();
			for (final Index index : LENGTH)
			{
				final long value = Math.abs(this.random.nextLong() % bits.maximumValue() + 1);
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
	public void testSimple()
	{
		final DynamicBitPackedArray array = new DynamicBitPackedArray(Bits.ONE, Count.FOUR);
		for (int i = 0; i < 10; i++)
		{
			test(array, 0, 0);
			test(array, 1, 1);
			test(array, 2, 0);
			test(array, 3, 1);
			test(array, 4, 0);
			test(array, 5, 1);
			test(array, 6, 0);
			test(array, 7, 1);

			test(array, 0, 0);
			test(array, 1, 1);
			test(array, 2, 2);
			test(array, 3, 3);

			test(array, 0, 4);
			test(array, 1, 5);
			test(array, 2, 6);
			test(array, 3, 7);

			test(array, 0, 16);
			test(array, 1, 17);
			test(array, 2, 18);
			test(array, 3, 19);

			test(array, 0, 250);
			test(array, 1, 251);
			test(array, 2, 252);
			test(array, 3, 253);

			test(array, 0, 250);
			test(array, 1, 251);
			test(array, 2, 252);
			test(array, 3, 253);
		}
	}

	@Test
	public void testValues()
	{
		final Count LENGTH = Count.SIXTY_FOUR;
		for (final Bits bits : Bits.perLong().bitsLessThan())
		{
			final DynamicBitPackedArray array = new DynamicBitPackedArray(bits, LENGTH.dividedBy(Count.TEN));
			LENGTH.forEach(index ->
			{
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

	private void test(DynamicBitPackedArray array, int index, long value)
	{
		array.set(Index.of(index), value);
		Assert.assertEquals(value, array.get(Index.of(index)));
	}
}
