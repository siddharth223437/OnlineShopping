package com.ecom.ssar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.ssar.common.vo.HttpResponse;
import com.ecom.ssar.common.vo.SteamVO;
import com.ecom.ssar.service.StreamService;

@RestController
@RequestMapping("stream")
@CrossOrigin
public class StreamController {
	
	@Autowired
	private StreamService sr;
	
	@GetMapping("/allstream")
	public HttpResponse<List<SteamVO>> allStreams(){
		HttpResponse<List<SteamVO>> resp = new HttpResponse<>();
		List<SteamVO> streamlist = sr.streamList();
		resp.setResponseObject(streamlist);
		resp.setStatus(true);
		return resp;
	}

}
