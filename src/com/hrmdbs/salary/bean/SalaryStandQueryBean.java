package com.hrmdbs.salary.bean;

public class SalaryStandQueryBean {
	private int salaryStandId = -1;
	private String key;
	private String timeFrom;
	private String timeTo;

	public SalaryStandQueryBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSalaryStandId() {
		return salaryStandId;
	}

	public void setSalaryStandId(int salaryStandId) {
		this.salaryStandId = salaryStandId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(String timeFrom) {
		this.timeFrom = timeFrom;
	}

	public String getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(String timeTo) {
		this.timeTo = timeTo;
	}
}
