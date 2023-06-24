package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import database.JDBCUtil;
import model.KhachHangModel;

public class KhachHangDao implements DAOInterface<KhachHangModel> {

	public static KhachHangDao getInstance() {
		return new KhachHangDao();
	}

	@Override
	public int insert(KhachHangModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into khachhang (maKhachHang, tenDangNhap, matKhau, hoTen, gioiTinh, diaChi, diaChiNhanHang, diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBT) values "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaKhachHang());
			pst.setString(2, t.getTenDangNhap());
			pst.setString(3, t.getMatKhau());
			pst.setString(4, t.getHoTen());
			pst.setBoolean(5, t.isGioiTinh());
			pst.setString(6, t.getDiaChi());
			pst.setString(7, t.getDiaChiNhanHang());
			pst.setString(8, t.getDiaChiMuaHang());
			pst.setDate(9, t.getNgaySinh());
			pst.setString(10, t.getSoDienThoai());
			pst.setBoolean(11, t.isDangKyNhanTin());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(KhachHangModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update khachhang "
					+ "set tenDangNhap=?, matKhau=?, hoTen=?, gioiTinh=?, diaChi=?, diaChiNhanHang=?, diaChiMuaHang=?, ngaySinh=?, soDienThoai=?, email=?, dangKyNhanBT=? "
					+ "where maKhachHang=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getTenDangNhap());
			pst.setString(2, t.getMatKhau());
			pst.setString(3, t.getHoTen());
			pst.setBoolean(4, t.isGioiTinh());
			pst.setString(5, t.getDiaChi());
			pst.setString(6, t.getDiaChiNhanHang());
			pst.setString(7, t.getDiaChiMuaHang());
			pst.setDate(8, t.getNgaySinh());
			pst.setString(9, t.getSoDienThoai());
			pst.setBoolean(10, t.isDangKyNhanTin());
			pst.setString(11, t.getMaKhachHang());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(KhachHangModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from khachhang where maKhachHang=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaKhachHang());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public ArrayList<KhachHangModel> selectAll() {
		ArrayList<KhachHangModel> list = new ArrayList<KhachHangModel>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from khachhang";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maKhachHang = rs.getString("maKhachHang");
				String tenDangNhap = rs.getString("tenDangNhap");
				String matKhau = rs.getString("matKhau");
				String hoTen = rs.getString("hoTen");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String diaChi = rs.getString("diaChi");
				String diaChiNhanHang = rs.getString("diaChiNhanHang");
				String diaChiMuaHang = rs.getString("diaChiMuaHang");
				Date ngaySinh = rs.getDate("ngaySinh");
				String soDienThoai = rs.getString("soDienThoai");
				String email = rs.getString("email");
				boolean dangKyNhanBT = rs.getBoolean("dangKyNhanBT");
				KhachHangModel kh = new KhachHangModel(maKhachHang, tenDangNhap, matKhau, hoTen, gioiTinh, diaChi,
						diaChiNhanHang, diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBT);
				list.add(kh);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public KhachHangModel selectById(KhachHangModel t) {
		KhachHangModel kh = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from khachhang where maKhachHang=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaKhachHang());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maKhachHang = rs.getString("maKhachHang");
				String tenDangNhap = rs.getString("tenDangNhap");
				String matKhau = rs.getString("matKhau");
				String hoTen = rs.getString("hoTen");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String diaChi = rs.getString("diaChi");
				String diaChiNhanHang = rs.getString("diaChiNhanHang");
				String diaChiMuaHang = rs.getString("diaChiMuaHang");
				Date ngaySinh = rs.getDate("ngaySinh");
				String soDienThoai = rs.getString("soDienThoai");
				String email = rs.getString("email");
				boolean dangKyNhanBT = rs.getBoolean("dangKyNhanBT");
				kh = new KhachHangModel(maKhachHang, tenDangNhap, matKhau, hoTen, gioiTinh, diaChi, diaChiNhanHang,
						diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBT);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kh;
	}

	@Override
	public KhachHangModel selectByCondition(String t) {
		// TODO Auto-generated method stub
		return null;
	}

}
