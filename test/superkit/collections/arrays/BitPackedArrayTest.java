package superkit.collections.arrays;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import superkit.language.count.Bits;
import superkit.language.count.Count;
import superkit.language.index.Index;
import superkit.testing.UnitTest;

public class BitPackedArrayTest extends UnitTest
{
	@Test
	public void test()
	{
		final Random random = random();
		for (final Bits bits : Bits.perLong().bitsLessThan())
		{
			final BitPackedArray array = new BitPackedArray(bits, Count.ONE_HUNDRED);
			for (final Index index : array.size())
			{
				Count.ONE_HUNDRED.forEach(iteration -> {
					final long value = Math.abs(random.nextLong() % bits.maximumValue() + 1);
					array.set(index, value);
					assertTrue(array.get(index) == value);
				});
			}
		}
	}
}
