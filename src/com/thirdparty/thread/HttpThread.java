package com.thirdparty.thread;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class HttpThread extends GenericThread {
	@Override
	protected ThreadResult _doInBackground(ThreadParams... params) {
		// TODO Auto-generated method stub
		getParams(params);
		return null;
	}

	private ArrayList<NameValuePair> getParams(ThreadParams... params) {
		if (params.length <= 0) {
			return new ArrayList<NameValuePair>();
		}

		ThreadParams param = params[0];

		ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
		HashMap<String, Object> hashMap = param.getHashMap();
		String keys[] = hashMap.keySet().toArray(
				new String[hashMap.keySet().size()]);
		for (String key : keys) {
			pairs.add(new BasicNameValuePair(key, (String) hashMap.get(key)));
		}

		return pairs;
	}
}
