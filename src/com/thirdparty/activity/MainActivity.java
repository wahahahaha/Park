package com.thirdparty.activity;

import java.util.Locale;

import org.apache.http.Header;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.RequestParams;
import com.thirdparty.Http.ParkAsyncHttpResponseHandler;
import com.thirdparty.Http.ParkRestClient;
import com.thirdparty.park.R;
import com.thirdparty.ui.EditTextOwnDel;
import com.thirdparty.util.MD5;

public class MainActivity extends Activity implements OnClickListener {

	private EditText et_accout;
	private EditTextOwnDel et_password;
	private Button btn_login;
	private String TAG = "MainACtivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actvt_main);

		et_accout = (EditText) findViewById(R.id.et_account);
		et_password = (EditTextOwnDel) findViewById(R.id.et_password);
		et_password.setInputType(InputType.TYPE_CLASS_TEXT
				| InputType.TYPE_TEXT_VARIATION_PASSWORD);
		btn_login = (Button) findViewById(R.id.btn_login);
		btn_login.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.btn_login) {
			RequestParams params = new RequestParams();
			params.put("username", et_accout.getText().toString());
			params.put("password", MD5.getMD5(et_password.getEditText())
					.toLowerCase(Locale.getDefault()));

			ParkRestClient.post("auth", params,
					new ParkAsyncHttpResponseHandler() {
						@Override
						public void onSuccess(int statusCode, Header[] headers,
								byte[] response) {
							// TODO Auto-generated method stub
							Log.d(TAG, "RESP: " + new String(response));
						}
					});
		}
	}

}
