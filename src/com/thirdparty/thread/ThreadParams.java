package com.thirdparty.thread;

import java.util.HashMap;

public class ThreadParams {
	private HashMap<String, Object> params = null;

	public ThreadParams() {
		// TODO Auto-generated constructor stub
		params = new HashMap<String, Object>();
	}

	public ThreadParams(String key, Object value) {
		this();
		put(key, value);
	}

	public void put(String key, Object value) {
		params.put(key, value);
	}

	public Object get(String key) {
		return params.get(key);
	}

	public int getInt(String key) throws Exception {
		Object object = get(key);
		try {
			return object instanceof Number ? ((Number) object).intValue()
					: Integer.parseInt((String) object);
		} catch (Exception e) {
			throw new Exception(key + " is not an int.");
		}
	}

	public String getString(String key) {
		Object object = get(key);
		return object == null ? "" : object.toString();
	}

	public boolean hasKey(String key) {
		return params.containsKey(key);
	}

	public HashMap<String, Object> getHashMap() {
		return params;
	}
}
