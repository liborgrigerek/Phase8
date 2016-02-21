package cz.morosystems.phase8.entity;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginEntity {
	Integer id;
	String login;
	String password;
	String confirmPassword;
	
	public Integer getId() {
		return id;
	}
	
	@NotEmpty
	public String getLogin() {
		return login;
	}
	
	@NotEmpty
	public String getPassword() {
		return password;
	}
	
	@NotEmpty
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
