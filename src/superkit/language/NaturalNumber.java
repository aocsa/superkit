package superkit.language;

import java.util.Iterator;

import superkit.language.count.Count;
import superkit.language.index.Index;

public interface NaturalNumber extends Iterable<Index>
{
	public default Count asCount()
	{
		return Count.of(get());
	}

	public default Index asIndex()
	{
		return Index.forLong(get());
	}

	public default int asInteger()
	{
		return (int) get();
	}

	public default Iterable<Index> indexesLessThan()
	{
		return new Iterable<Index>()
		{
			@Override
			public Iterator<Index> iterator()
			{
				return new Iterator<Index>()
				{
					private long index;

					@Override
					public boolean hasNext()
					{
						return index < get();
					}

					@Override
					public Index next()
					{
						return Index.forLong(index++);
					}
				};
			}
		};
	}

	public default Iterable<Index> indexesLessThanOrEqualTo()
	{
		return new Iterable<Index>()
		{
			@Override
			public Iterator<Index> iterator()
			{
				return new Iterator<Index>()
				{
					private long index = 0;

					@Override
					public boolean hasNext()
					{
						return index <= get();
					}

					@Override
					public Index next()
					{
						return Index.forLong(index++);
					}
				};
			}
		};
	}

	public default boolean isGreaterThan(NaturalNumber that)
	{
		return get() > that.get();
	}

	public default boolean isGreaterThanOrEqualTo(NaturalNumber that)
	{
		return get() >= that.get();
	}

	public default boolean isLessThan(NaturalNumber that)
	{
		return get() < that.get();
	}

	public default boolean isLessThanOrEqualTo(NaturalNumber that)
	{
		return get() <= that.get();
	}

	public default boolean isZero()
	{
		return get() == 0;
	}

	@Override
	public default Iterator<Index> iterator()
	{
		return indexesLessThan().iterator();
	}

	long get();
}
