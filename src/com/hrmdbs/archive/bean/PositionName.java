package com.hrmdbs.archive.bean;

public class PositionName {
	private int id;
	private String positionName;

	public PositionName() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PositionName(String positionName) {
		super();
		this.positionName = positionName;
	}

	public PositionName(int positionNameId) {
		this.id = positionNameId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PositionName other = (PositionName) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
