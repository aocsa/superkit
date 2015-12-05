package superkit.messaging.broadcasters;

import superkit.messaging.messages.Warning;

public class WarningMulticaster extends MessageTypeMulticaster<Warning>
{
    public WarningMulticaster()
    {
        super(Warning.class);
    }
}
