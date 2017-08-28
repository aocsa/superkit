package org.locke.superkit.language;

public class MutableValue<T>
{
	private T value;

	public MutableValue()
	{
	}

	public MutableValue(T value)
	{
		set(value);
	}

	public T get()
	{
		return this.value;
	}

	public void set(T value)
	{
		this.value = value;
	}

	@Override
	public String toString()
	{
		return this.value.toString();
	}
}
