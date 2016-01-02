package superkit.language.count;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

import superkit.collections.AbstractIterator;
import superkit.language.NaturalNumber;
import superkit.language.index.Index;
import superkit.math.ZeroToOne;

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
	public static Count ELEVEN = of(11);
	public static Count TWELVE = of(12);
	public static Count THIRTEEN = of(13);
	public static Count FOURTEEN = of(14);
	public static Count FIFTEEN = of(15);
	public static Count SIXTEEN = of(16);
	public static Count SEVENTEEN = of(17);
	public static Count EIGHTEEN = of(18);
	public static Count NINETEEN = of(19);
	public static Count TWENTY = of(20);
	public static Count TWENTY_FOUR = of(24);
	public static Count THIRTY_TWO = of(32);
	public static Count FORTY_EIGHT = of(48);
	public static Count SIXTY_FOUR = of(64);
	public static Count EIGHTY = of(80);
	public static Count NINETY_SIX = of(96);
	public static Count ONE_HUNDRED = of(100);
	public static Count ONE_HUNDRED_TWENTY_EIGHT = of(128);
	public static Count TWO_HUNDRED_FIFTY_SIX = of(256);
	public static Count FIVE_HUNDRED_TWELVE = of(512);
	public static Count FIVE_HUNDRED = of(500);
	public static Count ONE_THOUSAND = of(1000);
	public static Count TEN_THOUSAND = of(10000);

	public static Count MAXIMUM = Count.of(Long.MAX_VALUE);
	public static Count MAXIMUM_LONG = Count.of(Long.MAX_VALUE);
	public static Count MAXIMUM_INTEGER = Count.of(Integer.MAX_VALUE);
	public static Count MAXIMUM_SHORT = Count.of(Short.MAX_VALUE);
	public static Count MAXIMUM_CHAR = Count.of(Character.MAX_VALUE);
	public static Count MAXIMUM_BYTE = Count.of(Byte.MAX_VALUE);
	public static Count MINIMUM = Count.of(0);

	public static Count of(Collection<?> genes)
	{
		return of(genes.size());
	}

	public static Count of(long value)
	{
		return cache.forLong(value);
	}

	public static Count of(String value)
	{
		return of(Long.parseLong(value));
	}

	public default Count decremented()
	{
		return of(get() - 1);
	}

	public default Count dividedBy(NaturalNumber value)
	{
		return of(get() / value.get());
	}

	public default Count immutable()
	{
		return of(get());
	}

	public default Count incremented()
	{
		return of(get() + 1);
	}

	public default Count maximum(Count that)
	{
		return this.get() > that.get() ? this : that;
	}

	public default Count minimum(NaturalNumber that)
	{
		return of(Math.min(get(), that.get()));
	}

	public default Count minus(Index that)
	{
		return Count.of(get() - that.get());
	}

	public default Count minus(NaturalNumber that)
	{
		return of(get() - that.get());
	}

	public default MutableCount mutable()
	{
		return new MutableCount(this);
	}

	public default ZeroToOne fractionOf(NaturalNumber that)
	{
		if (that.isLessThan(this))
		{
			throw new IllegalArgumentException("Cannot represent percentage greater than one");
		}
		return new ZeroToOne((double) get() / that.get());
	}

	public default Count plus(NaturalNumber value)
	{
		return of(get() + value.get());
	}

	public default void repeat(Consumer<Index> consumer)
	{
		for (final Index index : this)
		{
			consumer.accept(index);
		}
	}

	public default void repeat(Runnable runnable)
	{
		repeat(index -> runnable.run());
	}

	public default Count times(NaturalNumber value)
	{
		return of(get() * value.get());
	}

	public default Iterable<Count> to(Count that)
	{
		return new Iterable<Count>()
		{
			@Override
			public Iterator<Count> iterator()
			{
				return new AbstractIterator<Count>()
				{
					private MutableCount count;

					@Override
					protected Count findNext()
					{
						if (count == null)
						{
							count = mutable();
						}
						if (count.isLessThanOrEqualTo(that))
						{
							final Count next = count.asCount();
							count.increment();
							return next;
						}
						return null;
					}
				};
			}
		};
	}

	@Override
	long get();
}
