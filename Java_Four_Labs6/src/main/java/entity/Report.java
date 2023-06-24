package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "Report.favoriteByYear", procedureName = "spFavoriteByYear", parameters = {
				@StoredProcedureParameter(name = "year", type = Integer.class) }) })

@Entity
@Table(name = "`Report`")
public class Report {
	@Id
	private Serializable group;
	@Column
	private Long likes;
	@Column
	private Date newest;
	@Column
	private Date oldest;

	public Report(Serializable group, Long likes, Date newest, Date oldest) {
		this.group = group;
		this.likes = likes;
		this.newest = newest;
		this.oldest = oldest;
	}

	public Serializable getGroup() {
		return group;
	}

	public void setGroup(Serializable group) {
		this.group = group;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	public Date getNewest() {
		return newest;
	}

	public void setNewest(Date newest) {
		this.newest = newest;
	}

	public Date getOldest() {
		return oldest;
	}

	public void setOldest(Date oldest) {
		this.oldest = oldest;
	}

	@Override
	public String toString() {
		return "Report [group=" + group + ", likes=" + likes + ", newest=" + newest + ", oldest=" + oldest + "]";
	}

}
