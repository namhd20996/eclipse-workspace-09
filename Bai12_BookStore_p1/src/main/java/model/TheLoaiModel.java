package model;

import java.util.Objects;

public class TheLoaiModel {
	private String maTheLoai;
	private String tenTheLoai;

	public TheLoaiModel() {

	}

	public TheLoaiModel(String maTheLoai, String tenTheLoai) {
		this.maTheLoai = maTheLoai;
		this.tenTheLoai = tenTheLoai;
	}

	public String getMaTheLoai() {
		return maTheLoai;
	}

	public void setMaTheLoai(String maTheLoai) {
		this.maTheLoai = maTheLoai;
	}

	public String getTenTheLoai() {
		return tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}

	@Override
	public String toString() {
		return "TheLoaiModel [maTheLoai=" + maTheLoai + ", tenTheLoai=" + tenTheLoai + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTheLoai, tenTheLoai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TheLoaiModel other = (TheLoaiModel) obj;
		return Objects.equals(maTheLoai, other.maTheLoai) && Objects.equals(tenTheLoai, other.tenTheLoai);
	}

}
