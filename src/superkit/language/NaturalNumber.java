package superkit.language;

import java.util.Iterator;

import superkit.language.count.Count;
import superkit.language.index.Index;

public interface NaturalNumber extends Iterable<Index>, Comparable<NaturalNumber>
{
	public default Count asCount()
	{
		return Count.of(get());
	}

	public default Index asIndex()
	{
		return Index.of(get());
	}

	public default int asInteger()
	{
		return (int) get();
	}

	public default long asLong()
	{
		return get();
	}

	@Override
	public default int compareTo(NaturalNumber that)
	{
		return Long.compare(this.get(), that.get());
	}

	public default Iterable<Index> indexes(NaturalNumber length)
	{
		return new Iterable<Index>()
		{
			@Override
			public Iterator<Index> iterator()
			{
				return new Iterator<Index>()
				{
					private long index = get();

					@Override
					public boolean hasNext()
					{
						return index < get() + length.get();
					}

					@Override
					public Index next()
					{
						return Index.of(index++);
					}
				};
			}
		};
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
						return Index.of(index++);
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
						return Index.of(index++);
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
