package database;

import java.util.ArrayList;

import model.DonHangModel;

public class DonHangDAO implements DAOInterface<DonHangModel>{
private ArrayList<DonHangModel> data = new ArrayList<>();
	
	@Override
	public ArrayList<DonHangModel> selectAll() {
		return this.data;
	}

	@Override
	public DonHangModel selectById(DonHangModel t) {
		for (DonHangModel DonHang : data) {
			if(data.equals(t)) {
				return DonHang;
			}
		}
		return null;
	}

	@Override
	public int insert(DonHangModel t) {
		if (this.selectById(t)==null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<DonHangModel> arr) {
		int dem = 0;
		for (DonHangModel DonHang : arr) {
			dem+=this.insert(DonHang);
		}
		return dem;
	}

	@Override
	public int delete(DonHangModel t) {
		if (this.selectById(t)!=null) {
			ChiTietDonHangDAO ctdh = new ChiTietDonHangDAO();
			ctdh.deleteAll(t);
			this.data.remove(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<DonHangModel> arr) {
		int dem = 0;
		for (DonHangModel DonHang : arr) {
			dem+=this.delete(DonHang);
		}
		return dem;
	}
	

	@Override
	public int update(DonHangModel t) {
		if (this.selectById(t)!=null) {
			this.data.remove(t);
			this.data.add(t);
			return 1;
		}
		return 0;
	}
}
