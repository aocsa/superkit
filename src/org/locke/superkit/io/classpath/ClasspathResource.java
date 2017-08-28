package org.locke.superkit.io.classpath;

import org.locke.superkit.io.Resource;
import org.locke.superkit.io.ResourceStream;

public class ClasspathResource implements Resource
{
	private final Class<?> type;
	private final String path;

	public ClasspathResource(Class<?> type, String path)
	{
		this.type = type;
		this.path = path;
	}

	@Override
	public ResourceStream onOpenForReading()
	{
		return new ResourceStream(this.type.getResourceAsStream(this.path));
	}
}
