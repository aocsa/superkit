package superkit.collections.arrays;

import org.junit.Assert;
import org.junit.Test;
import org.locke.superkit.collections.arrays.VariableWidthBitPackedArray;
import org.locke.superkit.language.bits.Bits;
import org.locke.superkit.language.count.Count;
import org.locke.superkit.language.index.Index;
import org.locke.superkit.testing.UnitTest;

public class VariableWidthBitPackedArrayTest extends UnitTest
{
	@Test
	public void testSimple()
	{
		final VariableWidthBitPackedArray array = new VariableWidthBitPackedArray(Bits.ONE, Count.FOUR);
		test(array, 0, 0);
		test(array, 1, 1);
		test(array, 2, 0);
		test(array, 3, 1);
		Assert.assertEquals(Bits.ONE, array.bits());
		test(array, 0, 0);
		test(array, 1, 1);
		test(array, 2, 2);
		test(array, 3, 3);
		Assert.assertEquals(Bits.TWO, array.bits());
		test(array, 0, 4);
		test(array, 1, 5);
		test(array, 2, 6);
		test(array, 3, 7);
		Assert.assertEquals(Bits.THREE, array.bits());
		test(array, 0, 16);
		test(array, 1, 17);
		test(array, 2, 18);
		test(array, 3, 19);
		Assert.assertEquals(Bits.FIVE, array.bits());
		test(array, 0, 250);
		test(array, 1, 251);
		test(array, 2, 252);
		test(array, 3, 253);
		Assert.assertEquals(Bits.EIGHT, array.bits());
		test(array, 0, 250);
		test(array, 1, 251);
		test(array, 2, 252);
		test(array, 3, 253);
		Assert.assertEquals(Bits.EIGHT, array.bits());
		test(array, 0, 0);
		test(array, 1, 1);
		test(array, 2, 2);
		test(array, 3, 3);
		Assert.assertEquals(Bits.EIGHT, array.bits());
	}

	private void test(VariableWidthBitPackedArray array, int index, long value)
	{
		array.set(Index.of(index), value);
		Assert.assertEquals(value, array.get(Index.of(index)));
	}
}
