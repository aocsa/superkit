package superkit.count;

public class CountValueCache
{
	private final Count[] cache = new Count[4096];

	public CountValueCache()
	{
		for (int i = 0; i < this.cache.length; i++)
		{
			this.cache[i] = new CountValue(i);
		}
	}

	public Count forLong(long value)
	{
		if (value < this.cache.length)
		{
			return this.cache[(int) value];
		}
		return new CountValue(value);
	}
}
