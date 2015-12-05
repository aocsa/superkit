package superkit.count;

public interface Count extends NaturalNumber
{
	static CountValueCache cache = new CountValueCache();

	public static Count ZERO = of(0);
	public static Count ONE = of(1);
	public static Count TWO = of(2);
	public static Count THREE = of(3);
	public static Count FOUR = of(4);
	public static Count FIVE = of(5);
	public static Count SIX = of(6);
	public static Count SEVEN = of(7);
	public static Count EIGHT = of(8);
	public static Count NINE = of(9);
	public static Count TEN = of(10);

	public static Count of(long value)
	{
		return cache.forLong(value);
	}

	public static Count of(String value)
	{
		return of(Long.parseLong(value));
	}

	public default Count add(NaturalNumber value)
	{
		return Count.of(get() + value.get());
	}

	public default Count decremented()
	{
		return Count.of(get() - 1);
	}

	public default Count immutable()
	{
		return Count.of(get());
	}

	public default Count incremented()
	{
		return Count.of(get() + 1);
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
		return Count.of(get() - that.get());
	}

	@Override
	long get();
}
