package model;

public class UserModel {
	private String userName;
	private String password;
	private Boolean remember;

	public UserModel() {

	}
	

	public UserModel(String userName, String password, Boolean remember) {
		this.userName = userName;
		this.password = password;
		this.remember = remember;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getRemember() {
		return remember;
	}

	public void setRemember(Boolean remember) {
		this.remember = remember;
	}

}
