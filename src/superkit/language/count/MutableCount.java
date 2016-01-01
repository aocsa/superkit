package superkit.language.count;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

import superkit.language.NaturalNumber;

public class MutableCount implements Comparable<MutableCount>, Count
{
	public static int compare(MutableCount a, MutableCount b)
	{
		return a.compareTo(b);
	}

	private final AtomicLong count = new AtomicLong();

	public MutableCount()
	{
		this(CountValue.ZERO);
	}

	public MutableCount(NaturalNumber value)
	{
		this.count.set(value.get());
	}

	public void add(Count that)
	{
		this.count.set(get() + that.get());
	}

	@Override
	public int compareTo(MutableCount that)
	{
		final long thisValue = this.count.get();
		final long thatValue = that.count.get();
		if (thisValue < thatValue)
		{
			return -1;
		}
		if (thisValue > thatValue)
		{
			return 1;
		}
		return 0;
	}

	public void decrement()
	{
		this.count.decrementAndGet();
	}

	@Override
	public boolean equals(Object object)
	{
		if (object instanceof NaturalNumber)
		{
			final NaturalNumber number = (NaturalNumber) object;
			return this.count.get() == number.get();
		}
		return false;
	}

	@Override
	public long get()
	{
		return this.count.get();
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(this.count.get());
	}

	public void increment()
	{
		this.count.incrementAndGet();
	}

	public void maximize(NaturalNumber that)
	{
		this.count.set(Math.max(get(), that.get()));
	}

	public MutableCount set(NaturalNumber value)
	{
		this.count.set(value.get());
		return this;
	}

	@Override
	public String toString()
	{
		return this.count.toString();
	}
}
