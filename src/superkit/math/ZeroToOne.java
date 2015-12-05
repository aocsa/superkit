package superkit.math;

import superkit.language.Comparison;

public class ZeroToOne implements Comparison<ZeroToOne>
{
    private final double value;

    public ZeroToOne(final double value)
    {
        if (value < 0)
        {
            throw new IllegalArgumentException("ZeroToOne value cannot be less than zero");
        }
        if (value > 1)
        {
            throw new IllegalArgumentException("ZeroToOne value cannot be greater than one");
        }
        this.value = value;
    }

    @Override
    public boolean isEqualTo(ZeroToOne that)
    {
        return this.value == that.value;
    }

    @Override
    public boolean isGreaterThan(ZeroToOne that)
    {
        return this.value > that.value;
    }

    @Override
    public boolean isGreaterThanOrEqualTo(ZeroToOne that)
    {
        return this.value >= that.value;
    }

    @Override
    public boolean isLessThan(ZeroToOne that)
    {
        return this.value < that.value;
    }

    @Override
    public boolean isLessThanOrEqualTo(ZeroToOne that)
    {
        return this.value <= that.value;
    }
}
