package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
		@NamedQuery(name = "Video.findByKeyword", query = "SELECT DISTINCT o.video FROM Favorites o WHERE o.video.title LIKE:keyword"),
		@NamedQuery(name = "Video.findByUser", query = "SELECT o.video FROM Favorites o WHERE o.user.id=?0"),
		@NamedQuery(name = "Video.findInRange", query = "SELECT DISTINCT o.video FROM Favorites o WHERE o.likeDate BETWEEN :min AND :max"),
		@NamedQuery(name = "Video.findInMonths", query = "SELECT DISTINCT o.video FROM Favorites o WHERE month(o.likeDate) IN (:months)") })
@NamedNativeQueries({
		@NamedNativeQuery(name = "Report.random10", query = "SELECT TOP 10 * FROM Video ORDER BY newid()") })
@Entity
public class Video {
	@Id
	private String id;
	@Column(name = "title")
	private String title;
	@Column(name = "poster")
	private String poster;
	@Column(name = "description")
	private String description;
	@Column(name = "views")
	private Integer views = 0;
	@Column(name = "active")
	private Boolean active = false;
	@OneToMany(mappedBy = "video")
	private List<Favorites> favorites = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<Favorites> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorites> favorites) {
		this.favorites = favorites;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", title=" + title + ", poster=" + poster + ", description=" + description
				+ ", views=" + views + ", active=" + active + ", favorites=" + favorites + "]";
	}

}
