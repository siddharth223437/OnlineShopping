package com.ecom.ssar.business.dao;

import java.util.Map;

import com.ecom.ssar.common.vo.UsersVO;

public interface UsersDao {
	
	public void registerUserByCompany(int companyId,int StreamId,String userEmail);
	public UsersVO findUserById(int userId);
	public UsersVO findByEmailAndCode(String email,int code);
	public void insertUserSubmittedOptions(Map<Integer,Integer> optionMap,int userId);

}
