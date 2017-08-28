package org.locke.superkit.messaging.broadcasters;

import org.locke.superkit.messaging.messages.Warning;

public class WarningMulticaster extends MessageTypeMulticaster<Warning>
{
    public WarningMulticaster()
    {
        super(Warning.class);
    }
}
