package com.hrmdbs.archive.bean;

public class ProfessionalTitle {
	private int id;
	private String professionalTitle;

	public ProfessionalTitle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProfessionalTitle(String professionalTitle) {
		super();
		this.professionalTitle = professionalTitle;
	}

	public ProfessionalTitle(int professionTitleId) {
		this.id = professionTitleId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProfessionalTitle() {
		return professionalTitle;
	}

	public void setProfessionalTitle(String professionalTitle) {
		this.professionalTitle = professionalTitle;
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
		ProfessionalTitle other = (ProfessionalTitle) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
