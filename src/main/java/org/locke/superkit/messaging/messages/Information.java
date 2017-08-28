package org.locke.superkit.messaging.messages;

import org.locke.superkit.messaging.AbstractMessage;
import org.locke.superkit.triage.Severity;

public class Information extends AbstractMessage
{
    public Information(final String message, final Object... arguments)
    {
        super(Severity.LOW, message, arguments);
    }
}
