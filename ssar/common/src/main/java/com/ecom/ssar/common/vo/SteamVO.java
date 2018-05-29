package com.ecom.ssar.common.vo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class SteamVO {

	@Id
	private int streamID;
	private String technology;

	@OneToMany(mappedBy="steamVO")
	private List<UsersVO> userVO;
	
	@OneToMany(mappedBy="steamVO")
	private List<QuestionsVO> questionsVo;

	public int getStreamID() {
		return streamID;
	}

	public void setStreamID(int streamID) {
		this.streamID = streamID;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	

	public List<UsersVO> getUserVO() {
		return userVO;
	}

	public void setUserVO(List<UsersVO> userVO) {
		this.userVO = userVO;
	}

	public List<QuestionsVO> getQuestionsVo() {
		return questionsVo;
	}

	public void setQuestionsVo(List<QuestionsVO> questionsVo) {
		this.questionsVo = questionsVo;
	}
	
	

}
