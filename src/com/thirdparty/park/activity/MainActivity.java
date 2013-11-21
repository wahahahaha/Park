package com.thirdparty.park.activity;

import java.util.Locale;

import org.apache.http.Header;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.RequestParams;
import com.thirdparty.Http.ParkAsyncHttpResponseHandler;
import com.thirdparty.Http.ParkRestClient;
import com.thirdparty.JsonData.ParseLoginJson;
import com.thirdparty.data.LoginData;
import com.thirdparty.park.R;
import com.thirdparty.ui.EditTextOwnDel;
import com.thirdparty.util.MD5;

public class MainActivity extends Activity implements OnClickListener {

	private EditText et_accout;
	private EditTextOwnDel et_password;
	private Button btn_login;
	private SharedPreferences sp;

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

		sp = getSharedPreferences("park", MODE_PRIVATE);
		if (isLogin(sp)) {
			doneLogin(sp);
			return;
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.btn_login) {
			handleLogin();
			return;
		}
	}

	private void handleLogin() {
		RequestParams params = new RequestParams();
		params.put("username", et_accout.getText().toString());
		params.put("password", MD5.getMD5(et_password.getEditText())
				.toLowerCase(Locale.getDefault()));

		doLogin(params, false);
	}

	private void doneLogin(SharedPreferences sp) {
		RequestParams params = new RequestParams();
		params.put("username", sp.getString("username", ""));
		params.put("password", sp.getString("password", ""));
		doLogin(params, true);
	}

	private void doLogin(RequestParams params, final boolean flag) {
		ParkRestClient.post("auth", params, new ParkAsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int statusCode, Header[] headers,
					byte[] response) {
				if (null == response) {

					return;
				}

				LoginData data = ParseLoginJson.parser(new String(response));
				Log.d(TAG, "RESP: " + new String(response));

				if ("E000".equals(data.getStatus())) {
					if (!flag) {
						setParkElement(sp);
					}

					Intent intent = new Intent(MainActivity.this,
							WorkActivity.class);
					startActivity(intent);
					finish();
				} else {
					if (flag) {
						resetParkElement(sp);
					}
				}
			}
		});
	}

	private boolean isLogin(SharedPreferences sp) {
		if (sp.getBoolean("login", false)
				&& !TextUtils.isEmpty(sp.getString("username", ""))
				&& !TextUtils.isEmpty(sp.getString("password", ""))) {
			return true;
		}

		return false;
	}

	private void setParkElement(SharedPreferences sp) {
		Editor editor = sp.edit();
		editor.putBoolean("login", true);
		editor.putString("username", et_accout.getText().toString());
		editor.putString("password", MD5.getMD5(et_password.getEditText())
				.toLowerCase(Locale.getDefault()));
		editor.commit();
	}

	private void resetParkElement(SharedPreferences sp) {
		Editor editor = sp.edit();
		editor.putBoolean("login", false);
		editor.putString("username", "");
		editor.putString("password", "");
		editor.commit();
	}
}
