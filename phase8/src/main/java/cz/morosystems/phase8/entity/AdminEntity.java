package cz.morosystems.phase8.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "ADMINTABLE")
public class AdminEntity {

	private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "LOGIN")
	private String login;

	@Column(name = "PASSWORD")
	private String password;
	
	public AdminEntity(LoginEntity loginEntity) {
		this.id = loginEntity.id;
		this.login = loginEntity.getLogin();
		// zahashuj heslo
		String password = loginEntity.getPassword();
		String hashedPassword = passwordEncoder.encode(password);
		this.password = hashedPassword;
	}
	
	public AdminEntity() {
		this.login = "";
		this.password = "";
	}

	public Integer getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
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
}
