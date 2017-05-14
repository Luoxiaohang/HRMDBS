package com.hrmdbs.archive.bean;

public class SecondOrganization {
	private int id;
	private String secondOrganizationName;
	private TopOrganization topOrganization;

	public SecondOrganization() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SecondOrganization(String secondOrganizationName, int id) {
		super();
		this.secondOrganizationName = secondOrganizationName;
	}

	public SecondOrganization(int secondOrganizationId) {
		this.id = secondOrganizationId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSecondOrganizationName() {
		return secondOrganizationName;
	}

	public void setSecondOrganizationName(String secondOrganizationName) {
		this.secondOrganizationName = secondOrganizationName;
	}

	public TopOrganization getTopOrganization() {
		return topOrganization;
	}

	public void setTopOrganization(TopOrganization topOrganization) {
		this.topOrganization = topOrganization;
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
		SecondOrganization other = (SecondOrganization) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
