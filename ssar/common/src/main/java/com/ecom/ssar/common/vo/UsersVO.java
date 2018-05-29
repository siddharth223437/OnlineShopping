package com.ecom.ssar.common.vo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UsersVO {

	@Id
	@GeneratedValue
	private int userId;
	private String userEmail;
	private int userCode;

	@OneToOne
	private CompanyVO companyVO;

	
	@ManyToOne
	private SteamVO steamVO;
	
	@OneToOne(mappedBy="usersVO")
	private SubmittedAnsVO submittedAnsVO;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public CompanyVO getCompanyVO() {
		return companyVO;
	}

	public void setCompanyVO(CompanyVO companyVO) {
		this.companyVO = companyVO;
	}

	
	

	public SteamVO getSteamVO() {
		return steamVO;
	}

	public void setSteamVO(SteamVO steamVO) {
		this.steamVO = steamVO;
	}

	public SubmittedAnsVO getSubmittedAnsVO() {
		return submittedAnsVO;
	}

	public void setSubmittedAnsVO(SubmittedAnsVO submittedAnsVO) {
		this.submittedAnsVO = submittedAnsVO;
	}
	
	

}
