package ui;

import java.io.IOException;
import java.util.List;

import authentication.Session;
import model.Course;
import model.CourseApplication;
import model.CourseRegistrationSystem;
import model.Student;

public final class StudentMenu extends MainMenu {
	@Override
    public void showSpecificMenu() throws IOException {
        while (true) {
        	System.out.println("Student Menu:");
            System.out.println("");
            System.out.println("1. View Courses");
            System.out.println("2. Register for Courses");
            System.out.println("3. View my applications");
            System.out.println("");
            
            showCommonOptions();

            String choice = reader.readLine();

            if (handleCommonChoice(choice)) {
                break;
            }

            switch (choice.trim()) {
                case "1":
                	showCourses();
                    break;
                case "2":
                	showRegisterCourse();
                    break;
                case "3":
                	showMyApplications();
                	break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
	
	private void showCourses() throws IOException {
		
		Student student = (Student) Session.getCurrentUser();
		
		List<Course> enrolledCourses = student.getEnrolledCourses();
		
		 if (enrolledCourses.isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            System.out.println("Enrolled Courses:");
            for (Course course : enrolledCourses) {
                System.out.println(course.getName() + " - " + course.getCourseId());
            }
        }
  
		System.out.println("");
		System.out.println("Press Enter to go back");
		System.out.println("");
		
		reader.readLine();
	}
	
	private void showMyApplications() throws IOException {
		Student student = (Student) Session.getCurrentUser();
		List<CourseApplication> applications = CourseRegistrationSystem.getApplicationOfStudent(student);
		
		if (applications.isEmpty()) {
			System.out.println("No applications!");
			
			System.out.println("");
			System.out.println("Press Enter to go back");
			System.out.println("");
			
			reader.readLine();
		} else {
			for (int i = 0; i < applications.size(); i++) {
				CourseApplication application = applications.get(i);
				
				String status;
				
				if (!application.getIsChecked()) {
					status = "Not checked!";
				} else if (application.getIsApproved()) {
					status = "Approved!";
				} else {
					status = "Rejected!";
				}
				
				System.out.println(i + 1 + ". " + application.toString() + ". Status: " + status);
			}
			
			System.out.println("");
			System.out.println("Press Enter to go back");
			System.out.println("");
			
			reader.readLine();
		}
	}
	
	private void showRegisterCourse() throws IOException {
		Student student = (Student) Session.getCurrentUser();
		List<Course> courses = CourseRegistrationSystem.getAvailableCourses(student);
		
		if (courses.isEmpty()) {
			System.out.println("No available courses!");
			
			System.out.println("");
			System.out.println("Press Enter to go back");
			System.out.println("");
			
			reader.readLine();
		} else {
			for (int i = 0; i < courses.size(); i++) {
				Course course = courses.get(i);
				
				System.out.println(i + 1 + ". " + course.toString());
			}
			
			System.out.println("");
			System.out.print("Type number of course: ");
			
			while (true) {
				int index = Integer.parseInt(reader.readLine());
				
				if (index > courses.size() || index < 1) {
					System.out.println("Invalid number.");
				} else {
					Course selectedCourse = courses.get(index - 1);
					CourseApplication application = new CourseApplication(student, selectedCourse);
					
					CourseRegistrationSystem.addApplication(application);
					
					System.out.println("Successfully requested!");
					
					break;
				}
			}
		}

	}
}
