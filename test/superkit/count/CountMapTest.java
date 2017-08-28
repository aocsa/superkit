package superkit.count;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.locke.superkit.language.count.Count;
import org.locke.superkit.language.count.CountMap;

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
		assertEquals(counts.maximumCount(), Count.of(2));
		assertEquals(counts.count("A"), Count.of(2));
		assertEquals(counts.count("C"), Count.of(1));
		assertEquals(counts.count("G"), Count.ZERO);
	}
}
