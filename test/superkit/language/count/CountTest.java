package superkit.language.count;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import superkit.math.ZeroToOne;

public class CountTest
{
	@Test
	public void testFractionOf()
	{
		assertEquals(ZeroToOne.ONE_HALF, Count.TWO.fractionOf(Count.FOUR));
		assertEquals(0.66666666, Count.TWO.fractionOf(Count.THREE).asDouble(), 0.000001);
	}
}
