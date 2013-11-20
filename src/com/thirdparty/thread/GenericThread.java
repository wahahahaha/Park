package com.thirdparty.thread;

import java.util.Observable;
import java.util.Observer;

import android.os.AsyncTask;

public abstract class GenericThread extends
        AsyncTask<ThreadParams, Object, ThreadResult> implements Observer
{
	private boolean hasCancelAble = true;
	private ThreadListener mListener = null;

	protected abstract ThreadResult _doInBackground(ThreadParams... params);

	public void setTaskListener(ThreadListener listener)
	{
		mListener = listener;
	}

	public void doPublishProgress(Object... values)
	{
		super.publishProgress(values);
	}

	@Override
	protected ThreadResult doInBackground(ThreadParams... params)
	{
		// TODO Auto-generated method stub
		ThreadResult result = _doInBackground(params);
		return result;
	}

	@Override
	protected void onCancelled()
	{
		// TODO Auto-generated method stub
		super.onCancelled();

		if (null != mListener)
		{
			mListener.onCancelled(this);
		}
	}

	@Override
	protected void onPostExecute(ThreadResult result)
	{
		// TODO Auto-generated method stub
		super.onPostExecute(result);

		if (null != mListener)
		{
			mListener.onPostExecute(this, result);
		}
	}

	@Override
	protected void onPreExecute()
	{
		// TODO Auto-generated method stub
		super.onPreExecute();

		if (null != mListener)
		{
			mListener.onPreExecute(this);
		}
	}

	@Override
	protected void onProgressUpdate(Object... values)
	{
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
		if (null != mListener)
		{
			if (null != values && values.length > 0)
			{
				mListener.onProgressUpdate(this, values[0]);
			}
		}
	}

	@Override
	public void update(Observable observable, Object data)
	{
		// TODO Auto-generated method stub
		if (ThreadManager.CANCEL_ALL == (Integer) data && hasCancelAble == true)
		{
			if (getStatus() == GenericThread.Status.RUNNING)
			{
				cancel(true);
			}
		}
	}

	public void setCancelAble(boolean hasCancelAble)
	{
		this.hasCancelAble = hasCancelAble;
	}
}
