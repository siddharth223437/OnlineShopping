package com.ecom.ssar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.ssar.common.vo.HttpResponse;
import com.ecom.ssar.common.vo.QuestionsVO;
import com.ecom.ssar.common.vo.UsersVO;
import com.ecom.ssar.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {
	
	static UsersVO holdUser = null;
	
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register/{companyId}/{StreamId}/{email}")
	public HttpResponse<UsersVO> registerUser(@PathVariable("companyId") int companyId,@PathVariable("StreamId") int StreamId,@PathVariable("email") String email){
		HttpResponse<UsersVO> resp = new HttpResponse<>();
		userService.registerUserByCompany(companyId, StreamId, email);
		resp.setMessage("User Registerd for Quiz");
		resp.setStatus(true);
		return resp;
	}
	
	@GetMapping("/ques/{email}/{code}")
	public HttpResponse<List<QuestionsVO>> getQuestionsWithOptionsForUser(@PathVariable("email") String email,@PathVariable("code") int code){
		HttpResponse<List<QuestionsVO>> resp = new HttpResponse<>();
		List<QuestionsVO> questLst = userService.allQuestionsByStreamId(email, code);
		if(questLst == null) {
			resp.setStatus(false);
			return resp;
		}
		resp.setResponseObject(questLst);
		resp.setStatus(true);
		return resp;
	}
	
	@GetMapping("/checkUser/{email}/{code}")
	public HttpResponse<UsersVO> checkUser(@PathVariable("email") String email,@PathVariable("code") int code) {
		HttpResponse<UsersVO> resp = new HttpResponse<>();
		 UsersVO user = userService.checkUsers(email, code);
		if(user!=null) {
			holdUser = user;
			resp.setStatus(true);
			return resp;
		}
		resp.setStatus(false);
		return resp;
	}
	
	@PostMapping("/opt")
	public void getSubmittedAns(@RequestBody List<String> optLst) {
		userService.makeQuestionWithSubmitedOption(optLst,holdUser.getUserId());
	}

}
