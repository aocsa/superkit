package superkit.io;

public interface Resource
{
	public default ResourceStream openForReading()
	{
		return onOpenForReading();
	}

	public default ResourceReader reader()
	{
		return new ResourceReader(this);
	}

	ResourceStream onOpenForReading();
}
