package com.ecom.ssar.business.daoimp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.ssar.business.dao.UsersDao;
import com.ecom.ssar.common.vo.CompanyVO;
import com.ecom.ssar.common.vo.OptionsVO;
import com.ecom.ssar.common.vo.QuestionsVO;
import com.ecom.ssar.common.vo.SteamVO;
import com.ecom.ssar.common.vo.SubmittedAnsVO;
import com.ecom.ssar.common.vo.UsersVO;

@Repository
@Transactional
public class UsersDaoImpl implements UsersDao {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public void registerUserByCompany(int companyId, int StreamId, String userEmail) {
		CompanyVO comp = entityManager.find(CompanyVO.class, companyId);
		SteamVO stream = entityManager.find(SteamVO.class, StreamId);
		UsersVO user = new UsersVO();
		user.setUserEmail(userEmail);
		user.setUserCode(generateUserCode());
		user.setCompanyVO(comp);
		//List<SteamVO> stLst = new ArrayList<>();
		//stLst.add(stream);
		user.setSteamVO(stream);
		entityManager.persist(user);
	}
	
	private int generateUserCode() {
		Random r = new Random();
		return r.nextInt((10000 - 1000) + 1) + 1000;
	}

	@Override
	public UsersVO findUserById(int userId) {
		return entityManager.find(UsersVO.class, userId);
	}

	@Override
	public UsersVO findByEmailAndCode(String email, int code) {
		UsersVO user = new UsersVO();
		Query query = entityManager.createNativeQuery("select * from UsersVO where userEmail = ? and userCode = ?",UsersVO.class);
		query.setParameter(1, email);
		query.setParameter(2, code);
		List<UsersVO> list = query.getResultList();
		if(list.size() !=0) {
			for(UsersVO u : list) {
				user.setUserId(u.getUserId());
				user.setUserEmail(u.getUserEmail());
				user.setUserCode(u.getUserCode());
				user.setCompanyVO(u.getCompanyVO());
				user.setSteamVO(u.getSteamVO());
		
			}
		}
		return user;
	}

	@Override
	public void insertUserSubmittedOptions(Map<Integer, Integer> optionMap,int userId) {
		for(Map.Entry<Integer, Integer> entry : optionMap.entrySet()) {
			SubmittedAnsVO subAns = new SubmittedAnsVO();
			QuestionsVO findQuest = entityManager.find(QuestionsVO.class, entry.getKey());
			OptionsVO findOpt = entityManager.find(OptionsVO.class, entry.getValue());
			UsersVO user = entityManager.find(UsersVO.class, userId);
			subAns.setUsersVO(user);
			subAns.setOptions(findOpt);
			subAns.setSubmittedAnswer(findOpt.getOptions());
			subAns.setQuestions(findQuest);
			entityManager.persist(subAns);
		}
				
	}

}
