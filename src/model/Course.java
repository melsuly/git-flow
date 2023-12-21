package model;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private String courseId;
	private String name;
    private List<Teacher> instructors;
    private List<Student> enrolledStudents;
    private int maxCapacity;
    private CourseType courseType;

    public Course(String courseId, String name, int maxCapacity, CourseType courseType) {
        this.courseId = courseId;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.courseType = courseType;
        this.instructors = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public List<Teacher> getInstructors() {
        return instructors;
    }

    public void addInstructor(Teacher instructor) {
        instructors.add(instructor);
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent(Student student) {
        if (enrolledStudents.size() < maxCapacity) {
            enrolledStudents.add(student);
        } else {
            System.out.println("Course is at full capacity.");
        }
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public CourseType getCourseType() {
        return courseType;
    }
    
    @Override
    public String toString() {
        return courseId + ": " + name;
    }
}
