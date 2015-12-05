package superkit.language;

public interface Comparison<T>
{
    default Comparison<T> forComparable(final Comparable<T> comparable)
    {
        return new Comparison<T>()
        {
            @Override
            public boolean isEqualTo(final T that)
            {
                return comparable.compareTo(that) == 0;
            }

            @Override
            public boolean isGreaterThan(final T that)
            {
                return comparable.compareTo(that) > 0;
            }

            @Override
            public boolean isGreaterThanOrEqualTo(final T that)
            {
                return comparable.compareTo(that) >= 0;
            }

            @Override
            public boolean isLessThan(final T that)
            {
                return comparable.compareTo(that) < 0;
            }

            @Override
            public boolean isLessThanOrEqualTo(final T that)
            {
                return comparable.compareTo(that) <= 0;
            }
        };
    }

    boolean isEqualTo(T that);

    boolean isGreaterThan(T that);

    boolean isGreaterThanOrEqualTo(T that);

    boolean isLessThan(T that);

    boolean isLessThanOrEqualTo(T that);
}
