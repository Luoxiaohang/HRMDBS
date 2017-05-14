package com.hrmdbs.archive.bean;

import com.hrmdbs.salary.bean.SalaryRegistInfo;

public class Employee {
	private int id;
	private String hrid;
	private boolean checked;

	private String name;
	private String sex;
	private String Email;
	private String Phone;
	private String qq;
	private String selPhone;
	private String address;
	private String PostNumber;

	private int nationality; // 国籍
	private String bornAddress;
	private String birthday;
	private int faith; // 宗教信仰
	private int politicsStatus; // 政治面貌
	private String identityId; // 身份证号码
	private String age;
	private int education; // 学历
	private int educationYears; // 教育年限

	private String bankName; // 开户行
	private String bankNumber; // 帐号
	private String registTime;
	private int hobby; // 爱好
	private int speciality;// 特长
	private String perRecord; // 个人履历
	private String familyRelation; // 家庭关系信息
	private String remark; // 备注
	private int nation; // 民族
	private String socialSecurityID; // 社保号码
	private int major; // 学历专业
	private String registor; // 登记人
	private boolean deleted;

	// 关联属性
	private TopOrganization topOrganization;
	private SecondOrganization secondOrganization;
	private ThirdOrganization thirdOrganization;
	private PositionSorted positionSorted;
	private PositionName positionName;
	private ProfessionalTitle professionalTitle;// 职称
	private SalaryRegistInfo salaryStand;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Boolean isChecked() {
		return checked;
	}

	public TopOrganization getTopOrganization() {
		return topOrganization;
	}

	public void setTopOrganization(TopOrganization topOrganization) {
		this.topOrganization = topOrganization;
	}

	public SecondOrganization getSecondOrganization() {
		return secondOrganization;
	}

	public void setSecondOrganization(SecondOrganization secondOrganization) {
		this.secondOrganization = secondOrganization;
	}

	public ThirdOrganization getThirdOrganization() {
		return thirdOrganization;
	}

	public void setThirdOrganization(ThirdOrganization thirdOrganization) {
		this.thirdOrganization = thirdOrganization;
	}

	public PositionSorted getPositionSorted() {
		return positionSorted;
	}

	public void setPositionSorted(PositionSorted positionSorted) {
		this.positionSorted = positionSorted;
	}

	public PositionName getPositionName() {
		return positionName;
	}

	public void setPositionName(PositionName positionName) {
		this.positionName = positionName;
	}

	public ProfessionalTitle getProfessionalTitle() {
		return professionalTitle;
	}

	public void setProfessionalTitle(ProfessionalTitle professionalTitle) {
		this.professionalTitle = professionalTitle;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public int getId() {
		return id;
	}

	public String getHrid() {
		return hrid;
	}

	public void setHrid(String hrid) {
		this.hrid = hrid;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getSelPhone() {
		return selPhone;
	}

	public void setSelPhone(String selPhone) {
		this.selPhone = selPhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostNumber() {
		return PostNumber;
	}

	public void setPostNumber(String postNumber) {
		PostNumber = postNumber;
	}

	public int getNationality() {
		return nationality;
	}

	public void setNationality(int nationality) {
		this.nationality = nationality;
	}

	public String getBornAddress() {
		return bornAddress;
	}

	public void setBornAddress(String bornAddress) {
		this.bornAddress = bornAddress;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getFaith() {
		return faith;
	}

	public void setFaith(int faith) {
		this.faith = faith;
	}

	public int getPoliticsStatus() {
		return politicsStatus;
	}

	public void setPoliticsStatus(int politicsStatus) {
		this.politicsStatus = politicsStatus;
	}

	public String getIdentityId() {
		return identityId;
	}

	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public int getEducation() {
		return education;
	}

	public void setEducation(int education) {
		this.education = education;
	}

	public int getEducationYears() {
		return educationYears;
	}

	public void setEducationYears(int educationYears) {
		this.educationYears = educationYears;
	}

	public SalaryRegistInfo getSalaryStand() {
		return salaryStand;
	}

	public void setSalaryStand(SalaryRegistInfo salaryStand) {
		this.salaryStand = salaryStand;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}

	public String getRegistTime() {
		return registTime;
	}

	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}

	public int getHobby() {
		return hobby;
	}

	public void setHobby(int hobby) {
		this.hobby = hobby;
	}

	public int getSpeciality() {
		return speciality;
	}

	public void setSpeciality(int speciality) {
		this.speciality = speciality;
	}

	public String getPerRecord() {
		return perRecord;
	}

	public void setPerRecord(String perRecord) {
		this.perRecord = perRecord;
	}

	public String getFamilyRelation() {
		return familyRelation;
	}

	public void setFamilyRelation(String familyRelation) {
		this.familyRelation = familyRelation;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getNation() {
		return nation;
	}

	public void setNation(int nation) {
		this.nation = nation;
	}

	public String getSocialSecurityID() {
		return socialSecurityID;
	}

	public void setSocialSecurityID(String socialSecurityID) {
		this.socialSecurityID = socialSecurityID;
	}

	public int getMajor() {
		return major;
	}

	public void setMajor(int major) {
		this.major = major;
	}

	public String getRegistor() {
		return registor;
	}

	public void setRegistor(String registor) {
		this.registor = registor;
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
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
