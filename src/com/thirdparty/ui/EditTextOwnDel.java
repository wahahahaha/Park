/**
 * Copyright (C) 2013. de pan <dpymsfd@gmail.com>
 */
package com.thirdparty.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.thirdparty.park.R;

/**
 * @ClassName: EditTextOwnDel
 * 
 * @Author: depan
 * 
 * @Description: TODO
 * 
 * @Date: 2013年8月14日 上午11:44:14
 * 
 * @Version: 1.0
 **/
public class EditTextOwnDel extends LinearLayout {
	private EditText et_text;
	private ImageButton ibtn_del;

	public EditTextOwnDel(Context context) {
		// TODO Auto-generated constructor stub
		this(context, null);
	}

	public EditTextOwnDel(Context context, AttributeSet attr) {
		// TODO Auto-generated constructor stub
		super(context, attr);
		init(context);
	}

	private void init(Context context) {
		View view = LayoutInflater.from(context).inflate(
				R.layout.edittextowndel, this);
		try {
			et_text = (EditText) (view.findViewById(R.id.et_text));
			et_text.addTextChangedListener(new TextWatcher() {
				@Override
				public void onTextChanged(CharSequence s, int start,
						int before, int count) {
					// TODO Auto-generated method stub
				}

				@Override
				public void beforeTextChanged(CharSequence s, int start,
						int count, int after) {
					// TODO Auto-generated method stub
				}

				@Override
				public void afterTextChanged(Editable s) {
					// TODO Auto-generated method stub
					if (s.length() == 0) {
						hideButton();
					} else {
						showButton();
					}
				}
			});

			ibtn_del = (ImageButton) (view.findViewById(R.id.ibtn_del));
			ibtn_del.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					et_text.setText("");
					hideButton();
				}
			});
		} catch (Exception e) {
		}
	}

	public void setInputType(int type) {
		et_text.setInputType(type);
	}

	public String getEditText() {
		return et_text.getText().toString();
	}

	private void hideButton() {
		if (ibtn_del.isShown()) {
			ibtn_del.setVisibility(View.GONE);
		}
	}

	private void showButton() {
		if (!ibtn_del.isShown()) {
			ibtn_del.setVisibility(View.VISIBLE);
		}
	}
}
