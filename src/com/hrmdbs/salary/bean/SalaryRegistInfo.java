package com.hrmdbs.salary.bean;

public class SalaryRegistInfo {
	private int id;
	private String salaryStandName;
	private String salaryRegistor;
	// ÷∆∂®»À
	private String salaryFormulater;
	private String salaryRegistTime;
	private boolean reChecked;
	private String reCheckRemark;
	private float totalMoney;

	public SalaryRegistInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalaryRegistInfo(String salaryStandName, String salaryRegistor,
			String salaryformulater, String salaryRegistTime,
			boolean reChecked, String reCheckRemark) {
		super();
		this.salaryStandName = salaryStandName;
		this.salaryRegistor = salaryRegistor;
		this.salaryFormulater = salaryformulater;
		this.salaryRegistTime = salaryRegistTime;
		this.reChecked = reChecked;
		this.reCheckRemark = reCheckRemark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSalaryStandName() {
		return salaryStandName;
	}

	public void setSalaryStandName(String salaryStandName) {
		this.salaryStandName = salaryStandName;
	}

	public String getSalaryRegistor() {
		return salaryRegistor;
	}

	public void setSalaryRegistor(String string) {
		this.salaryRegistor = string;
	}

	public void setSalaryFormulater(String salaryformulater) {
		this.salaryFormulater = salaryformulater;
	}

	public String getSalaryRegistTime() {
		return salaryRegistTime;
	}

	public void setSalaryRegistTime(String salaryRegistTime) {
		this.salaryRegistTime = salaryRegistTime;
	}

	public boolean isReChecked() {
		return reChecked;
	}

	public void setReChecked(boolean reChecked) {
		this.reChecked = reChecked;
	}

	public String getReCheckRemark() {
		return reCheckRemark;
	}

	public void setReCheckRemark(String reCheckRemark) {
		this.reCheckRemark = reCheckRemark;
	}

	public String getSalaryFormulater() {
		return salaryFormulater;
	}

	public float getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}

}
