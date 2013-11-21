/**
 * Copyright (C) 2013. de pan <dpymsfd@gmail.com>
 */
package com.thirdparty.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.text.TextUtils;

/**
 * @ClassName: MD5
 * 
 * @Author: depan
 * 
 * @Description: TODO
 * 
 * @Date: 2013年11月15日 上午10:12:12
 * 
 * @Version: 1.0
 **/
public class MD5 {
	public static String getMD5(String srcString) {
		StringBuffer sb;
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };

		if (TextUtils.isEmpty(srcString)) {
			return "";
		}

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte tmp[] = md.digest(srcString.getBytes("UTF-8"));
			sb = new StringBuffer(tmp.length * 2);

			for (byte b : tmp) {
				sb.append(hexDigits[b >>> 4 & 0xf]);
				sb.append(hexDigits[b & 0xf]);
			}
		} catch (NoSuchAlgorithmException e) {
			return "";
		} catch (UnsupportedEncodingException e) {
			return "";
		}

		return sb.toString();
	}
}
