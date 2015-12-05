package superkit.messaging.messages;

import superkit.messaging.AbstractMessage;
import superkit.triage.Severity;

public class Information extends AbstractMessage
{
    public Information(final String message, final Object... arguments)
    {
        super(Severity.LOW, message, arguments);
    }
}
