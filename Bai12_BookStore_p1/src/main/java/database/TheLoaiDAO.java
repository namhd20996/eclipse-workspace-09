package database;

import java.util.ArrayList;

import model.TheLoaiModel;

public class TheLoaiDAO implements DAOInterface<TheLoaiModel>{
private ArrayList<TheLoaiModel> data = new ArrayList<>();
	
	@Override
	public ArrayList<TheLoaiModel> selectAll() {
		return this.data;
	}

	@Override
	public TheLoaiModel selectById(TheLoaiModel t) {
		for (TheLoaiModel TheLoai : data) {
			if(data.equals(t)) {
				return TheLoai;
			}
		}
		return null;
	}

	@Override
	public int insert(TheLoaiModel t) {
		if (this.selectById(t)==null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<TheLoaiModel> arr) {
		int dem = 0;
		for (TheLoaiModel TheLoai : arr) {
			dem+=this.insert(TheLoai);
		}
		return dem;
	}

	@Override
	public int delete(TheLoaiModel t) {
		if (this.selectById(t)!=null) {
			this.data.remove(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<TheLoaiModel> arr) {
		int dem = 0;
		for (TheLoaiModel TheLoai : arr) {
			dem+=this.delete(TheLoai);
		}
		return dem;
	}

	@Override
	public int update(TheLoaiModel t) {
		if (this.selectById(t)!=null) {
			this.data.remove(t);
			this.data.add(t);
			return 1;
		}
		return 0;
	}
}
