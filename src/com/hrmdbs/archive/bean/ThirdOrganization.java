package com.hrmdbs.archive.bean;

public class ThirdOrganization {
	private int id;
	private String thirdOrganizationName;
	private SecondOrganization secondOrganization;

	public ThirdOrganization() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public ThirdOrganization(String thirdOrganizationName, int id) {
		super();
		this.thirdOrganizationName = thirdOrganizationName;
	}

	public ThirdOrganization(int thirdOrganizationId) {
		this.id = thirdOrganizationId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getThirdOrganizationName() {
		return thirdOrganizationName;
	}

	public void setThirdOrganizationName(String thirdOrganizationName) {
		this.thirdOrganizationName = thirdOrganizationName;
	}

	public SecondOrganization getSecondOrganization() {
		return secondOrganization;
	}

	public void setSecondOrganization(SecondOrganization secondOrganization) {
		this.secondOrganization = secondOrganization;
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
		ThirdOrganization other = (ThirdOrganization) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
