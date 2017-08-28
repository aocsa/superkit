package org.locke.superkit.messaging;

import org.locke.superkit.triage.Severity;
import org.locke.superkit.triage.Triaged;

public class AbstractMessage implements Triaged, Message
{
	private final Severity severity;
	@SuppressWarnings("unused")
	private final String message;
	@SuppressWarnings("unused")
	private final Object[] arguments;

	public AbstractMessage(final Severity severity, final String message, final Object[] arguments)
	{
		this.severity = severity;
		this.message = message;
		this.arguments = arguments;
	}

	@Override
	public String formatted()
	{
		return null;
	}

	@Override
	public Severity severity()
	{
		return this.severity;
	}
}
