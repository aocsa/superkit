package superkit.collections.arrays;

import superkit.language.bits.Bits;
import superkit.language.index.Index;

public class DynamicBooleanArray extends DynamicBitPackedArray
{
	public DynamicBooleanArray()
	{
		super(Bits.ONE);
	}

	public boolean is(Index index)
	{
		return get(index) == 0 ? false : true;
	}

	public void set(Index index, boolean value)
	{
		set(index, value ? 1 : 0);
	}
}
