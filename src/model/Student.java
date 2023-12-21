package model;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
	private List<Course> enrolledCourses;
	
	public Student(String email, String password) {
		super(email, password);
		enrolledCourses = new ArrayList<>();
	}

	public void enrollInCourse(Course course) {
		enrolledCourses.add(course);
	}
	
	public List<Course> getEnrolledCourses() {
		return this.enrolledCourses;
	}
}
