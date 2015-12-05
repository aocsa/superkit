package superkit.messaging.messages;

import superkit.messaging.AbstractMessage;
import superkit.values.Severity;

public class Problem extends AbstractMessage
{
    public Problem(final String message, final Object... arguments)
    {
        super(Severity.HIGH, message, arguments);
    }
}
