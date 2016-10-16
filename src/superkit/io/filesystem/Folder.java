package superkit.io.filesystem;

import java.nio.file.Path;

public class Folder extends FileSystemObject
{
	public Folder(Path path)
	{
		super(path);
	}

	public Folder(String path)
	{
		super(path);
	}

	public File file(String name)
	{
		return new File(path().resolve(name));
	}

	public Folder parent()
	{
		if (path().getParent() == null)
		{
			return null;
		}
		return new Folder(path().getParent());
	}
}
