package org.locke.superkit.messaging.messages;

import org.locke.superkit.messaging.AbstractMessage;
import org.locke.superkit.triage.Severity;

public class Warning extends AbstractMessage
{
    public Warning(final String message, final Object... arguments)
    {
        super(Severity.MEDIUM, message, arguments);
    }
}
