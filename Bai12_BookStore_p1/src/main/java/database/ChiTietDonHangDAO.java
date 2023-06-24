package database;

import java.util.ArrayList;

import model.ChiTietDonHangModel;
import model.DonHangModel;

public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHangModel>{
private ArrayList<ChiTietDonHangModel> data = new ArrayList<>();
	
	@Override
	public ArrayList<ChiTietDonHangModel> selectAll() {
		return this.data;
	}

	@Override
	public ChiTietDonHangModel selectById(ChiTietDonHangModel t) {
		for (ChiTietDonHangModel ChiTietDonHang : data) {
			if(data.equals(t)) {
				return ChiTietDonHang;
			}
		}
		return null;
	}

	@Override
	public int insert(ChiTietDonHangModel t) {
		if (this.selectById(t)==null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<ChiTietDonHangModel> arr) {
		int dem = 0;
		for (ChiTietDonHangModel ChiTietDonHang : arr) {
			dem+=this.insert(ChiTietDonHang);
		}
		return dem;
	}

	@Override
	public int delete(ChiTietDonHangModel t) {
		if (this.selectById(t)!=null) {
			this.data.remove(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<ChiTietDonHangModel> arr) {
		int dem = 0;
		for (ChiTietDonHangModel ChiTietDonHang : arr) {
			dem+=this.delete(ChiTietDonHang);
		}
		return dem;
	}
	
	public int deleteAll(DonHangModel dh) {
		int dem = 0;
		for (ChiTietDonHangModel chiTietChiTietDonHang : data) {
			if(chiTietChiTietDonHang.getDonHang().equals(dh)) {
				this.delete(chiTietChiTietDonHang);
			}
		}
		return dem;
	}

	@Override
	public int update(ChiTietDonHangModel t) {
		if (this.selectById(t)!=null) {
			this.data.remove(t);
			this.data.add(t);
			return 1;
		}
		return 0;
	}
}
