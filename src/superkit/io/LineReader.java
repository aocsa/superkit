package superkit.io;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import superkit.collections.AbstractIterator;

public class LineReader implements Iterable<String>, Closeable
{
	private final BufferedReader in;

	public LineReader(BufferedReader in)
	{
		this.in = in;
	}

	public List<String> asList()
	{
		final List<String> all = new ArrayList<>();
		for (final String line : this)
		{
			all.add(line);
		}
		return all;
	}

	@Override
	public void close() throws IOException
	{
		this.in.close();
	}

	@Override
	public Iterator<String> iterator()
	{
		return new AbstractIterator<String>()
		{
			@Override
			protected String findNext()
			{
				try
				{
					return LineReader.this.in.readLine();
				}
				catch (final IOException e)
				{
					throw new RuntimeException("Unable to read next line", e);
				}
			}
		};
	}
}
