package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="`User`")
public class User {
	@Id
	private String id;
	@Column
	private String password;
	@Column
	private String fullname;
	@Column
	private String email;
	@Column
	private Boolean admin = true;
	// Bên khóa chính cần khai báo mappedBy = "name" giống với tên biến bên phần
	// khóa ngoại đã khai báo trước đó
	// mappedby là tên của đặc tính liên kết bên sở hữu.
	@OneToMany(mappedBy = "user")
	private List<Favorites> favorites = new ArrayList<>();

	public User() {

	}

	public User(String id, String password, String fullname, String email, Boolean admin, List<Favorites> favorites) {
		this.id = id;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.admin = admin;
		this.favorites = favorites;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public List<Favorites> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorites> favorites) {
		this.favorites = favorites;
	}

}
