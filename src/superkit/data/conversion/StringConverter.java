package superkit.data.conversion;

import superkit.messaging.Broadcaster;

public interface StringConverter<T> extends Broadcaster
{
    T toObject(String string);

    String toString(T object);
}
