package com.hrmdbs.archive.bean;

public class PositionSorted {
	private int id;
	private String positionSortedName;

	public PositionSorted() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PositionSorted(String positionSortedName) {
		super();
		this.positionSortedName = positionSortedName;
	}

	public PositionSorted(int positionSortedId) {
		this.id = positionSortedId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPositionSortedName() {
		return positionSortedName;
	}

	public void setPositionSortedName(String positionSortedName) {
		this.positionSortedName = positionSortedName;
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
		PositionSorted other = (PositionSorted) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
