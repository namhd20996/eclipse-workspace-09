package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Staff implements Serializable{
	private String hoTen;
	private String hinhAnh;
	private Date ngaySinh;
	private String quocTich;
	private boolean gioiTinh;
	private boolean ttHonNhan;
	private String[] soThich;
	private String ghiChu;

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getQuocTich() {
		return quocTich;
	}

	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public boolean isTtHonNhan() {
		return ttHonNhan;
	}

	public void setTtHonNhan(boolean ttHonNhan) {
		this.ttHonNhan = ttHonNhan;
	}

	public String[] getSoThich() {
		return soThich;
	}

	public void setSoThich(String[] soThich) {
		this.soThich = soThich;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

}
