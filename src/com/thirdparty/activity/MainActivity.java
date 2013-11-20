package com.thirdparty.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.thirdparty.park.R;
import com.thirdparty.ui.EditTextOwnDel;

public class MainActivity extends Activity implements OnClickListener
{

	private EditText et_accout;
	private EditTextOwnDel et_password;
	private Button btn_login;
	private String TAG = "MainACtivity";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
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
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		if (v.getId() == R.id.btn_login)
		{
			Log.d(TAG, "Account: " + et_accout.getText().toString());
			Log.d(TAG, "Password: " + et_password.getEditText());
		}
	}

}
