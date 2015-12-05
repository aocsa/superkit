package superkit.io.serialization;

public interface SerialWriter<T>
{
    /**
     * Writes the given object to the given {@link SerialOutput}
     */
    void write(SerialOutput output, T object);
}
