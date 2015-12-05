package superkit.messaging.broadcasters;

import superkit.messaging.messages.Problem;

public class ProblemMulticaster extends MessageTypeMulticaster<Problem>
{
    public ProblemMulticaster()
    {
        super(Problem.class);
    }
}
