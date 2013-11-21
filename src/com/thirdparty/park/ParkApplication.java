package com.thirdparty.park;

import android.app.Application;

public class ParkApplication extends Application {
	private static ParkApplication instance;

	public static ParkApplication getInstance() {
		return instance;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}
}
