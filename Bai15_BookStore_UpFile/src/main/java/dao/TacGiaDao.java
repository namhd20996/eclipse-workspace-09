package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.TacGiaModel;

public class TacGiaDao implements DAOInterface<TacGiaModel> {

	public static TacGiaDao getInstance() {
		return new TacGiaDao();
	}

	@Override
	public int insert(TacGiaModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into tacgia (maTacGia, hoTen, ngaySinh, tieuSu) values " + "(?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaTacGia());
			pst.setString(2, t.getHoTen());
			pst.setDate(3, t.getNgaySinh());
			pst.setString(4, t.getTieuSu());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(TacGiaModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update tacgia " + "set hoTen=?, ngaySinh=?, tieuSu=? " + "where maTacGia=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getHoTen());
			pst.setDate(2, t.getNgaySinh());
			pst.setString(3, t.getTieuSu());
			pst.setString(4, t.getMaTacGia());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(TacGiaModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete form tacgia where maTacGia=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaTacGia());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public ArrayList<TacGiaModel> selectAll() {
		ArrayList<TacGiaModel> list = new ArrayList<TacGiaModel>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from tacgia";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maTacGia = rs.getString("maTacGia");
				String hoTen = rs.getString("hoTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String tieuSu = rs.getString("tieuSu");
				TacGiaModel tg = new TacGiaModel(maTacGia, hoTen, ngaySinh, tieuSu);
				list.add(tg);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public TacGiaModel selectById(TacGiaModel t) {
		TacGiaModel tg = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from tacgia where maTacGia=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaTacGia());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maTacGia = rs.getString("maTacGia");
				String hoTen = rs.getString("hoTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String tieuSu = rs.getString("tieuSu");
				tg = new TacGiaModel(maTacGia, hoTen, ngaySinh, tieuSu);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tg;
	}

	@Override
	public TacGiaModel selectByCondition(String t) {
		// TODO Auto-generated method stub
		return null;
	}

}
