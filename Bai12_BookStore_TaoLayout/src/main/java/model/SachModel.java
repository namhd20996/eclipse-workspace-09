package model;

import java.util.Objects;

public class SachModel {
	private String maSach;
	private String tenSach;
	private TacGiaModel tacGia;
	private int namXuatBan;
	private double giaNhap;
	private double giaGoc;
	private double giaBan;
	private int soLuong;
	private TheLoaiModel theLoai;
	private String ngonNgu;
	private String moTa;

	public SachModel() {

	}

	public SachModel(String maSach) {
		this.maSach = maSach;
	}

	public SachModel(String maSach, String tenSach, TacGiaModel tacGia, int namXuatBan, double giaNhap, double giaGoc,
			double giaBan, int soLuong, TheLoaiModel theLoai, String ngonNgu, String moTa) {
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.namXuatBan = namXuatBan;
		this.giaNhap = giaNhap;
		this.giaGoc = giaGoc;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.theLoai = theLoai;
		this.ngonNgu = ngonNgu;
		this.moTa = moTa;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public TacGiaModel getTacGia() {
		return tacGia;
	}

	public void setTacGia(TacGiaModel tacGia) {
		this.tacGia = tacGia;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public double getGiaGoc() {
		return giaGoc;
	}

	public void setGiaGoc(double giaGoc) {
		this.giaGoc = giaGoc;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public TheLoaiModel getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(TheLoaiModel theLoai) {
		this.theLoai = theLoai;
	}

	public String getNgonNgu() {
		return ngonNgu;
	}

	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Override
	public String toString() {
		return "SachModel [maSach=" + maSach + ", tenSach=" + tenSach + ", tacGia=" + tacGia + ", namXuatBan="
				+ namXuatBan + ", giaNhap=" + giaNhap + ", giaGoc=" + giaGoc + ", giaBan=" + giaBan + ", soLuong="
				+ soLuong + ", theLoai=" + theLoai + ", ngonNgu=" + ngonNgu + ", moTa=" + moTa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(giaBan, giaGoc, giaNhap, maSach, moTa, namXuatBan, ngonNgu, soLuong, tacGia, tenSach,
				theLoai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SachModel other = (SachModel) obj;
		return Double.doubleToLongBits(giaBan) == Double.doubleToLongBits(other.giaBan)
				&& Double.doubleToLongBits(giaGoc) == Double.doubleToLongBits(other.giaGoc)
				&& Double.doubleToLongBits(giaNhap) == Double.doubleToLongBits(other.giaNhap)
				&& Objects.equals(maSach, other.maSach) && Objects.equals(moTa, other.moTa)
				&& namXuatBan == other.namXuatBan && Objects.equals(ngonNgu, other.ngonNgu) && soLuong == other.soLuong
				&& Objects.equals(tacGia, other.tacGia) && Objects.equals(tenSach, other.tenSach)
				&& Objects.equals(theLoai, other.theLoai);
	}

}
