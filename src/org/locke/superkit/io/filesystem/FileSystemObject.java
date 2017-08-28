package org.locke.superkit.io.filesystem;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemObject
{
	private final java.io.File file;

	public FileSystemObject(Path path)
	{
		this.file = path.toFile();
	}

	public FileSystemObject(String path)
	{
		this(Paths.get(path));
	}

	public boolean exists()
	{
		return this.file.exists();
	}

	public boolean isRoot()
	{
		return path().getNameCount() == 0;
	}

	public String name()
	{
		return javaFile().getName();
	}

	public Path path()
	{
		return javaFile().toPath();
	}

	@Override
	public String toString()
	{
		return javaFile().toString();
	}

	protected java.io.File javaFile()
	{
		return this.file;
	}
}
