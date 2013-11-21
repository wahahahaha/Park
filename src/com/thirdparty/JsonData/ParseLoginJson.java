package com.thirdparty.JsonData;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.thirdparty.data.LoginData;

public class ParseLoginJson {

	public static LoginData parser(String str) {
		JSONTokener tokener = new JSONTokener(str);
		LoginData data = new LoginData();

		try {
			JSONObject jsonObject = (JSONObject) tokener.nextValue();
			data.setMessage(jsonObject.getString("message"));
			data.setToken(jsonObject.getString("Auth-Token"));
			data.setStatus(jsonObject.getString("status"));
			jsonObject = jsonObject.getJSONObject("user");

			data.setJglx(jsonObject.getString("jglx"));
			data.setPhone(jsonObject.getString("phone"));
			data.setSbdm(jsonObject.getString("sbdm"));
			data.setRealName(jsonObject.getString("realname"));
			data.setJgdm(jsonObject.getString("jgdm"));
			data.setSblx(jsonObject.getString("sblx"));

		} catch (JSONException e) {

		}

		return data;
	}
}
