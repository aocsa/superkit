package superkit.count;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountMapTest
{
	@Test
	public void test()
	{
		final CountMap<String> counts = new CountMap<>();
		counts.increment("A");
		counts.increment("A");
		counts.increment("C");
		counts.increment("T");
		assertEquals(counts.maximumCount(), Count.forLong(2));
		assertEquals(counts.count("A"), Count.forLong(2));
		assertEquals(counts.count("C"), Count.forLong(1));
		assertEquals(counts.count("G"), Count.ZERO);
	}
}
