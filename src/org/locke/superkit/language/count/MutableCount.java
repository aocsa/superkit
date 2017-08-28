package org.locke.superkit.language.count;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

import org.locke.superkit.language.NaturalNumber;

public class MutableCount implements Count
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
		count.set(value.get());
	}

	public MutableCount add(Count that)
	{
		count.set(get() + that.get());
		return this;
	}

	public void decrement()
	{
		count.decrementAndGet();
	}

	@Override
	public boolean equals(Object object)
	{
		if (object instanceof NaturalNumber)
		{
			final NaturalNumber number = (NaturalNumber) object;
			return count.get() == number.get();
		}
		return false;
	}

	@Override
	public long get()
	{
		return count.get();
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(count.get());
	}

	public void increment()
	{
		count.incrementAndGet();
	}

	public boolean isGreaterThanZero()
	{
		return count.get() > 0;
	}

	public void maximize(NaturalNumber that)
	{
		count.set(Math.max(get(), that.get()));
	}

	public void minimize(NaturalNumber that)
	{
		count.set(Math.min(get(), that.get()));
	}

	public MutableCount set(NaturalNumber value)
	{
		count.set(value.get());
		return this;
	}

	@Override
	public String toString()
	{
		return count.toString();
	}
}
