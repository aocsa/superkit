package superkit.language.index;

import superkit.language.NaturalNumber;
import superkit.language.count.Count;

public interface Index extends NaturalNumber
{
	public static Index of(long index)
	{
		return new IndexValue(index);
	}

	public default Index add(NaturalNumber offset)
	{
		return Index.of(get() + offset.get());
	}

	public default Index copy()
	{
		return Index.of(get());
	}

	public default Index decremented()
	{
		return Index.of(get() - 1);
	}

	public default Count distance(Index that)
	{
		return Count.of(Math.abs(get() - that.get()));
	}

	public default Index immutable()
	{
		return Index.of(get());
	}

	public default Index incremented()
	{
		return Index.of(get() + 1);
	}

	public default MutableIndex mutable()
	{
		return new MutableIndex(this);
	}

	public default Index subtract(NaturalNumber that)
	{
		return Index.of(get() - that.get());
	}

	@Override
	long get();
}