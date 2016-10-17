package superkit.triage;

import superkit.math.ZeroToOne;

public class Severity extends ZeroToOne
{
	public static final Severity HIGH = new Severity(0.75);
	public static final Severity MEDIUM_HIGH = new Severity(0.625);
	public static final Severity MEDIUM = new Severity(0.5);
	public static final Severity LOW = new Severity(0.25);

	public Severity(double value)
	{
		super(value);
	}
}
