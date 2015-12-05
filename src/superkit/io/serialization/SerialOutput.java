package superkit.io.serialization;

public interface SerialOutput
{
    /**
     * Begins the serialization of an object that can be re-read using an
     * instance of the given {@link SerialReader}-implementing class.
     * 
     * @param type
     *            The reader class to use to re-read what is written by calls to
     *            {@link #write(Object)} at a later time.
     */
    void begin(Class<? extends SerialReader<?>> reader);

    /**
     * Writes out a given object
     * 
     * @param object
     *            The object to write
     */
    void write(Object object);
}
