package superkit.data.conversion;

public interface Converter<From, To>
{
    To convert(From value);
}
