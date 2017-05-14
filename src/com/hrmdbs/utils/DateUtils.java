package com.hrmdbs.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hrmdbs.constant.Constant;

public class DateUtils {
	public static String getDate(int style) {
		String date = null;
		SimpleDateFormat sdf = null;
		switch (style) {
		case Constant.Date_Y:
			sdf = new SimpleDateFormat("yyyy");
			date = sdf.format(new Date());
			break;
		case Constant.Date_YMD:
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			date = sdf.format(new Date());
			break;
		default:
			break;
		}
		return date;
	}
}
