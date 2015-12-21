package superkit.language.string;

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
}
