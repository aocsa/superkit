package org.locke.superkit.language.identifier;

import java.util.Objects;

public class Identifier
{
	public static final Identifier ONE = of(1);
	public static final Identifier TWO = of(2);
	public static final Identifier THREE = of(3);

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
}
