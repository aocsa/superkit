package superkit.language.count;

public class Bits extends CountValue
{
	private long mask;

	public Bits(long count)
	{
		super(count);
		for (long i = 0; i < count; i++)
		{
			this.mask <<= 1;
			this.mask |= 1;
		}
	}

	public long mask()
	{
		return this.mask;
	}

	public long maximumValue()
	{
		return this.mask;
	}
}
