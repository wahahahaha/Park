package com.thirdparty.thread;

public abstract class ThreadAdapter implements ThreadListener
{
	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public void onPreExecute(GenericThread task)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void onPostExecute(GenericThread task, ThreadResult result)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void onProgressUpdate(GenericThread task, Object param)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void onCancelled(GenericThread task)
	{
		// TODO Auto-generated method stub
	}

}
