package com.sid.jpahiber.repository;

import static org.assertj.core.api.Assertions.contentOf;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sid.jpahiber.vo.Course;
import com.sid.jpahiber.vo.Review;

@Repository
@Transactional
public class CourseDao {
	
	@Autowired
	private EntityManager em;
	
	public void addReview(String rating, String Description,int courseId) {
		Course course = em.find(Course.class, courseId);
		
		Review review = new Review();
		review.setRatings(rating);
		review.setDescription(Description);
		
		//course.addReview(review);
		
		review.setCourse(course);
		
		
		em.persist(review);
	}
	
	public void pringreview() {
		Course course = em.find(Course.class, 1001);
		System.out.println("");
		System.out.println(course.getReview());
		
	}

}
