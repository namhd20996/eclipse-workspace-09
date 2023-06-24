package model;

import java.sql.Date;
import java.util.Objects;

public class DonHangModel {
	private String maDonHang;
	private KhachHangModel khachHang;
	private String diaChiNguoiMua;
	private String diaChiNhanHang;
	private String trangThai;
	private String hinhThucTT;
	private String trangThaiTT;
	private double soTienDaTT;
	private double soTienCT;
	private Date ngayDatHang;
	private Date ngayGiaoHang;

	public DonHangModel() {

	}
	
	

	public DonHangModel(String maDonHang) {
		this.maDonHang = maDonHang;
	}



	public DonHangModel(String maDonHang, KhachHangModel khachHang, String diaChiNguoiMua, String diaChiNhanHang,
			String trangThai, String hinhThucTT, String trangThaiTT, double soTienDaTT, double soTienCT,
			Date ngayDatHang, Date ngayGiaoHang) {
		this.maDonHang = maDonHang;
		this.khachHang = khachHang;
		this.diaChiNguoiMua = diaChiNguoiMua;
		this.diaChiNhanHang = diaChiNhanHang;
		this.trangThai = trangThai;
		this.hinhThucTT = hinhThucTT;
		this.trangThaiTT = trangThaiTT;
		this.soTienDaTT = soTienDaTT;
		this.soTienCT = soTienCT;
		this.ngayDatHang = ngayDatHang;
		this.ngayGiaoHang = ngayGiaoHang;
	}

	public String getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public KhachHangModel getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHangModel khachHang) {
		this.khachHang = khachHang;
	}

	public String getDiaChiNguoiMua() {
		return diaChiNguoiMua;
	}

	public void setDiaChiNguoiMua(String diaChiNguoiMua) {
		this.diaChiNguoiMua = diaChiNguoiMua;
	}

	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}

	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getHinhThucTT() {
		return hinhThucTT;
	}

	public void setHinhThucTT(String hinhThucTT) {
		this.hinhThucTT = hinhThucTT;
	}

	public String getTrangThaiTT() {
		return trangThaiTT;
	}

	public void setTrangThaiTT(String trangThaiTT) {
		this.trangThaiTT = trangThaiTT;
	}

	public double getSoTienDaTT() {
		return soTienDaTT;
	}

	public void setSoTienDaTT(double soTienDaTT) {
		this.soTienDaTT = soTienDaTT;
	}

	public double getSoTienCT() {
		return soTienCT;
	}

	public void setSoTienCT(double soTienCT) {
		this.soTienCT = soTienCT;
	}

	public Date getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

	public Date getNgayGiaoHang() {
		return ngayGiaoHang;
	}

	public void setNgayGiaoHang(Date ngayGiaoHang) {
		this.ngayGiaoHang = ngayGiaoHang;
	}

	@Override
	public int hashCode() {
		return Objects.hash(diaChiNguoiMua, diaChiNhanHang, hinhThucTT, khachHang, maDonHang, ngayDatHang, ngayGiaoHang,
				soTienCT, soTienDaTT, trangThai, trangThaiTT);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonHangModel other = (DonHangModel) obj;
		return Objects.equals(diaChiNguoiMua, other.diaChiNguoiMua)
				&& Objects.equals(diaChiNhanHang, other.diaChiNhanHang) && Objects.equals(hinhThucTT, other.hinhThucTT)
				&& Objects.equals(khachHang, other.khachHang) && Objects.equals(maDonHang, other.maDonHang)
				&& Objects.equals(ngayDatHang, other.ngayDatHang) && Objects.equals(ngayGiaoHang, other.ngayGiaoHang)
				&& Double.doubleToLongBits(soTienCT) == Double.doubleToLongBits(other.soTienCT)
				&& Double.doubleToLongBits(soTienDaTT) == Double.doubleToLongBits(other.soTienDaTT)
				&& Objects.equals(trangThai, other.trangThai) && Objects.equals(trangThaiTT, other.trangThaiTT);
	}

	@Override
	public String toString() {
		return "DonHangModel [maDonHang=" + maDonHang + ", khachHang=" + khachHang + ", diaChiNguoiMua="
				+ diaChiNguoiMua + ", diaChiNhanHang=" + diaChiNhanHang + ", trangThai=" + trangThai + ", hinhThucTT="
				+ hinhThucTT + ", trangThaiTT=" + trangThaiTT + ", soTienDaTT=" + soTienDaTT + ", soTienCT=" + soTienCT
				+ ", ngayDatHang=" + ngayDatHang + ", ngayGiaoHang=" + ngayGiaoHang + "]";
	}

	
}
