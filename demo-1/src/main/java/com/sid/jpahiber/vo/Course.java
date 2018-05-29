package com.sid.jpahiber.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Course {
	
	@Id
	@GeneratedValue
	private int courseId;
	private String courseName;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="course")
	private List<Review> review = new ArrayList<>();

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<Review> getReview() {
		return review;
	}

	public void addReview(Review review) {
		this.review.add(review);
	}
	
	public void removeReview(Review review) {
		this.review.remove(review);
	}
	
	

}
