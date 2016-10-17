package superkit.messaging.messages;

import superkit.messaging.AbstractMessage;
import superkit.triage.Severity;

public class Problem extends AbstractMessage
{
	public Problem(final String message, final Object... arguments)
	{
		super(Severity.MEDIUM_HIGH, message, arguments);
	}
}
