package superkit.count;

public interface Index extends NaturalNumber
{
	public static Index forLong(long index)
	{
		return new IndexValue(index);
	}

	public default Index add(NaturalNumber offset)
	{
		return Index.forLong(get() + offset.get());
	}

	public default Index copy()
	{
		return Index.forLong(get());
	}

	public default Index decremented()
	{
		return Index.forLong(get() - 1);
	}

	public default Count distance(Index that)
	{
		return Count.forLong(Math.abs(get() - that.get()));
	}

	public default Index immutable()
	{
		return Index.forLong(get());
	}

	public default Index incremented()
	{
		return Index.forLong(get() + 1);
	}

	public default MutableIndex mutable()
	{
		return new MutableIndex(this);
	}

	public default Index subtract(NaturalNumber that)
	{
		return Index.forLong(get() - that.get());
	}

	@Override
	long get();
}
