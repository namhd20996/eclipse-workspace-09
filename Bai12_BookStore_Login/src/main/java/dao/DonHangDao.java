package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.DonHangModel;
import model.KhachHangModel;

public class DonHangDao implements DAOInterface<DonHangModel> {

	public static DonHangDao getInstance() {
		return new DonHangDao();
	}

	@Override
	public int insert(DonHangModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into donhang (maDonHang, maKhachHang, diaChiNguoiMua, diaChiNhanHang, trangThai, hinhThucTT, trangThaiTT, soTienDaTT, soTienCT, ngayDatHang, ngayGiaoHang) values "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaDonHang());
			pst.setString(2, t.getKhachHang().getMaKhachHang());
			pst.setString(3, t.getDiaChiNguoiMua());
			pst.setString(3, t.getDiaChiNhanHang());
			pst.setString(5, t.getTrangThai());
			pst.setString(6, t.getHinhThucTT());
			pst.setString(7, t.getTrangThaiTT());
			pst.setDouble(8, t.getSoTienDaTT());
			pst.setDouble(9, t.getSoTienCT());
			pst.setDate(10, t.getNgayDatHang());
			pst.setDate(11, t.getNgayGiaoHang());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(DonHangModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update donhang "
					+ "set maKhachHang=?, diaChiNguoiMua=?, diaChiNhanHang=?, trangThai=?, hinhThucTT=?, trangThaiTT=?, soTienDaTT=?, soTienCT=?, ngayDatHang=?, ngayGiaoHang=? "
					+ "where maDonHang =?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getKhachHang().getMaKhachHang());
			pst.setString(2, t.getDiaChiNguoiMua());
			pst.setString(3, t.getDiaChiNhanHang());
			pst.setString(4, t.getTrangThai());
			pst.setString(5, t.getHinhThucTT());
			pst.setString(6, t.getTrangThaiTT());
			pst.setDouble(7, t.getSoTienDaTT());
			pst.setDouble(8, t.getSoTienCT());
			pst.setDate(9, t.getNgayDatHang());
			pst.setDate(10, t.getNgayGiaoHang());
			pst.setString(11, t.getMaDonHang());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(DonHangModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from donhang where maDonHang=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaDonHang());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public ArrayList<DonHangModel> selectAll() {
		ArrayList<DonHangModel> list = new ArrayList<DonHangModel>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from donhang";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maDonHang = rs.getString("maDonHang");
				String maKhachHang = rs.getString("maKhachHang");
				String diaChiNguoiMua = rs.getString("diaChiNguoiMua");
				String diaChiNhanHang = rs.getString("diaChiNhanHang");
				String trangThai = rs.getString("trangThai");
				String hinhThucTT = rs.getString("hinhThucTT");
				String trangThaiTT = rs.getString("trangThaiTT");
				double soTienDaTT = rs.getDouble("soTienDaTT");
				double soTienCT = rs.getDouble("soTienCT");
				Date ngayDatHang = rs.getDate("ngayDatHang");
				Date ngayGiaoHang = rs.getDate("ngayGiaoHang");
				KhachHangModel kh = KhachHangDao.getInstance().selectById(new KhachHangModel(maKhachHang));
				DonHangModel dh = new DonHangModel(maDonHang, kh, diaChiNguoiMua, diaChiNhanHang, trangThai, hinhThucTT,
						trangThaiTT, soTienDaTT, soTienCT, ngayDatHang, ngayGiaoHang);
				list.add(dh);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public DonHangModel selectById(DonHangModel t) {
		DonHangModel dh = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from donhang where maDonHang=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaDonHang());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maDonHang = rs.getString("maDonHang");
				String maKhachHang = rs.getString("maKhachHang");
				String diaChiNguoiMua = rs.getString("diaChiNguoiMua");
				String diaChiNhanHang = rs.getString("diaChiNhanHang");
				String trangThai = rs.getString("trangThai");
				String hinhThucTT = rs.getString("hinhThucTT");
				String trangThaiTT = rs.getString("trangThaiTT");
				double soTienDaTT = rs.getDouble("soTienDaTT");
				double soTienCT = rs.getDouble("soTienCT");
				Date ngayDatHang = rs.getDate("ngayDatHang");
				Date ngayGiaoHang = rs.getDate("ngayGiaoHang");
				KhachHangModel kh = KhachHangDao.getInstance().selectById(new KhachHangModel(maKhachHang));
				dh = new DonHangModel(maDonHang, kh, diaChiNguoiMua, diaChiNhanHang, trangThai, hinhThucTT, trangThaiTT,
						soTienDaTT, soTienCT, ngayDatHang, ngayGiaoHang);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dh;
	}

	@Override
	public DonHangModel selectByCondition(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		ArrayList<DonHangModel> list = DonHangDao.getInstance().selectAll();
		for (DonHangModel donHangModel : list) {
			System.out.println(donHangModel);
		}
	}
}
