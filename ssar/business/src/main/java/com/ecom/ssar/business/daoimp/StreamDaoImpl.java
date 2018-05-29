package com.ecom.ssar.business.daoimp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ecom.ssar.business.dao.StreamDao;
import com.ecom.ssar.common.vo.SteamVO;

@Repository
@Transactional
public class StreamDaoImpl implements StreamDao {
	
	@Autowired
	private EntityManager em;

	@Override
	public List<SteamVO> streamList() {
		Query query = em.createNativeQuery("Select * from SteamVO");
		List<SteamVO> ls = new ArrayList<>();
		List<Object[]> list = query.getResultList();
		for(Object[] obj : list) {
			SteamVO st = new SteamVO();
			st.setStreamID((int) obj[0]);
			st.setTechnology((String) obj[1]);
			ls.add(st);
		}
		return ls;
	}

}
