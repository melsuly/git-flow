package model;

public abstract class User {
	private String email;
	private String password;
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	 @Override
    public String toString() {
        return "User{" +
	       "email='" + email + '\'' +
	       ", userType='" + this.getClass().getSimpleName() + '\'' +
       '}';
	}
}
