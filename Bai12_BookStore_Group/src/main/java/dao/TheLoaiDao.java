package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.TheLoaiModel;

public class TheLoaiDao implements DAOInterface<TheLoaiModel> {

	public static TheLoaiDao getInstance() {
		return new TheLoaiDao();
	}

	@Override
	public int insert(TheLoaiModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into theloai (maTheLoai, tenTheLoai) values " + "(?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaTheLoai());
			pst.setString(2, t.getTenTheLoai());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(TheLoaiModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update theloai " + "set tenTheLoai=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getTenTheLoai());
			pst.setString(2, t.getMaTheLoai());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(TheLoaiModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from theloai where maTheLoai=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaTheLoai());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public ArrayList<TheLoaiModel> selectAll() {
		ArrayList<TheLoaiModel> list = new ArrayList<TheLoaiModel>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from theloai";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maTheLoai = rs.getString("maTheLoai");
				String tenTheLoai = rs.getString("tenTheLoai");
				TheLoaiModel tl = new TheLoaiModel(maTheLoai, tenTheLoai);
				list.add(tl);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public TheLoaiModel selectById(TheLoaiModel t) {
		TheLoaiModel tl = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from theloai where maTheLoai=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaTheLoai());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maTheLoai = rs.getString("maTheLoai");
				String tenTheLoai = rs.getString("tenTheLoai");
				tl = new TheLoaiModel(maTheLoai, tenTheLoai);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tl;
	}

	@Override
	public TheLoaiModel selectByCondition(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertList(ArrayList<TheLoaiModel> arr) {
		int count = 0;
		for (TheLoaiModel theLoaiModel : arr) {
			count += this.insert(theLoaiModel);
		}
		return count;
	}

	public int deleteList(ArrayList<TheLoaiModel> arr) {
		int count = 0;
		for (TheLoaiModel theLoaiModel : arr) {
			count += this.delete(theLoaiModel);
		}
		return count;
	}
}
