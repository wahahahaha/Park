package com.thirdparty.thread;

public interface ThreadListener {
	String getName();

	void onPreExecute(GenericThread task);

	void onPostExecute(GenericThread task, ThreadResult result);

	void onProgressUpdate(GenericThread task, Object param);

	void onCancelled(GenericThread task);
}
