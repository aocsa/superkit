package superkit.messaging.messages;

import superkit.messaging.AbstractMessage;
import superkit.triage.Severity;

public class Fatal extends AbstractMessage
{
    public Fatal(final String message, final Object... arguments)
    {
        super(Severity.HIGH, message, arguments);
    }
}
