package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import database.JDBCUtil;
import model.SachModel;
import model.TacGiaModel;
import model.TheLoaiModel;

public class SachDao implements DAOInterface<SachModel> {

	public static SachDao getInstance() {
		return new SachDao();
	}

	@Override
	public int insert(SachModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into sach (maSach, tenSach, maTacGia, namXuatBan, giapNhap, giaGoc, giaBan, soLuong, maTheLoai, ngonNgu, moTa) values "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaSach());
			pst.setString(2, t.getTenSach());
			pst.setString(3, t.getTacGia().getMaTacGia());
			pst.setInt(4, t.getNamXuatBan());
			pst.setDouble(5, t.getGiaNhap());
			pst.setDouble(6, t.getGiaGoc());
			pst.setDouble(7, t.getGiaBan());
			pst.setInt(8, t.getSoLuong());
			pst.setString(9, t.getTheLoai().getMaTheLoai());
			pst.setString(10, t.getNgonNgu());
			pst.setString(11, t.getMoTa());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(SachModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update sach "
					+ "set tenSach=?, maTacGia=?, namXuatBan=?, giapNhap=?, giaGoc=?, giaBan=?, soLuong=?, maTheLoai=?, ngonNgu=?, moTa=? "
					+ "where maSach=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getTenSach());
			pst.setString(2, t.getTacGia().getMaTacGia());
			pst.setInt(3, t.getNamXuatBan());
			pst.setDouble(4, t.getGiaNhap());
			pst.setDouble(5, t.getGiaGoc());
			pst.setDouble(6, t.getGiaBan());
			pst.setInt(7, t.getSoLuong());
			pst.setString(8, t.getTheLoai().getMaTheLoai());
			pst.setString(9, t.getNgonNgu());
			pst.setString(10, t.getMoTa());
			pst.setString(11, t.getMaSach());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(SachModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from sach where maSach=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaSach());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public ArrayList<SachModel> selectAll() {
		ArrayList<SachModel> list = new ArrayList<SachModel>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from sach";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maSach = rs.getString("maSach");
				String tenSach = rs.getString("tenSach");
				String maTacGia = rs.getString("maTacGia");
				int namXuatBan = rs.getInt("namXuatBan");
				double giaNhap = rs.getDouble("giaNhap");
				double giaGoc = rs.getDouble("giaGoc");
				double giaBan = rs.getDouble("giaBan");
				int soLuong = rs.getInt("soLuong");
				String maTheLoai = rs.getString("maTheLoai");
				String ngonNgu = rs.getString("ngonNgu");
				String moTa = rs.getString("moTa");

				TacGiaModel tacGia = TacGiaDao.getInstance().selectById(new TacGiaModel(maTacGia));
				TheLoaiModel theLoai = TheLoaiDao.getInstance().selectById(new TheLoaiModel(maTheLoai));
				SachModel sach = new SachModel(maSach, tenSach, tacGia, namXuatBan, giaNhap, giaGoc, giaBan, soLuong,
						theLoai, ngonNgu, moTa);
				list.add(sach);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public SachModel selectById(SachModel t) {
		SachModel sach = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from sach where maSach=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaSach());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maSach = rs.getString("maSach");
				String tenSach = rs.getString("tenSach");
				String maTacGia = rs.getString("maTacGia");
				int namXuatBan = rs.getInt("namXuatBan");
				double giaNhap = rs.getDouble("giaNhap");
				double giaGoc = rs.getDouble("giaGoc");
				double giaBan = rs.getDouble("giaBan");
				int soLuong = rs.getInt("soLuong");
				String maTheLoai = rs.getString("maTheLoai");
				String ngonNgu = rs.getString("ngonNgu");
				String moTa = rs.getString("moTa");

				TacGiaModel tacGia = TacGiaDao.getInstance().selectById(new TacGiaModel(maTacGia));
				TheLoaiModel theLoai = TheLoaiDao.getInstance().selectById(new TheLoaiModel(maTheLoai));
				sach = new SachModel(maSach, tenSach, tacGia, namXuatBan, giaNhap, giaGoc, giaBan, soLuong, theLoai,
						ngonNgu, moTa);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sach;
	}

	@Override
	public SachModel selectByCondition(String t) {
		// TODO Auto-generated method stub
		return null;
	}

}
