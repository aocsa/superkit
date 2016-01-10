package superkit.collections.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.BiConsumer;

import superkit.language.count.Count;
import superkit.language.index.Index;

public class ObjectList<T> implements Iterable<T>
{
	private final List<T> objects;

	public ObjectList()
	{
		this(new ArrayList<>());
	}

	public ObjectList(Iterable<T> objects)
	{
		this.objects = new ArrayList<>();
		for (final T object : objects)
		{
			this.objects.add(object);
		}
	}

	public ObjectList(List<T> objects)
	{
		this.objects = objects;
	}

	public void add(T object)
	{
		this.objects.add(object);
	}

	public boolean contains(T object)
	{
		return this.objects.contains(object);
	}

	public void forEach(BiConsumer<T, Index> consumer)
	{
		for (final Index index : size())
		{
			consumer.accept(get(index), index);
		}
	}

	public T get(Index index)
	{
		return this.objects.get(index.asInteger());
	}

	public boolean isEmpty()
	{
		return this.objects.isEmpty();
	}

	@Override
	public Iterator<T> iterator()
	{
		return this.objects.iterator();
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

	public T safeGet(Index index)
	{
		if (index.asInteger() < this.objects.size())
		{
			return this.objects.get(index.asInteger());
		}
		return null;
	}

	public void set(Index index, T object)
	{
		while (index.get() >= this.objects.size())
		{
			this.objects.add(null);
		}
		this.objects.set(index.asInteger(), object);
	}

	public Count size()
	{
		return Count.of(this.objects.size());
	}

	public void sort(Comparator<T> comparator)
	{
		Collections.sort(this.objects, comparator);
	}

	@Override
	public String toString()
	{
		return join();
	}
}
