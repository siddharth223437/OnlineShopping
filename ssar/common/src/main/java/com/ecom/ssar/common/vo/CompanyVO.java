package com.ecom.ssar.common.vo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CompanyVO {

	@Id
	private int compId;
	private String companyName;
	private String companyEmail;
	private String companyPassword;
	private boolean companyActive;

	@OneToOne(mappedBy = "companyVO")
	private UsersVO userVO;

	public int getCompId() {
		return compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getCompanyPassword() {
		return companyPassword;
	}

	public void setCompanyPassword(String companyPassword) {
		this.companyPassword = companyPassword;
	}

	public boolean isCompanyActive() {
		return companyActive;
	}

	public void setCompanyActive(boolean companyActive) {
		this.companyActive = companyActive;
	}

	public UsersVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UsersVO userVO) {
		this.userVO = userVO;
	}

}
