package superkit.messaging.messages;

import superkit.messaging.AbstractMessage;
import superkit.values.Severity;

public class Warning extends AbstractMessage
{
    public Warning(final String message, final Object... arguments)
    {
        super(Severity.MEDIUM, message, arguments);
    }
}
