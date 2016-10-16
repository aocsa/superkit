package superkit.io.filesystem;

import java.util.Objects;

public class Extension
{
	public static Extension of(String extension)
	{
		return new Extension(extension);
	}

	private final String extension;

	public Extension(String extension)
	{
		if (extension.startsWith("."))
		{
			this.extension = extension;
		}
		else
		{
			this.extension = "." + extension;
		}
	}

	@Override
	public boolean equals(Object object)
	{
		if (object instanceof Extension)
		{
			final Extension that = (Extension) object;
			return this.extension.equals(that.extension);
		}
		return false;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.extension);
	}

	@Override
	public String toString()
	{
		return this.extension;
	}
}
