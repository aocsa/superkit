package superkit.io.filesystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import superkit.io.Resource;
import superkit.io.ResourceStream;

public class File implements Resource
{
	private final java.io.File file;

	public File(String path)
	{
		this.file = new java.io.File(path);
	}

	@Override
	public ResourceStream onOpenForReading()
	{
		try
		{
			return new ResourceStream(new FileInputStream(this.file));
		}
		catch (final FileNotFoundException e)
		{
			throw new RuntimeException("Couldn't open file for reading", e);
		}
	}
}
