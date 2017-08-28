package superkit.count;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.locke.superkit.language.count.Count;
import org.locke.superkit.language.index.Index;
import org.locke.superkit.language.index.MutableIndex;

public class IndexTest
{
	@Test
	public void testArithmetic()
	{
		for (long value = 1; value > 0 && value < Long.MAX_VALUE - 1; value *= 2)
		{
			assertEquals(value + 1, Index.of(value).incremented().get());
			assertEquals(value + 1, Index.of(value).add(Count.ONE).get());
			assertEquals(value - 1, Index.of(value).decremented().get());
			assertEquals(value - 1, Index.of(value).minus(Count.ONE).get());
			assertEquals(1, Index.of(value).distance(Index.of(value + 1)).get());
			assertEquals(1, Index.of(value).distance(Index.of(value - 1)).get());
		}
	}

	@Test
	public void testMutable()
	{
		final MutableIndex index = new MutableIndex();
		for (long value = 1; value > 0 && value < Long.MAX_VALUE - 1; value *= 2)
		{
			index.set(value);
			assertEquals(value, index.get());
			index.increment();
			assertEquals(value + 1, index.get());
		}
	}
}
