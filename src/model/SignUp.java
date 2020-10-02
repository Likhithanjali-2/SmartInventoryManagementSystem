package model;

public class SignUp {
     private String name, password,confirmPassword, email;
     
     public SignUp(String name, String password, String confirmPassword, String email) {
 		this.name = name;
 		this.password = password;
 		this.confirmPassword = confirmPassword;
 		this.email = email;
 	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}