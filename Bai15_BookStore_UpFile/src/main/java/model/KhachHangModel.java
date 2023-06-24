package model;

import java.sql.Date;
import java.util.Objects;

public class KhachHangModel {
	private String maKhachHang;
	private String tenDangNhap;
	private String matKhau;
	private String hoTen;
	private boolean gioiTinh;
	private String diaChi;
	private String diaChiNhanHang;
	private String diaChiMuaHang;
	private Date ngaySinh;
	private String soDienThoai;
	private String email;
	private boolean dangKyNhanTin;
	private String maXacThuc;
	private Date thoiGianHieuLucMaXacThuc;
	private boolean trangThaiXacThuc;
	private String duongDanAnh;

	public KhachHangModel() {

	}

	public KhachHangModel(String maKhachHang, String tenDangNhap, String matKhau, String hoTen, boolean gioiTinh,
			String diaChi, String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String soDienThoai, String email,
			boolean dangKyNhanTin, String maXacThuc, Date thoiGianHieuLucMaXacThuc, boolean trangThaiXacThuc) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.dangKyNhanTin = dangKyNhanTin;
		this.maXacThuc = maXacThuc;
		this.thoiGianHieuLucMaXacThuc = thoiGianHieuLucMaXacThuc;
		this.trangThaiXacThuc = trangThaiXacThuc;
	}

	public KhachHangModel(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public KhachHangModel(String maKhachHang, String hoTen, boolean gioiTinh, String diaChi, String diaChiNhanHang,
			String diaChiMuaHang, Date ngaySinh, String soDienThoai, String email, boolean dangKyNhanTin) {
		this.maKhachHang = maKhachHang;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.dangKyNhanTin = dangKyNhanTin;
	}

	public KhachHangModel(String maKhachHang, String tenDangNhap, String matKhau, String hoTen, boolean gioiTinh,
			String diaChi, String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String soDienThoai, String email,
			boolean dangKyNhanTin) {
		this.maKhachHang = maKhachHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.dangKyNhanTin = dangKyNhanTin;
	}

	
	public KhachHangModel(String maKhachHang, String tenDangNhap, String matKhau, String hoTen, boolean gioiTinh,
			String diaChi, String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String soDienThoai, String email,
			boolean dangKyNhanTin, String maXacThuc, Date thoiGianHieuLucMaXacThuc, boolean trangThaiXacThuc,
			String duongDanAnh) {
		this.maKhachHang = maKhachHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.dangKyNhanTin = dangKyNhanTin;
		this.maXacThuc = maXacThuc;
		this.thoiGianHieuLucMaXacThuc = thoiGianHieuLucMaXacThuc;
		this.trangThaiXacThuc = trangThaiXacThuc;
		this.duongDanAnh = duongDanAnh;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}

	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}

	public String getDiaChiMuaHang() {
		return diaChiMuaHang;
	}

	public void setDiaChiMuaHang(String diaChiMuaHang) {
		this.diaChiMuaHang = diaChiMuaHang;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isDangKyNhanTin() {
		return dangKyNhanTin;
	}

	public void setDangKyNhanTin(boolean dangKyNhanTin) {
		this.dangKyNhanTin = dangKyNhanTin;
	}

	public String getMaXacThuc() {
		return maXacThuc;
	}

	public void setMaXacThuc(String maXacThuc) {
		this.maXacThuc = maXacThuc;
	}

	public Date getThoiGianHieuLucMaXacThuc() {
		return thoiGianHieuLucMaXacThuc;
	}

	public void setThoiGianHieuLucMaXacThuc(Date thoiGianHieuLucMaXacThuc) {
		this.thoiGianHieuLucMaXacThuc = thoiGianHieuLucMaXacThuc;
	}

	public boolean isTrangThaiXacThuc() {
		return trangThaiXacThuc;
	}

	public void setTrangThaiXacThuc(boolean trangThaiXacThuc) {
		this.trangThaiXacThuc = trangThaiXacThuc;
	}

	public String getDuongDanAnh() {
		return duongDanAnh;
	}

	public void setDuongDanAnh(String duongDanAnh) {
		this.duongDanAnh = duongDanAnh;
	}

	@Override
	public String toString() {
		return "KhachHangModel [maKhachHang=" + maKhachHang + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau
				+ ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", diaChiNhanHang="
				+ diaChiNhanHang + ", diaChiMuaHang=" + diaChiMuaHang + ", ngaySinh=" + ngaySinh + ", soDienThoai="
				+ soDienThoai + ", email=" + email + ", dangKyNhanTin=" + dangKyNhanTin + ", maXacThuc=" + maXacThuc
				+ ", thoiGianHieuLucMaXacThuc=" + thoiGianHieuLucMaXacThuc + ", trangThaiXacThuc=" + trangThaiXacThuc
				+ ", duongDanAnh=" + duongDanAnh + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dangKyNhanTin, diaChi, diaChiMuaHang, diaChiNhanHang, duongDanAnh, email, gioiTinh, hoTen,
				maKhachHang, maXacThuc, matKhau, ngaySinh, soDienThoai, tenDangNhap, thoiGianHieuLucMaXacThuc,
				trangThaiXacThuc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHangModel other = (KhachHangModel) obj;
		return dangKyNhanTin == other.dangKyNhanTin && Objects.equals(diaChi, other.diaChi)
				&& Objects.equals(diaChiMuaHang, other.diaChiMuaHang)
				&& Objects.equals(diaChiNhanHang, other.diaChiNhanHang)
				&& Objects.equals(duongDanAnh, other.duongDanAnh) && Objects.equals(email, other.email)
				&& gioiTinh == other.gioiTinh && Objects.equals(hoTen, other.hoTen)
				&& Objects.equals(maKhachHang, other.maKhachHang) && Objects.equals(maXacThuc, other.maXacThuc)
				&& Objects.equals(matKhau, other.matKhau) && Objects.equals(ngaySinh, other.ngaySinh)
				&& Objects.equals(soDienThoai, other.soDienThoai) && Objects.equals(tenDangNhap, other.tenDangNhap)
				&& Objects.equals(thoiGianHieuLucMaXacThuc, other.thoiGianHieuLucMaXacThuc)
				&& trangThaiXacThuc == other.trangThaiXacThuc;
	}

}
