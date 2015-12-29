package superkit.collections.sets;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ObjectSet<T> implements Set<T>
{
	private final Set<T> set = new HashSet<>();

	public ObjectSet()
	{
	}

	@SafeVarargs
	public ObjectSet(T... objects)
	{
		for (final T object : objects)
		{
			this.set.add(object);
		}
	}

	@Override
	public boolean add(T e)
	{
		return this.set.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends T> c)
	{
		return this.set.addAll(c);
	}

	@Override
	public void clear()
	{
		this.set.clear();
	}

	@Override
	public boolean contains(Object o)
	{
		return this.set.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c)
	{
		return this.set.containsAll(c);
	}

	@Override
	public boolean isEmpty()
	{
		return this.set.isEmpty();
	}

	@Override
	public Iterator<T> iterator()
	{
		return this.set.iterator();
	}

	@Override
	public boolean remove(Object o)
	{
		return this.set.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		return this.set.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		return this.set.retainAll(c);
	}

	@Override
	public int size()
	{
		return this.set.size();
	}

	@Override
	public Object[] toArray()
	{
		return this.set.toArray();
	}

	@Override
	public <S> S[] toArray(S[] a)
	{
		return this.set.toArray(a);
	}
}
