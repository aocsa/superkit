package org.locke.superkit.collections;

import java.util.Iterator;

public abstract class AbstractIterator<T> implements Iterator<T>
{
	private T current = findNext();

	@Override
	public boolean hasNext()
	{
		return this.current != null;
	}

	@Override
	public T next()
	{
		final T next = this.current;
		this.current = findNext();
		return next;
	}

	protected abstract T findNext();
}
