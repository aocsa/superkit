package superkit.messaging.broadcasters;

import java.lang.reflect.Constructor;

import superkit.messaging.Message;

public class MessageTypeMulticaster<T extends Message> extends Multicaster
{
    private Constructor<T> constructor;

    public MessageTypeMulticaster(final Class<T> messageType)
    {
        try
        {
            this.constructor = messageType.getConstructor(String.class, Object[].class);
        }
        catch (final Exception e)
        {
            throw new RuntimeException("Could not find constructor " + messageType.getSimpleName()
                    + "(String message, Object... parameters)");
        }
    }

    public void say(final String message, final Object... parameters)
    {
        try
        {
            say(this.constructor.newInstance(message, parameters));
        }
        catch (final Exception e)
        {
            throw new RuntimeException("Unable to construct message: " + this.constructor);
        }
    }
}
