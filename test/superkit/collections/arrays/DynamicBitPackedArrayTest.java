package superkit.collections.arrays;

import org.junit.Assert;
import org.junit.Test;

import superkit.language.count.Bits;
import superkit.language.count.Count;
import superkit.language.index.Index;
import superkit.testing.UnitTest;

public class DynamicBitPackedArrayTest extends UnitTest
{
	private final DynamicBitPackedArray array = new DynamicBitPackedArray(Bits.ONE, Count.FOUR);

	@Test
	public void test()
	{
		test(0, 0);
		test(1, 1);
		test(2, 0);
		test(3, 1);
		test(4, 0);
		test(5, 1);
		test(6, 0);
		test(7, 1);

		test(0, 0);
		test(1, 1);
		test(2, 2);
		test(3, 3);

		test(0, 4);
		test(1, 5);
		test(2, 6);
		test(3, 7);

		test(0, 16);
		test(1, 17);
		test(2, 18);
		test(3, 19);

		test(0, 250);
		test(1, 251);
		test(2, 252);
		test(3, 253);

		test(0, 250);
		test(1, 251);
		test(2, 252);
		test(3, 253);
	}

	private void test(int index, long value)
	{
		this.array.set(Index.of(index), value);
		Assert.assertEquals(value, this.array.get(Index.of(index)));
	}
}
