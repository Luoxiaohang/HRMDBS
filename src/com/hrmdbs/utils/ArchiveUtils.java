package com.hrmdbs.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hrmdbs.service.EmployeeService;

public class ArchiveUtils {
	public static String getArchiveId(int TopName, int secondName,
			int thirdName, String id) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String Archiveid = sdf.format(new Date());

		if (String.valueOf(TopName).length() < 2) {
			Archiveid = Archiveid + "0" + TopName;
		} else {
			Archiveid = Archiveid + TopName;
		}

		if (String.valueOf(secondName).length() < 2) {
			Archiveid = Archiveid + "0" + secondName;
		} else {
			Archiveid = Archiveid + secondName;
		}

		if (String.valueOf(thirdName).length() < 2) {
			Archiveid = Archiveid + "0" + thirdName;
		} else {
			Archiveid = Archiveid + thirdName;
		}
		if (id.length() < 2) {
			Archiveid = Archiveid + "0" + id;
		} else {
			Archiveid = Archiveid + id;
		}
		return Archiveid;
	}
}
