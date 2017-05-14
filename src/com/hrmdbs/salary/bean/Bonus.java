package com.hrmdbs.salary.bean;

import com.hrmdbs.archive.bean.Employee;

public class Bonus {
	private int id;
	private float bonus;
	private float deductedBonus;
	private Employee employee;
	private boolean rechecked;

	public Bonus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getBonus() {
		return bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}

	public float getDeductedBonus() {
		return deductedBonus;
	}

	public void setDeductedBonus(float deductedBonus) {
		this.deductedBonus = deductedBonus;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public boolean isRechecked() {
		return rechecked;
	}

	public void setRechecked(boolean rechecked) {
		this.rechecked = rechecked;
	}

}
