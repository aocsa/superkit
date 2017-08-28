package org.locke.superkit.data.conversion;

import org.locke.superkit.messaging.Listener;
import org.locke.superkit.messaging.broadcasters.MessageTypeMulticaster;
import org.locke.superkit.messaging.broadcasters.WarningMulticaster;

public abstract class AbstractStringConverter<T> implements StringConverter<T>
{
    private MessageTypeMulticaster<?> multicaster = new WarningMulticaster();
    private boolean allowNullInput = false;

    @Override
    public void ignore(final Listener listener)
    {
        this.multicaster.ignore(listener);
    }

    @Override
    public void listen(final Listener listener)
    {
        this.multicaster.listen(listener);
    }

    public void say(final String message, final Object... parameters)
    {
        this.multicaster.say(message, parameters);
    }

    public AbstractStringConverter<T> setAllowNullInput(final boolean allowNullInput)
    {
        this.allowNullInput = allowNullInput;
        return this;
    }

    public AbstractStringConverter<T> setMulticaster(final MessageTypeMulticaster<?> multicaster)
    {
        this.multicaster = multicaster;
        return this;
    }

    @Override
    public final T toObject(final String string)
    {
        if (string == null)
        {
            if (this.allowNullInput)
            {
                return null;
            }
            else
            {
                say("Could not convert null input string");
            }
        }
        final T value = onToObject(string);
        if (value == null)
        {

        }
        return value;
    }

    @Override
    public final String toString(final T object)
    {
        return onToString(object);
    }

    protected abstract T onToObject(final String string);

    protected abstract String onToString(T object);
}
