package com.sid.jpahiber.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sid.jpahiber.vo.Passport;
import com.sid.jpahiber.vo.Student;

@Repository
@Transactional
public class StudentDao {
	
	@Autowired
	private EntityManager em;
	
	public void saveStudentWithPassport(Student student) {
		em.persist(student.getPassport());
		em.persist(student);
	}
	
	public Student findById(int id) {
		Query query = em.createNativeQuery("select * from Student where studentId =?", Student.class);
		query.setParameter(1, id);
		Student st = (Student) query.getSingleResult();
		return st;
	}
	
	public Passport getStudentByPassportId(int id) {
		return em.find(Passport.class, id);
	}

}
