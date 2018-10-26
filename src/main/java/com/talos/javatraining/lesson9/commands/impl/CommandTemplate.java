package com.talos.javatraining.lesson9.commands.impl;

import com.talos.javatraining.lesson9.commands.AppCommand;
import com.talos.javatraining.lesson9.events.EventBus;
import com.talos.javatraining.lesson9.events.EventType;


public class CommandTemplate implements AppCommand
{

	private String[] args;
	private EventBus eventBus;
	String command;

	public CommandTemplate(EventBus eventBus, String command, String... args)
	{
		this.args = args;
		this.eventBus = eventBus;
		this.command = command;
	}

	@Override
	public void execute()
	{
		eventBus.notify(getEvent(), args);
	}

	public EventType getEvent()
	{
		return EventType.valueOf(command);
	}
}
