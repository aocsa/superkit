package org.locke.superkit.messaging.messages;

import org.locke.superkit.messaging.AbstractMessage;
import org.locke.superkit.triage.Severity;

public class Problem extends AbstractMessage
{
	public Problem(final String message, final Object... arguments)
	{
		super(Severity.MEDIUM_HIGH, message, arguments);
	}
}
