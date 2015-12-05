package superkit.values;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

import superkit.io.serialization.AbstractSerialReader;
import superkit.io.serialization.SerialInput;
import superkit.language.Comparison;

public class Count implements Countable, Comparison<Count>, Serializable
{
    public static class SerialReader extends AbstractSerialReader<Count>
    {
        @Override
        public Count read(final SerialInput input)
        {
            return of(input.read(Integer.class));
        }
    }

    private static final long serialVersionUID = 5428111732952843297L;

    private static Count[] cache = new Count[4096];

    static
    {
        for (int index = 0; index < Count.cache.length; index++)
        {
            Count.cache[index] = new Count(index);
        }
    }

    public static Count of(final int count)
    {
        if (count < 0)
        {
            throw new IllegalArgumentException("Negative count not allowed");
        }
        if (count < Count.cache.length)
        {
            return Count.cache[count];
        }
        return new Count(count);
    }

    public static Count of(final long count)
    {
        if (count < 0)
        {
            throw new IllegalArgumentException("Negative count not allowed");
        }
        if (count < Count.cache.length)
        {
            return Count.cache[(int) count];
        }
        return new Count(count);
    }

    private final long count;

    private Count(final long count)
    {
        if (count < 0)
        {
            throw new IllegalArgumentException("Negative count not allowed");
        }
        this.count = count;
    }

    @Override
    public Count count()
    {
        return this;
    }

    @Override
    public boolean equals(final Object that)
    {
        if (that instanceof Count)
        {
            return this.count == ((Count) that).count;
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.count);
    }

    @Override
    public boolean isEqualTo(final Count that)
    {
        return this.count == that.count;
    }

    @Override
    public boolean isGreaterThan(final Count that)
    {
        return this.count > that.count;
    }

    @Override
    public boolean isGreaterThanOrEqualTo(final Count that)
    {
        return this.count >= that.count;
    }

    @Override
    public boolean isLessThan(final Count that)
    {
        return this.count < that.count;
    }

    @Override
    public boolean isLessThanOrEqualTo(final Count that)
    {
        return this.count <= that.count;
    }

    @Override
    public String toString()
    {
        return NumberFormat.getNumberInstance(Locale.getDefault()).format(this.count);
    }

    private Object readResolve() throws ObjectStreamException
    {
        // Turns cached count values back into references in the cache
        return Count.of(this.count);
    }
}
