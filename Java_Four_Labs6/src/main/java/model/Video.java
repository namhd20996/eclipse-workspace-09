package model;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Video {
	private String id;
	private String title;
	private String poster;
	private String description;
	private Integer views = 0;
	private Boolean active = false;
	@OneToMany(mappedBy = "video")
	private List<Favorites> favorites;

	public Video() {

	}

	public Video(String id, String title, String poster, String description, Integer views, Boolean active,
			List<Favorites> favorites) {
		this.id = id;
		this.title = title;
		this.poster = poster;
		this.description = description;
		this.views = views;
		this.active = active;
		this.favorites = favorites;
	}

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

}
