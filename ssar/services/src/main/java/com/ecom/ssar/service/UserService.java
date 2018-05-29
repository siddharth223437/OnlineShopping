package com.ecom.ssar.service;

import java.util.List;
import java.util.Map;

import com.ecom.ssar.common.vo.QuestionsVO;
import com.ecom.ssar.common.vo.UsersVO;

public interface UserService {
	
	public void registerUserByCompany(int companyId, int StreamId, String userEmail);
	public UsersVO checkUsers(String email, int code);
	public List<QuestionsVO> allQuestionsByStreamId(String email,int code);
	public Map<Integer,Integer> makeQuestionWithSubmitedOption(List<String> quesOptLst,int userId);

}
