package superkit.messaging;

public interface Broadcaster
{
    void ignore(Listener listener);

    void listen(Listener listener);
}
