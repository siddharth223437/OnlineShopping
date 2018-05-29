package com.ecom.ssar.common.vo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class QuestionsVO {
	@Id
	private int questionId;
	private String question;
	
	@ManyToOne
	@JsonIgnore
	private SteamVO steamVO;
	
	@OneToMany(mappedBy="questionsVO",fetch=FetchType.LAZY)
	private List<OptionsVO> optionsVO;
	
	private String correctAnswer;


	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public SteamVO getSteamVO() {
		return steamVO;
	}

	public void setSteamVO(SteamVO steamVO) {
		this.steamVO = steamVO;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public List<OptionsVO> getOptionsVO() {
		return optionsVO;
	}

	public void setOptionsVO(List<OptionsVO> optionsVO) {
		this.optionsVO = optionsVO;
	}
	
	
	

}
