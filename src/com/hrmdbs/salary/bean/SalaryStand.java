package com.hrmdbs.salary.bean;

public class SalaryStand {
	private int id;
	private float money;
	private SalaryRegistInfo salaryRegistInfo;
	private SalaryItem salaryItem;

	public SalaryStand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalaryStand(SalaryRegistInfo salaryRegistInfo, SalaryItem salaryItem) {
		super();
		this.salaryRegistInfo = salaryRegistInfo;
		this.salaryItem = salaryItem;
	}

	public SalaryRegistInfo getSalaryRegistInfo() {
		return salaryRegistInfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSalaryRegistInfo(SalaryRegistInfo salaryRegistInfo) {
		this.salaryRegistInfo = salaryRegistInfo;
	}

	public SalaryItem getSalaryItem() {
		return salaryItem;
	}

	public void setSalaryItem(SalaryItem salaryItem) {
		this.salaryItem = salaryItem;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

}
