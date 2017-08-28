package org.locke.superkit.io.filesystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.locke.superkit.io.Resource;
import org.locke.superkit.io.ResourceStream;
import org.locke.superkit.language.strings.Strings;

public class File extends FileSystemObject implements Resource
{
	public File(Path path)
	{
		super(path);
	}

	public File(String path)
	{
		super(path);
	}

	public String asString()
	{
		try
		{
			return new String(Files.readAllBytes(path()));
		}
		catch (final IOException e)
		{
			throw new RuntimeException("unable to read " + this + ": " + e);
		}
	}

	public Extension extension()
	{
		if (name().contains("."))
		{
			return new Extension(Strings.after(name(), "."));
		}
		return null;
	}

	@Override
	public ResourceStream onOpenForReading()
	{
		try
		{
			return new ResourceStream(new FileInputStream(javaFile()));
		}
		catch (final FileNotFoundException e)
		{
			throw new RuntimeException("Couldn't open file for reading", e);
		}
	}

	public Folder parent()
	{
		if (isRoot())
		{
			return null;
		}
		return new Folder(path().getParent());
	}
}
