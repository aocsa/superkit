package superkit.language.count;

import java.io.ObjectStreamException;
import java.text.NumberFormat;
import java.util.Objects;

import superkit.language.NaturalNumber;

public class CountValue implements Count
{
	private final long count;

	protected CountValue(long count)
	{
		this.count = count;
		if (count < 0)
		{
			throw new IllegalArgumentException("Negative count " + count);
		}
	}

	@Override
	public boolean equals(Object object)
	{
		if (object instanceof NaturalNumber)
		{
			final NaturalNumber number = (NaturalNumber) object;
			return this.count == number.get();
		}
		return false;
	}

	@Override
	public long get()
	{
		return this.count;
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(this.count);
	}

	@Override
	public String toString()
	{
		return NumberFormat.getNumberInstance().format(this.count);
	}

	private Object readResolve() throws ObjectStreamException
	{
		// Turns cached count values back into references in the cache
		return Count.of(this.count);
	}
}
