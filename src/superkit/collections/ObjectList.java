package superkit.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import superkit.count.Count;

public class ObjectList<T>
{
	private final List<T> objects;

	public ObjectList()
	{
		this(new ArrayList<T>());
	}

	public ObjectList(List<T> objects)
	{
		this.objects = objects;
	}

	public T get(int index)
	{
		return this.objects.get(index);
	}

	public String join()
	{
		return join(", ");
	}

	public String join(String delimiter)
	{
		return join(new StringJoiner(delimiter));
	}

	public String join(StringJoiner joiner)
	{
		for (final T object : this.objects)
		{
			joiner.add(object.toString());
		}
		return joiner.toString();
	}

	public T safeGet(int index)
	{
		if (index < this.objects.size())
		{
			return this.objects.get(index);
		}
		return null;
	}

	public void set(int index, T object)
	{
		while (index >= this.objects.size())
		{
			this.objects.add(null);
		}
		this.objects.set(index, object);
	}

	public Count size()
	{
		return Count.forLong(this.objects.size());
	}
}
