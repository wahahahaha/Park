package com.thirdparty.Http;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpResponseHandler;

public class ParkAsyncHttpResponseHandler extends AsyncHttpResponseHandler {

	@Override
	public void onFailure(int statusCode, Header[] headers, byte[] response,
			Throwable e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish() {
		// TODO Auto-generated method stub
		super.onFinish();
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}
}
