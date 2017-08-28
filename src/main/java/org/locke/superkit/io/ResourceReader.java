package org.locke.superkit.io;

public class ResourceReader
{
	private final Resource resource;

	public ResourceReader(Resource resource)
	{
		this.resource = resource;
	}

	public LineReader lines()
	{
		return new LineReader(this.resource.openForReading().bufferedReader());
	}
}
