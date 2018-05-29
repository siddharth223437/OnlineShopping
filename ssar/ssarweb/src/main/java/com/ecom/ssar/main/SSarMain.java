package com.ecom.ssar.main;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.ssar.common.vo.QuestionsVO;
import com.ecom.ssar.common.vo.SteamVO;
import com.ecom.ssar.service.StreamService;
import com.ecom.ssar.service.UserService;

@SpringBootApplication
@ComponentScan(basePackages = "com.ecom.ssar.*")
@EntityScan(basePackages = "com.ecom.ssar.common.vo")
@EnableTransactionManagement
// @Import(HibernateUtil.class)
@EnableCaching
public class SSarMain extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	private StreamService sr;
	
	@Autowired
	private UserService userService;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SSarMain.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SSarMain.class, args);

	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		List<String> quesLst = new ArrayList<>();
		quesLst.add("5#11");
		quesLst.add("5#11");
		quesLst.add("5#11");
		quesLst.add("5#13");
		quesLst.add("6#15");
		quesLst.add("6#15");
		quesLst.add("5#14");
		
		//userService.makeQuestionWithSubmitedOption(quesLst,1);
		
		String str = "5#11";
		
		
		
	}

}
