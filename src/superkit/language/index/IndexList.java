package superkit.language.index;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import superkit.collections.lists.ObjectList;
import superkit.language.NaturalNumber;
import superkit.language.count.Count;

public class IndexList implements Iterable<Index>
{
	private final List<Index> indexes = new ArrayList<Index>();

	public IndexList add(Index index)
	{
		this.indexes.add(index);
		return this;
	}

	public boolean contains(Index index)
	{
		return this.indexes.contains(index);
	}

	@Override
	public boolean equals(Object object)
	{
		if (object instanceof IndexList)
		{
			final IndexList that = (IndexList) object;
			return this.indexes.equals(that.indexes);
		}
		return false;
	}

	public Index first()
	{
		return this.indexes.get(0);
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(this.indexes);
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

	public String join()
	{
		return new ObjectList<Index>(this.indexes).join();
	}

	public String join(String separator)
	{
		return new ObjectList<Index>(this.indexes).join(separator);
	}

	public Index last()
	{
		return this.indexes.get(this.indexes.size() - 1);
	}

	public IndexList offsetAll(NaturalNumber offset)
	{
		for (int i = 0; i < this.indexes.size(); i++)
		{
			this.indexes.set(i, this.indexes.get(i).add(offset));
		}
		return this;
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
		return join();
	}
}
