package org.locke.superkit.language.identifier;

import java.util.Objects;

public class Identifier
{
	public static final Identifier ONE = new Identifier(1);
	public static final Identifier TWO = new Identifier(2);
	public static final Identifier THREE = new Identifier(3);
	public static final Identifier FOUR = new Identifier(4);
	public static final Identifier FIVE = new Identifier(5);
	public static final Identifier SIX = new Identifier(6);
	public static final Identifier SEVEN = new Identifier(7);
	public static final Identifier EIGHT = new Identifier(8);
	public static final Identifier NINE = new Identifier(9);
	public static final Identifier TEN = new Identifier(10);

	public static Identifier of(final long identifier)
	{
		if (identifier < Integer.MAX_VALUE)
		{
			switch ((int) identifier)
			{
				case 1:
					return ONE;

				case 2:
					return TWO;

				case 3:
					return THREE;

				case 4:
					return FOUR;

				case 5:
					return FIVE;

				case 6:
					return SIX;

				case 7:
					return SEVEN;

				case 8:
					return EIGHT;

				case 9:
					return NINE;

				case 10:
					return TEN;
			}
		}
		return new Identifier(identifier);
	}

	private final long identifier;

	private Identifier(final long identifier)
	{
		this.identifier = identifier;
	}

	public long asLong()
	{
		return identifier;
	}

	@Override
	public boolean equals(final Object object)
	{
		if (object instanceof Identifier)
		{
			final Identifier that = (Identifier) object;
			return identifier == that.identifier;
		}
		return false;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(identifier);
	}

	@Override
	public String toString()
	{
		return Long.toString(identifier);
	}
}
