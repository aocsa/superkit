package org.locke.superkit.language.index;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

import org.locke.superkit.language.NaturalNumber;

public class MutableIndex implements Index
{
	private final AtomicLong index = new AtomicLong();

	public MutableIndex()
	{
		this(0);
	}

	public MutableIndex(Index index)
	{
		this(index.get());
	}

	public MutableIndex(long index)
	{
		if (index < 0)
		{
			throw new IllegalArgumentException("Negative index " + index);
		}
		this.index.set(index);
	}

	public void decrement()
	{
		this.index.decrementAndGet();
	}

	@Override
	public boolean equals(Object object)
	{
		if (object instanceof NaturalNumber)
		{
			final NaturalNumber number = (NaturalNumber) object;
			return get() == number.get();
		}
		return false;
	}

	@Override
	public long get()
	{
		return this.index.get();
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(this.index);
	}

	public void increment()
	{
		this.index.incrementAndGet();
	}

	public void set(long index)
	{
		this.index.set(index);
	}

	@Override
	public String toString()
	{
		return Long.toString(this.index.get());
	}
}
