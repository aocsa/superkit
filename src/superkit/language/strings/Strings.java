package superkit.language.strings;

import superkit.language.count.Count;

public class Strings
{
	public static String after(String within, String after)
	{
		final int index = within.indexOf(after);
		if (index != -1)
		{
			return within.substring(index);
		}
		return within;
	}

	public static boolean isCapitalized(String string)
	{
		return string.length() > 0 && Character.isUpperCase(string.charAt(0));
	}

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

	public static String spaceAfter(Object object)
	{
		if (object == null || object.toString().isEmpty())
		{
			return "";
		}
		return object + " ";
	}

	public static String spaceBefore(Object object)
	{
		if (object == null || object.toString().isEmpty())
		{
			return "";
		}
		return " " + object;
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
