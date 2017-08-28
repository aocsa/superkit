package superkit.math.probability;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.locke.superkit.language.count.Count;
import org.locke.superkit.language.count.MutableCount;
import org.locke.superkit.language.index.Index;
import org.locke.superkit.math.probability.Probabilities;
import org.locke.superkit.math.probability.Probability;

public class ProbabilitiesTest
{
	@Test
	public void testProbabilities()
	{
		{
			final Probabilities probabilities = new Probabilities();
			probabilities.add(new Probability(0.25));
			probabilities.add(new Probability(0.75));
			final MutableCount first = new MutableCount();
			final MutableCount second = new MutableCount();
			Count.ONE_MILLION.repeat(() ->
			{
				final Index index = probabilities.randomIndex();
				switch (index.asInteger())
				{
					case 0:
						first.increment();
						break;

					case 1:
						second.increment();
						break;

					default:
						fail("Invalid index");
				}
			});
			assertEquals(Count.ONE_MILLION, first.plus(second));
			assertEquals(0.25, first.fractionOf(Count.ONE_MILLION).asDouble(), 0.05);
		}
		{
			final Probabilities probabilities = new Probabilities();
			probabilities.add(new Probability(0.5));
			probabilities.add(new Probability(0.5));
			probabilities.add(new Probability(0.5));
			final MutableCount first = new MutableCount();
			final MutableCount second = new MutableCount();
			final MutableCount third = new MutableCount();
			Count.ONE_MILLION.repeat(() ->
			{
				final Index index = probabilities.randomIndex();
				switch (index.asInteger())
				{
					case 0:
						first.increment();
						break;

					case 1:
						second.increment();
						break;

					case 2:
						third.increment();
						break;

					default:
						fail("Invalid index");
				}
			});
			assertEquals(Count.ONE_MILLION, first.plus(second).plus(third));
			assertEquals(0.3333, first.fractionOf(Count.ONE_MILLION).asDouble(), 0.05);
		}
	}
}
