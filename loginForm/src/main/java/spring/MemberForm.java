package spring;

public class MemberForm {
	private	String email, name, password,passwordconfirm;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
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

	public String getPasswordconfirm() {
		return passwordconfirm;
	}

	public void setPasswordconfirm(String passwordconfirm) {
		this.passwordconfirm = passwordconfirm;
	} 
	
	public boolean equalConfirmPassword() {
		return password.equals(passwordconfirm);
	}
}
