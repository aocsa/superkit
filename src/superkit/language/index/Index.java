package superkit.language.index;

import superkit.language.NaturalNumber;
import superkit.language.count.Count;

public interface Index extends NaturalNumber
{
	public static Index ZERO = Index.of(0);

	public static Index of(long index)
	{
		return new IndexValue(index);
	}

	public default Index add(NaturalNumber offset)
	{
		return Index.of(get() + offset.get());
	}

	public default int compareTo(Index that)
	{
		final long thisValue = this.get();
		final long thatValue = that.get();
		if (thisValue == thatValue)
		{
			return 0;
		}
		return thisValue < thatValue ? -1 : 1;
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

	public default Index minus(NaturalNumber that)
	{
		return Index.of(get() - that.get());
	}

	@Override
	long get();
}
