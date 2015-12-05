package superkit.io.serialization;

public interface SerialInput
{
    /**
     * Reads object of the given type
     * 
     * @param object
     *            The object to read
     */
    <T> T read(Class<T> type);
}
