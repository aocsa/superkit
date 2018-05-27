package org.locke.superkit.language.validation;

public class Require
{
	public static void is(final boolean truth)
	{
		if (!truth)
		{
			throw new IllegalStateException("True is required");
		}
	}

	public static void nonNull(final Object object)
	{
		if (object == null)
		{
			throw new IllegalStateException("Non-null object is required");
		}
	}
}
