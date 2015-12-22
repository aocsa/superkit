package superkit.collections.arrays;

import org.junit.Assert;
import org.junit.Test;

import superkit.language.count.Bits;
import superkit.language.count.Count;
import superkit.language.index.Index;
import superkit.testing.UnitTest;

public class VariableWidthBitPackedArrayTest extends UnitTest
{
	private final VariableWidthBitPackedArray array = new VariableWidthBitPackedArray(Bits.ONE, Count.FOUR);

	@Test
	public void test()
	{
		test(0, 0);
		test(1, 1);
		test(2, 0);
		test(3, 1);
		Assert.assertEquals(Bits.ONE, this.array.bits());
		test(0, 0);
		test(1, 1);
		test(2, 2);
		test(3, 3);
		Assert.assertEquals(Bits.TWO, this.array.bits());
		test(0, 4);
		test(1, 5);
		test(2, 6);
		test(3, 7);
		Assert.assertEquals(Bits.THREE, this.array.bits());
		test(0, 16);
		test(1, 17);
		test(2, 18);
		test(3, 19);
		Assert.assertEquals(Bits.FIVE, this.array.bits());
		test(0, 250);
		test(1, 251);
		test(2, 252);
		test(3, 253);
		Assert.assertEquals(Bits.EIGHT, this.array.bits());
		test(0, 250);
		test(1, 251);
		test(2, 252);
		test(3, 253);
		System.out.println(this.array);
	}

	private void test(int index, long value)
	{
		this.array.set(Index.of(index), value);
		Assert.assertEquals(value, this.array.get(Index.of(index)));
	}
}
