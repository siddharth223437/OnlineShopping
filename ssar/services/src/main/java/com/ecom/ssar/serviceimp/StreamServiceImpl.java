package com.ecom.ssar.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ecom.ssar.business.dao.StreamDao;
import com.ecom.ssar.common.vo.SteamVO;
import com.ecom.ssar.service.StreamService;

@Service
public class StreamServiceImpl implements StreamService {
	
	@Autowired
	private StreamDao streamDao;

	@Override
	@Cacheable("streams")
	public List<SteamVO> streamList() {
		//sleep();
		return streamDao.streamList();
	}
	
	private void sleep() {
		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
