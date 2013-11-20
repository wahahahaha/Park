package com.thirdparty.thread;

import java.util.Observable;
import java.util.Observer;

public class ThreadManager extends Observable
{
	public final static int CANCEL_ALL = 1;

	public void cancelAll()
	{
		setChanged();
		notifyObservers(CANCEL_ALL);
	}

	public void addTask(Observer task)
	{
		super.addObserver(task);
	}
}
