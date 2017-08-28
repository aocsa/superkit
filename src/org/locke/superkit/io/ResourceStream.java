package org.locke.superkit.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResourceStream extends InputStream
{
	private final BufferedInputStream in;

	public ResourceStream(InputStream in)
	{
		this.in = buffer(in);
	}

	public BufferedReader bufferedReader()
	{
		return new BufferedReader(new InputStreamReader(this.in));
	}

	@Override
	public int read() throws IOException
	{
		return this.in.read();
	}

	BufferedInputStream buffer(InputStream in)
	{
		if (in instanceof BufferedInputStream)
		{
			return (BufferedInputStream) in;
		}
		else
		{
			return new BufferedInputStream(in);
		}
	}
}
