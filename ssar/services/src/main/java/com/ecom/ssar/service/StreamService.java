package com.ecom.ssar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecom.ssar.common.vo.SteamVO;


public interface StreamService {

	public List<SteamVO> streamList();
}
