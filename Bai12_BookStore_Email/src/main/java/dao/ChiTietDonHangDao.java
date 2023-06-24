package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.ChiTietDonHangModel;
import model.DonHangModel;
import model.SachModel;

public class ChiTietDonHangDao implements DAOInterface<ChiTietDonHangModel> {

	public static ChiTietDonHangDao getInstance() {
		return new ChiTietDonHangDao();
	}

	@Override
	public int insert(ChiTietDonHangModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into chitietdonhang (maCTDH, maDonHang, maSach, soLuong, giaBia, giaGiam, giaBan, thue, tongTien) values "
					+ "(?, ?, ? ,? ,? ,? ,? ,? ,?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaCTDH());
			pst.setString(2, t.getDonHang().getMaDonHang());
			pst.setString(3, t.getMaSach().getMaSach());
			pst.setInt(4, t.getSoLuong());
			pst.setDouble(5, t.getGiaBia());
			pst.setDouble(6, t.getGiamGia());
			pst.setDouble(7, t.getGiaBan());
			pst.setDouble(8, t.getThue());
			pst.setDouble(9, t.getTongTien());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(ChiTietDonHangModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update chitietdonhang "
					+ "set maDonHang=?, maSach=?, soLuong=?, giaBia=?, giaGiam=?, giaBan=?, thue=?, tongTien=? "
					+ "where maCTDH=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getDonHang().getMaDonHang());
			pst.setString(2, t.getMaSach().getMaSach());
			pst.setInt(3, t.getSoLuong());
			pst.setDouble(4, t.getGiaBia());
			pst.setDouble(5, t.getGiamGia());
			pst.setDouble(6, t.getGiaBan());
			pst.setDouble(7, t.getThue());
			pst.setDouble(8, t.getTongTien());
			pst.setString(9, t.getMaCTDH());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(ChiTietDonHangModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from chitietdonhang where maCTDH=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaCTDH());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public ArrayList<ChiTietDonHangModel> selectAll() {
		ArrayList<ChiTietDonHangModel> list = new ArrayList<ChiTietDonHangModel>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from chitietdonhang";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maCTDH = rs.getString("maCTDH");
				String maDonHang = rs.getString("maDonHang");
				String maSach = rs.getString("maSach");
				int soLuong = rs.getInt("soLuong");
				double giaBia = rs.getDouble("giaBia");
				double giaGiam = rs.getDouble("giaGiam");
				double giaBan = rs.getDouble("giaBan");
				double thue = rs.getDouble("thue");
				double tongTien = rs.getDouble("tongTien");
				DonHangModel dh = DonHangDao.getInstance().selectById(new DonHangModel(maDonHang));
				SachModel sach = SachDao.getInstance().selectById(new SachModel(maSach));
				ChiTietDonHangModel ctdh = new ChiTietDonHangModel(maCTDH, dh, sach, soLuong, giaBia, giaGiam, giaBan,
						thue, tongTien);
				list.add(ctdh);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ChiTietDonHangModel selectById(ChiTietDonHangModel t) {
		ChiTietDonHangModel ctdh = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from chitietdonhang where maCTDH=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaCTDH());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maCTDH = rs.getString("maCTDH");
				String maDonHang = rs.getString("maDonHang");
				String maSach = rs.getString("maSach");
				int soLuong = rs.getInt("soLuong");
				double giaBia = rs.getDouble("giaBia");
				double giaGiam = rs.getDouble("giaGiam");
				double giaBan = rs.getDouble("giaBan");
				double thue = rs.getDouble("thue");
				double tongTien = rs.getDouble("tongTien");
				DonHangModel dh = DonHangDao.getInstance().selectById(new DonHangModel(maDonHang));
				SachModel sach = SachDao.getInstance().selectById(new SachModel(maSach));
				ctdh = new ChiTietDonHangModel(maCTDH, dh, sach, soLuong, giaBia, giaGiam, giaBan, thue, tongTien);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ctdh;
	}

	@Override
	public ChiTietDonHangModel selectByCondition(String t) {
		// TODO Auto-generated method stub
		return null;
	}

}
