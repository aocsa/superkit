package org.locke.superkit.path;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import org.locke.superkit.language.count.Count;

public class Path<Element> implements Iterable<Element>
{
	public static <T> Path<T> empty()
	{
		return new Path<T>();
	}

	public static <T> Path<T> of(Iterable<T> path)
	{
		final LinkedList<T> list = new LinkedList<>();
		for (final T element : path)
		{
			list.add(element);
		}
		return new Path<T>(list);
	}

	public static <T> Path<T> of(T element)
	{
		return new Path<T>(Collections.singletonList(element));
	}

	private final LinkedList<Element> path;

	private Path()
	{
		this.path = new LinkedList<Element>();
	}

	private Path(List<Element> path)
	{
		this.path = new LinkedList<Element>(path);
	}

	public Path<Element> child(Element child)
	{
		return child(of(child));
	}

	public Path<Element> child(Path<Element> path)
	{
		final LinkedList<Element> children = new LinkedList<>();
		children.addAll(this.path);
		children.addAll(path.path);
		return new Path<Element>(children);
	}

	public Count count()
	{
		return Count.of(size());
	}

	@Override
	public boolean equals(Object object)
	{
		if (object instanceof Path)
		{
			final Path<?> that = (Path<?>) object;
			return this.path.equals(that.path);
		}
		return false;
	}

	public Element first()
	{
		return this.path.getFirst();
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.path);
	}

	@Override
	public Iterator<Element> iterator()
	{
		return this.path.iterator();
	}

	public String join()
	{
		return join(".");
	}

	public String join(String delimiter)
	{
		final StringJoiner joiner = new StringJoiner(delimiter);
		for (final Element element : this)
		{
			joiner.add(element.toString());
		}
		return joiner.toString();
	}

	public Element last()
	{
		return this.path.getLast();
	}

	public Path<Element> parent()
	{
		if (this.path.size() > 1)
		{
			return new Path<Element>(this.path.subList(0, size() - 1));
		}
		throw new IllegalStateException("no parent of " + this);
	}

	public int size()
	{
		return this.path.size();
	}

	@Override
	public String toString()
	{
		return join();
	}
}
