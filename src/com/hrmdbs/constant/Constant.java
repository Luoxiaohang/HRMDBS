package com.hrmdbs.constant;

public class Constant {
	// ��ɫId
	public static final int SALARYSPECIALIST = 2;
	public static final int SALARYMANAGER = 1;
	public static final int HRSPECIALIST = 3;
	public static final int HRMANAGER = 4;
	public static final int NORMAL_EMPLOYEE = 0;
	
	// ��������
	public static final int DELETE_EMPLOYEE = 1;
	public static final int QUERY_EMPLOYEE = 2;
	public static final int UPDATE_EMPLOYEE = 3;

	// ����ģʽ
	public static final int Date_YMD = 5;
	public static final int Date_Y = 6;

	// ��¼��ǰ��ɫ
	private static int CURRENTROLE = 0;

	public static int getCURRENTROLE() {
		return CURRENTROLE;
	}

	public static void setCURRENTROLE(int cURRENTROLE) {
		CURRENTROLE = cURRENTROLE;
	}

}
