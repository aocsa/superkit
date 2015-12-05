package superkit.count;

public interface Count extends NaturalNumber
{
	static CountValueCache cache = new CountValueCache();

	public static Count ZERO = forLong(0);
	public static Count ONE = forLong(1);
	public static Count TWO = forLong(2);
	public static Count THREE = forLong(3);
	public static Count FOUR = forLong(4);
	public static Count FIVE = forLong(5);
	public static Count SIX = forLong(6);
	public static Count SEVEN = forLong(7);
	public static Count EIGHT = forLong(8);
	public static Count NINE = forLong(9);
	public static Count TEN = forLong(10);

	public static Count forLong(long value)
	{
		return cache.forLong(value);
	}

	public static Count forString(String value)
	{
		return forLong(Long.parseLong(value));
	}

	public default Count add(NaturalNumber value)
	{
		return Count.forLong(get() + value.get());
	}

	public default Count decremented()
	{
		return Count.forLong(get() - 1);
	}

	public default Count immutable()
	{
		return Count.forLong(get());
	}

	public default Count incremented()
	{
		return Count.forLong(get() + 1);
	}

	public default Count maximum(Count that)
	{
		return this.get() > that.get() ? this : that;
	}

	public default MutableCount mutable()
	{
		return new MutableCount(this);
	}

	public default Index subtract(Index that)
	{
		return Index.forLong(get() - that.get());
	}

	public default Count subtract(NaturalNumber that)
	{
		return Count.forLong(get() - that.get());
	}

	@Override
	long get();
}
