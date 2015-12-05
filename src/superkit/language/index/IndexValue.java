package superkit.language.index;

import java.util.Objects;

import superkit.language.NaturalNumber;

public class IndexValue implements Index
{
	private final long index;

	IndexValue(long index)
	{
		if (index < 0)
		{
			throw new IllegalArgumentException("Negative index " + index);
		}
		this.index = index;
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
		return this.index;
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(this.index);
	}

	@Override
	public String toString()
	{
		return Long.toString(this.index);
	}
}
