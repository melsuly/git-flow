package model;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public final class CourseRegistrationSystem {
	public static List<Course> courses = new ArrayList<>();
	public static List<CourseApplication> applications = new ArrayList<>();
	
	public static void addApplication(CourseApplication application) {
		applications.add(application);
	}
	
	public static List<CourseApplication> getUncheckedApplications() {
		return applications.stream()
				.filter(application -> !application.getIsChecked())
				.collect(Collectors.toList());
	}
	
	public static List<CourseApplication> getApplicationOfStudent(Student student) {
		return applications.stream()
				.filter(application -> application.student == student)
				.collect(Collectors.toList());
	}
	
	public static List<Course> getAvailableCourses(Student student) {
		List<CourseApplication> studentApplications = getApplicationOfStudent(student);
		
		List<Course> appliedCourses = studentApplications.stream()
				.filter(application -> !application.isChecked || (application.isChecked && application.isApproved))
                .map(CourseApplication::getCourse)
                .collect(Collectors.toList());
		
		return courses.stream()
                .filter(course -> !appliedCourses.contains(course))
                .collect(Collectors.toList());
	}
	
	public static void addCourse(Course course) {
		courses.add(course);
	}
	
	public static void addCourses() {
		if (courses.isEmpty()) {
			courses.add(new Course("OOP-01", "Object orientied programming", 10, CourseType.MAJOR));
			courses.add(new Course("MATH-12", "Calculus", 10, CourseType.MINOR));
		}
	}
}
