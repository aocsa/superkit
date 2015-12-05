package superkit.io.serialization;

public interface SerialWritable<T>
{
    SerialWriter<T> serialWriter();
}
