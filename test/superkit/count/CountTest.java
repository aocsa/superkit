package superkit.count;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import superkit.language.count.Count;
import superkit.language.count.CountValue;
import superkit.language.index.Index;

public class CountTest
{
	@Test
	public void test()
	{
		assertEquals(Count.of(5), Count.of("5"));
		assertEquals(5L, Count.of(5).get());
		assertEquals(CountValue.ZERO, Count.of(5).subtract(Count.of(5)));
	}

	@Test
	public void testForEach()
	{
		final List<Index> indexes = new ArrayList<Index>();
		Count.of(5L).forEach(value -> indexes.add(value));
		assertEquals(indexes, Arrays.asList(Index.forLong(0), Index.forLong(1), Index.forLong(2), Index.forLong(3),
		        Index.forLong(4)));
	}

	@Test
	public void testIndexesLessThan()
	{
		final List<Index> indexes = new ArrayList<Index>();
		for (final Index index : Count.of(5).indexesLessThan())
		{
			indexes.add(index);
		}
		assertEquals(
		        Arrays.asList(Index.forLong(0), Index.forLong(1), Index.forLong(2), Index.forLong(3), Index.forLong(4)),
		        indexes);
	}

	@Test
	public void testIndexesLessThanOrEqualTo()
	{
		final List<Index> indexes = new ArrayList<Index>();
		for (final Index index : Count.of(4).indexesLessThanOrEqualTo())
		{
			indexes.add(index);
		}
		assertEquals(
		        Arrays.asList(Index.forLong(0), Index.forLong(1), Index.forLong(2), Index.forLong(3), Index.forLong(4)),
		        indexes);
	}
}
