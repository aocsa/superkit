package superkit.collections.arrays;

import org.junit.Test;

import superkit.language.count.Bits;
import superkit.language.count.Count;

public class BitPackedArrayTest
{
	@Test
	public void test()
	{
		final BitPackedArray array = new BitPackedArray(Bits.FIVE, Count.SIXTEEN);
		array.set(0, 31);
		array.set(2, 31);
		array.set(4, 31);
		array.set(6, 31);
		array.set(8, 31);
		array.set(10, 31);
		array.set(12, 31);
		array.set(14, 31);
		System.out.println(array);
	}
}
