package superkit.messaging;

import superkit.values.Severity;
import superkit.values.Triaged;

public class AbstractMessage implements Triaged, Message
{
    private final Severity severity;
    private final String message;
    private final Object[] arguments;

    public AbstractMessage(final Severity severity, final String message, final Object[] arguments)
    {
        this.severity = severity;
        this.message = message;
        this.arguments = arguments;
    }

    @Override
    public String formatted()
    {
        return null;
    }

    @Override
    public Severity severity()
    {
        return this.severity;
    }
}
