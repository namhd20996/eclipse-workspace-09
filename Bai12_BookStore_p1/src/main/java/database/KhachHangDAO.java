package database;

import java.util.ArrayList;

import model.KhachHangModel;

public class KhachHangDAO implements DAOInterface<KhachHangModel>{
private ArrayList<KhachHangModel> data = new ArrayList<>();
	
	@Override
	public ArrayList<KhachHangModel> selectAll() {
		return this.data;
	}

	@Override
	public KhachHangModel selectById(KhachHangModel t) {
		for (KhachHangModel KhachHang : data) {
			if(data.equals(t)) {
				return KhachHang;
			}
		}
		return null;
	}

	@Override
	public int insert(KhachHangModel t) {
		if (this.selectById(t)==null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<KhachHangModel> arr) {
		int dem = 0;
		for (KhachHangModel KhachHang : arr) {
			dem+=this.insert(KhachHang);
		}
		return dem;
	}

	@Override
	public int delete(KhachHangModel t) {
		if (this.selectById(t)!=null) {
			this.data.remove(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<KhachHangModel> arr) {
		int dem = 0;
		for (KhachHangModel KhachHang : arr) {
			dem+=this.delete(KhachHang);
		}
		return dem;
	}

	@Override
	public int update(KhachHangModel t) {
		if (this.selectById(t)!=null) {
			this.data.remove(t);
			this.data.add(t);
			return 1;
		}
		return 0;
	}
}
