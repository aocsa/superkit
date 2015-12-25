package superkit.language.string;

import superkit.language.count.Count;

public class Strings
{
	public static String leftPad(String string, char c, int length)
	{
		if (string.length() < length)
		{
			final StringBuilder builder = new StringBuilder();
			for (int i = 0; i < length - string.length(); i++)
			{
				builder.append(c);
			}
			builder.append(string);
			return builder.toString();
		}
		return string;
	}

	public static String wrap(String string, Count columns)
	{
		final StringBuilder builder = new StringBuilder();
		for (int i = 0; i < string.length(); i++)
		{
			if (i != 0 && i % columns.asInteger() == 0)
			{
				builder.append('\n');
			}
			builder.append(string.charAt(i));
		}
		return builder.toString();
	}
}
