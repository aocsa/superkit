package superkit.language.index;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import superkit.collections.ObjectList;
import superkit.language.count.Count;

public class IndexList implements Iterable<Index>
{
	private final List<Index> indexes = new ArrayList<Index>();

	public void add(Index index)
	{
		this.indexes.add(index);
	}

	public Index first()
	{
		return this.indexes.get(0);
	}

	public boolean isEmpty()
	{
		return this.indexes.isEmpty();
	}

	@Override
	public Iterator<Index> iterator()
	{
		return this.indexes.iterator();
	}

	public Index last()
	{
		return this.indexes.get(this.indexes.size() - 1);
	}

	public void removeFirst()
	{
		this.indexes.remove(0);
	}

	public Count size()
	{
		return Count.of(this.indexes.size());
	}

	@Override
	public String toString()
	{
		return new ObjectList<Index>(this.indexes).join();
	}
}
