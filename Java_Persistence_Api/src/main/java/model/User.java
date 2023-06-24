package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "passWord")
	private String passWord;
	@Column(name = "fullName")
	private String fullName;
	@Column(name = "email")
	private String email;
	@Column(name = "role")
	private Boolean role;

	public User() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getRole() {
		return role;
	}

	public void setRole(Boolean role) {
		this.role = role;
	}

}
