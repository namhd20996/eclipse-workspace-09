package model;

import java.sql.Date;
import java.util.Objects;

public class TacGiaModel {
	private String maTacGia;
	private String hoTen;
	private Date ngaySinh;
	private String tieuSu;

	public TacGiaModel() {

	}

	public TacGiaModel(String maTacGia, String hoTen, Date ngaySinh, String tieuSu) {
		this.maTacGia = maTacGia;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.tieuSu = tieuSu;
	}

	public String getMaTacGia() {
		return maTacGia;
	}

	public void setMaTacGia(String maTacGia) {
		this.maTacGia = maTacGia;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getTieuSu() {
		return tieuSu;
	}

	public void setTieuSu(String tieuSu) {
		this.tieuSu = tieuSu;
	}

	@Override
	public String toString() {
		return "TacGiaModel [maTacGia=" + maTacGia + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", tieuSu="
				+ tieuSu + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(hoTen, maTacGia, ngaySinh, tieuSu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TacGiaModel other = (TacGiaModel) obj;
		return Objects.equals(hoTen, other.hoTen) && Objects.equals(maTacGia, other.maTacGia)
				&& Objects.equals(ngaySinh, other.ngaySinh) && Objects.equals(tieuSu, other.tieuSu);
	}

}
