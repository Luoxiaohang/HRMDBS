package com.hrmdbs.salary.bean;

public class SalaryItem {
	private int id;
	private String salaryItemName;
	private Float scaleOnSalary;
	private boolean scaleAble = false;

	public SalaryItem(int id, String salaryItemName) {
		super();
		this.id = id;
		this.salaryItemName = salaryItemName;
	}

	public SalaryItem(String salaryItemName) {
		super();
		this.salaryItemName = salaryItemName;
	}

	public SalaryItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSalaryItemName() {
		return salaryItemName;
	}

	public void setSalaryItemName(String salaryItemName) {
		this.salaryItemName = salaryItemName;
	}

	public Float getScaleOnSalary() {
		return scaleOnSalary;
	}

	public void setScaleOnSalary(Float scaleOnSalary) {
		this.scaleOnSalary = scaleOnSalary;
	}

	public boolean isScaleAble() {
		return scaleAble;
	}

	public void setScaleAble(boolean scaleAble) {
		this.scaleAble = scaleAble;
	}
}
