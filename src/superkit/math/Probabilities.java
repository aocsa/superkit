package superkit.math;

import superkit.collections.lists.ObjectList;
import superkit.language.RandomValueFactory;
import superkit.language.index.Index;

public class Probabilities extends ObjectList<Probability>
{
	public Index randomIndex()
	{
		final double total = sum();
		final double value = RandomValueFactory.INSTANCE.randomDouble(0, total);
		double ceiling = 0;
		for (final Index index : size())
		{
			ceiling += get(index).asDouble();
			if (value < ceiling)
			{
				return index;
			}
		}
		return size().decremented().asIndex();
	}

	private double sum()
	{
		double sum = 0;
		for (final Probability probability : this)
		{
			sum += probability.asDouble();
		}
		return sum;
	}
}
