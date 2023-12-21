package core;

import java.io.*;
import java.sql.SQLException;
import model.*;
import ui.*;
import authentication.AuthenticationService;
import database.database;

public final class Main {
	public static void main(String[] args) {
		CourseRegistrationSystem.addCourses();
		AuthenticationService.createUsers();
		
		try {
			database.connectToDB();
			database.createTables();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            AuthenticationService authService = new AuthenticationService();
        	
        	System.out.println("Welcome to the University Information System!");
        	
        	while (true) {
        		System.out.print("Enter email: ");
        		String email = reader.readLine();
        		System.out.print("Enter password: ");
        		String password = reader.readLine();
        		
        		User user = authService.authenticate(email, password);
        		
        		if (user != null) {
        			System.out.println("Authorized");
        			System.out.println(user.toString());
        			
        			MainMenu menu = getMenuForUser(user);
        			
                    if (menu != null) {
                        menu.showSpecificMenu();
                    }
        			
        			break;
        		} else {
        			System.out.println("Invalid credentials, please try again.");
        		}	
        	}
        	
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}
	
	private static MainMenu getMenuForUser(User user) {
        if (user instanceof Student) {
            return new StudentMenu();
        }
        
        if (user instanceof Manager) {
        	return new ManagerMenu();
        }
        
        return null;
    }
}
