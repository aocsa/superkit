package org.locke.superkit.language.count;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CountMap<T>
{
	private final Map<T, MutableCount> counts = new HashMap<>();

	public Count count(T key)
	{
		final MutableCount count = this.counts.get(key);
		return count == null ? CountValue.ZERO : count.asCount();
	}

	public void increment(T key)
	{
		ensure(key).increment();
	}

	public Count maximumCount()
	{
		return this.counts.values().stream().max(MutableCount::compare).get().asCount();
	}

	public Set<T> mostFrequent()
	{
		final Count maximum = maximumCount();
		return this.counts.keySet().stream().filter(key -> count(key).equals(maximum)).collect(Collectors.toSet());
	}

	private MutableCount ensure(T key)
	{
		MutableCount count = this.counts.get(key);
		if (count == null)
		{
			this.counts.put(key, count = new MutableCount());
		}
		return count;
	}
}
