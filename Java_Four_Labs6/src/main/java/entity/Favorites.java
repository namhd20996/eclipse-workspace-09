package entity;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
// Tạo thuộc tính Unique cho column database
@Table(name = "Favorites", uniqueConstraints = { @UniqueConstraint(columnNames = { "userId", "videoId" }) })
public class Favorites {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	// name để lưu tên cột trong database khu lưu xuống
	@JoinColumn(name = "userId")
	@ManyToOne
	private User user;
	@JoinColumn(name = "videoId")
	@ManyToOne
	private Video video;
	// Mô tả kiểu dữ liệu time
	@Temporal(TemporalType.DATE)
	private Date likeDate;

	public Favorites() {

	}

	public Favorites(Long id, User user, Video video, Date likeDate) {
		this.id = id;
		this.user = user;
		this.video = video;
		this.likeDate = likeDate;
	}

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Date getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}

}
