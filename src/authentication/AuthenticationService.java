package authentication;

import java.util.*;
import model.*;

public final class AuthenticationService {	
	public static List<User> users = new ArrayList<>();
	
	public static void createUsers() {
		if (users.isEmpty()) {
			users.add(new Student("dias@uni.com", "123456"));
			users.add(new Student("nurasyl@uni.com", "123456"));
			users.add(new Teacher("pakita@uni.com", "123456"));
			users.add(new Manager("maqsat@uni.com", "123456", ManagerType.ADMINISTRATIVE, Department.COMPUTER_SCIENCE));
		}
	}
	
	public User authenticate(String email, String password) {
		for (User user : users) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				Session.setCurrentUser(user);
				
				return user;
			}
		}
		
		return null;
	}
}
