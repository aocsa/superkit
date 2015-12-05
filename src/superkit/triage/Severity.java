package superkit.triage;

import superkit.math.ZeroToOne;

public class Severity extends ZeroToOne
{
    public static Severity HIGH = new Severity(0.75);
    public static Severity MEDIUM = new Severity(0.5);
    public static Severity LOW = new Severity(0.25);

    public Severity(double value)
    {
        super(value);
    }
}
