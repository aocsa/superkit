package org.locke.superkit.data.conversion;

import org.locke.superkit.messaging.Broadcaster;

public interface StringConverter<T> extends Broadcaster
{
    T toObject(String string);

    String toString(T object);
}
