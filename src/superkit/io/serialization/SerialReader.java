package superkit.io.serialization;

public interface SerialReader<T>
{
    /**
     * @return The next object read from the given {@link SerialInput}
     */
    T read(SerialInput input);
}
