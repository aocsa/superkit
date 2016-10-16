package superkit.collections.maps;

import java.util.HashMap;
import java.util.Map;

public class MapBuilder<K, V>
{
	private final Map<K, V> map = new HashMap<>();

	public Map<K, V> build()
	{
		return this.map;
	}

	public MapBuilder<K, V> with(K key, V value)
	{
		this.map.put(key, value);
		return this;
	}
}
