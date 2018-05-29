package com.ecom.ssar.serviceimp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.ssar.business.dao.UsersDao;
import com.ecom.ssar.common.vo.QuestionsVO;
import com.ecom.ssar.common.vo.UsersVO;
import com.ecom.ssar.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UsersDao userDao;

	@Override
	public void registerUserByCompany(int companyId, int StreamId, String userEmail) {
		userDao.registerUserByCompany(companyId, StreamId, userEmail);
		
	}

	@Override
	public UsersVO checkUsers(String email,int code) {
		UsersVO users = userDao.findByEmailAndCode(email, code);
		if(users.getUserEmail()!=null && users.getUserCode()!=0) {
			return users;
		}
		return null;
	}
	
	@Override
	@Transactional
	public List<QuestionsVO> allQuestionsByStreamId(String email,int code){
		UsersVO users = userDao.findByEmailAndCode(email, code);
		if(users.getUserEmail()==null || users.getUserCode()==0) {
			return null;
		}
		List<QuestionsVO> quesLst = users.getSteamVO().getQuestionsVo();
		System.out.println(" ");
		return quesLst;
		
		
	}
	@Override
	public Map<Integer,Integer> makeQuestionWithSubmitedOption(List<String> quesOptLst,int userId){
		Map<Integer, Integer> map = new HashMap<>();
		for(String str : quesOptLst) {
			String beforHash = str.substring(0, str.indexOf("#"));
			String afterHash = str.substring((str.indexOf("#")+1),str.length());
			map.put(converToNum(beforHash), converToNum(afterHash));
		}
		System.out.println(map);
		userDao.insertUserSubmittedOptions(map, userId);
		return map;
	}
	
	private int converToNum(String str) {
		return Integer.parseInt(str);
	}
	
	
	
	
	
	
	

}
