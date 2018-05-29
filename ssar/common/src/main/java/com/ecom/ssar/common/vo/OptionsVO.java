package com.ecom.ssar.common.vo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OptionsVO {

	@Id
	private int optionsId;
	private String options;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private QuestionsVO questionsVO;

	public int getOptionsId() {
		return optionsId;
	}

	public void setOptionsId(int optionsId) {
		this.optionsId = optionsId;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public QuestionsVO getQuestionsVO() {
		return questionsVO;
	}

	public void setQuestionsVO(QuestionsVO questionsVO) {
		this.questionsVO = questionsVO;
	}

}
