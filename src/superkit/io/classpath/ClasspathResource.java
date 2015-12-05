package superkit.io.classpath;

import superkit.io.Resource;
import superkit.io.ResourceStream;

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
