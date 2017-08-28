package superkit.collections.arrays;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.locke.superkit.collections.arrays.DynamicBitPackedArray;
import org.locke.superkit.collections.arrays.DynamicBooleanArray;
import org.locke.superkit.collections.lists.ObjectList;
import org.locke.superkit.language.bits.Bits;
import org.locke.superkit.language.count.Count;
import org.locke.superkit.language.index.Index;
import org.locke.superkit.testing.UnitTest;

public class DynamicBooleanArrayTest extends UnitTest
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
		final DynamicBooleanArray array = new DynamicBooleanArray();
		for (int i = 0; i < 10; i++)
		{
			test(array, 0, false);
			test(array, 1, true);
			test(array, 2, false);
			test(array, 3, true);
			test(array, 4, false);
			test(array, 5, true);
			test(array, 6, false);
			test(array, 7, true);

			test(array, 0, false);
			test(array, 1, true);
			test(array, 2, false);
			test(array, 3, true);

			test(array, 0, true);
			test(array, 1, false);
			test(array, 2, true);
			test(array, 3, false);

			test(array, 0, true);
			test(array, 1, false);
			test(array, 2, true);
			test(array, 3, false);

			test(array, 0, false);
			test(array, 1, true);
			test(array, 2, true);
			test(array, 3, false);

			test(array, 0, false);
			test(array, 1, true);
			test(array, 2, false);
			test(array, 3, true);
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

	private void test(DynamicBooleanArray array, int index, boolean value)
	{
		array.set(Index.of(index), value);
		Assert.assertEquals(value, array.is(Index.of(index)));
	}
}
