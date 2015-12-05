package superkit.triage;

import superkit.math.ZeroToOne;

public class Priority extends ZeroToOne
{
    public static Priority HIGH = new Priority(0.75);
    public static Priority MEDIUM = new Priority(0.5);
    public static Priority LOW = new Priority(0.25);

    public Priority(double value)
    {
        super(value);
    }
}
