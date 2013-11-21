/**
 * Copyright (C) 2013. de pan <dpymsfd@gmail.com>
 */
package com.thirdparty.util;

import android.util.TypedValue;

import com.thirdparty.park.ParkApplication;

/**
 * @ClassName: Utility
 * 
 * @Author: depan
 * 
 * @Description: TODO
 * 
 * @Date: 2013年7月23日 下午1:23:15
 * 
 * @Version: 1.0
 **/
public class Utility {
	public static int dip2px(int dipValue) {
		try {
			float scale = ParkApplication.getInstance().getResources()
					.getDisplayMetrics().density;

			return (int) (dipValue * scale + 0.5f);
		} catch (Exception e) {
			return 0;
		}
	}

	public static int px2dip(int pxValue) {
		float scale = ParkApplication.getInstance().getResources()
				.getDisplayMetrics().density;

		return (int) ((pxValue / scale) + 0.5f);
	}

	public static float sp2px(int spValue) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue,
				ParkApplication.getInstance().getResources()
						.getDisplayMetrics());
	}
}
