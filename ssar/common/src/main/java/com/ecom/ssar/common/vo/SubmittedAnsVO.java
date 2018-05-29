package com.ecom.ssar.common.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SubmittedAnsVO {

	@Id
	@GeneratedValue
	private int submittedAnsId;

	private String submittedAnswer;
	
	@OneToOne
	private QuestionsVO questions;
	
	@OneToOne
	private OptionsVO options;

	@OneToOne
	private UsersVO usersVO;

	public int getSubmittedAnsId() {
		return submittedAnsId;
	}

	public void setSubmittedAnsId(int submittedAnsId) {
		this.submittedAnsId = submittedAnsId;
	}

	public UsersVO getUsersVO() {
		return usersVO;
	}

	public void setUsersVO(UsersVO usersVO) {
		this.usersVO = usersVO;
	}

	public String getSubmittedAnswer() {
		return submittedAnswer;
	}

	public void setSubmittedAnswer(String submittedAnswer) {
		this.submittedAnswer = submittedAnswer;
	}

	public QuestionsVO getQuestions() {
		return questions;
	}

	public void setQuestions(QuestionsVO questions) {
		this.questions = questions;
	}

	public OptionsVO getOptions() {
		return options;
	}

	public void setOptions(OptionsVO options) {
		this.options = options;
	}
	
	

}
