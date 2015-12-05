package superkit.messaging.broadcasters;

import java.util.ArrayList;
import java.util.List;

import superkit.messaging.Broadcaster;
import superkit.messaging.Listener;
import superkit.messaging.Message;
import superkit.messaging.Speaker;

public class Multicaster implements Speaker, Broadcaster
{
    private final List<Listener> listeners = new ArrayList<Listener>();

    @Override
    public void ignore(final Listener listener)
    {
        this.listeners.remove(listener);
    }

    @Override
    public void listen(final Listener listener)
    {
        this.listeners.add(listener);
    }

    @Override
    public void say(final Message message)
    {
        for (final Listener listener : this.listeners)
        {
            listener.onHear(message);
        }
    }
}
