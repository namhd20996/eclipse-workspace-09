package model;

import java.util.Objects;

public class ChiTietDonHangModel {
	private String maCTTDH;
	private DonHangModel donHang;
	private SachModel maSach;
	private int soLuong;
	private double giaBia;
	private double giamGia;
	private double giaBan;
	private double thue;
	private double tongTien;

	public ChiTietDonHangModel() {

	}

	public ChiTietDonHangModel(String maCTTDH, DonHangModel donHang, SachModel maSach, int soLuong, double giaBia,
			double giamGia, double giaBan, double thue, double tongTien) {	
		this.maCTTDH = maCTTDH;
		this.donHang = donHang;
		this.maSach = maSach;
		this.soLuong = soLuong;
		this.giaBia = giaBia;
		this.giamGia = giamGia;
		this.giaBan = giaBan;
		this.thue = thue;
		this.tongTien = tongTien;
	}

	public String getMaCTTDH() {
		return maCTTDH;
	}

	public void setMaCTTDH(String maCTTDH) {
		this.maCTTDH = maCTTDH;
	}

	public DonHangModel getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHangModel donHang) {
		this.donHang = donHang;
	}

	public SachModel getMaSach() {
		return maSach;
	}

	public void setMaSach(SachModel maSach) {
		this.maSach = maSach;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaBia() {
		return giaBia;
	}

	public void setGiaBia(double giaBia) {
		this.giaBia = giaBia;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	@Override
	public String toString() {
		return "ChiTietDonHangModel [maCTTDH=" + maCTTDH + ", donHang=" + donHang + ", maSach=" + maSach + ", soLuong="
				+ soLuong + ", giaBia=" + giaBia + ", giamGia=" + giamGia + ", giaBan=" + giaBan + ", thue=" + thue
				+ ", tongTien=" + tongTien + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(donHang, giaBan, giaBia, giamGia, maCTTDH, maSach, soLuong, thue, tongTien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietDonHangModel other = (ChiTietDonHangModel) obj;
		return Objects.equals(donHang, other.donHang)
				&& Double.doubleToLongBits(giaBan) == Double.doubleToLongBits(other.giaBan)
				&& Double.doubleToLongBits(giaBia) == Double.doubleToLongBits(other.giaBia)
				&& Double.doubleToLongBits(giamGia) == Double.doubleToLongBits(other.giamGia)
				&& Objects.equals(maCTTDH, other.maCTTDH) && Objects.equals(maSach, other.maSach)
				&& soLuong == other.soLuong && Double.doubleToLongBits(thue) == Double.doubleToLongBits(other.thue)
				&& Double.doubleToLongBits(tongTien) == Double.doubleToLongBits(other.tongTien);
	}

}
