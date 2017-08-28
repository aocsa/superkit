package org.locke.superkit.messaging.broadcasters;

import org.locke.superkit.messaging.messages.Problem;

public class ProblemMulticaster extends MessageTypeMulticaster<Problem>
{
    public ProblemMulticaster()
    {
        super(Problem.class);
    }
}
