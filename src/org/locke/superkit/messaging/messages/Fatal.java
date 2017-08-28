package org.locke.superkit.messaging.messages;

import org.locke.superkit.messaging.AbstractMessage;
import org.locke.superkit.triage.Severity;

public class Fatal extends AbstractMessage
{
    public Fatal(final String message, final Object... arguments)
    {
        super(Severity.HIGH, message, arguments);
    }
}
