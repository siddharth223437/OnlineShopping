package com.sid.jpahiber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sid.jpahiber.repository.CourseDao;
import com.sid.jpahiber.repository.ProductDao;
import com.sid.jpahiber.repository.StudentDao;

@SpringBootApplication
//@Transactional
public class Demo1Application implements CommandLineRunner {
	
	@Autowired
	private StudentDao studentRepository;
	
	@Autowired
	private CourseDao courseRepository;
	
	@Autowired
	private ProductDao productRepository;

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Passport passport = new Passport();
//		passport.setPassportNumber("E123456");
//		Student stu = new Student();
//		stu.setStudentName("Siddharth");
//		stu.setPassport(passport);
//		studentRepository.saveStudentWithPassport(stu);
		
//		Student student = studentRepository.findById(8);
//		System.out.println(" ");
//		System.out.println(student.getPassport().getPassportNumber());
		
//		Passport passport = studentRepository.getStudentByPassportId(7);
//		System.out.println("");
//		System.out.println(passport.getStudent().getStudentName());
		
//		courseRepository.addReview("5", "Great Coursw", 1001);
//		courseRepository.addReview("5", "Nice teaching", 1001);
//		courseRepository.addReview("4", "Great tutorial", 1002);
		
		productRepository.addOrder(1001, 2, 689);
		
	}
}
