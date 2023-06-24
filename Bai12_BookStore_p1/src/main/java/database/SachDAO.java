package database;

import java.util.ArrayList;

import model.SachModel;

public class SachDAO implements DAOInterface<SachModel>{
private ArrayList<SachModel> data = new ArrayList<>();
	
	@Override
	public ArrayList<SachModel> selectAll() {
		return this.data;
	}

	@Override
	public SachModel selectById(SachModel t) {
		for (SachModel SanPham : data) {
			if(data.equals(t)) {
				return SanPham;
			}
		}
		return null;
	}

	@Override
	public int insert(SachModel t) {
		if (this.selectById(t)==null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<SachModel> arr) {
		int dem = 0;
		for (SachModel SanPham : arr) {
			dem+=this.insert(SanPham);
		}
		return dem;
	}

	@Override
	public int delete(SachModel t) {
		if (this.selectById(t)!=null) {
			this.data.remove(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<SachModel> arr) {
		int dem = 0;
		for (SachModel SanPham : arr) {
			dem+=this.delete(SanPham);
		}
		return dem;
	}

	@Override
	public int update(SachModel t) {
		if (this.selectById(t)!=null) {
			this.data.remove(t);
			this.data.add(t);
			return 1;
		}
		return 0;
	}
}
