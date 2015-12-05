package superkit.io.filesystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReader
{
	private final File file;

	public FileReader(File file)
	{
		this.file = file;
	}

	public List<String> lines()
	{
		try
		{
			return Files.readAllLines(this.file.toPath());
		}
		catch (final IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}
