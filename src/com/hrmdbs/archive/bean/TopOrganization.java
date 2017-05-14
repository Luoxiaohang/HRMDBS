package com.hrmdbs.archive.bean;

public class TopOrganization {
	private int id;
	private String topOrganizationName;

	public TopOrganization() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TopOrganization(String topOrganizationName, int id) {
		super();
		this.topOrganizationName = topOrganizationName;
	}

	public TopOrganization(int topOrganizationId) {
		// TODO Auto-generated constructor stub
		this.id = topOrganizationId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopOrganizationName() {
		return topOrganizationName;
	}

	public void setTopOrganizationName(String positionName) {
		this.topOrganizationName = positionName;
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
		TopOrganization other = (TopOrganization) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
