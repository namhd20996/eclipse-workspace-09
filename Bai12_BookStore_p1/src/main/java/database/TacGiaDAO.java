package database;

import java.util.ArrayList;

import model.TacGiaModel;

public class TacGiaDAO implements DAOInterface<TacGiaModel>{

private ArrayList<TacGiaModel> data = new ArrayList<>();
	
	@Override
	public ArrayList<TacGiaModel> selectAll() {
		return this.data;
	}

	@Override
	public TacGiaModel selectById(TacGiaModel t) {
		for (TacGiaModel tacGia : data) {
			if(data.equals(t)) {
				return tacGia;
			}
		}
		return null;
	}

	@Override
	public int insert(TacGiaModel t) {
		if (this.selectById(t)==null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<TacGiaModel> arr) {
		int dem = 0;
		for (TacGiaModel tacGia : arr) {
			dem+=this.insert(tacGia);
		}
		return dem;
	}

	@Override
	public int delete(TacGiaModel t) {
		if (this.selectById(t)!=null) {
			this.data.remove(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<TacGiaModel> arr) {
		int dem = 0;
		for (TacGiaModel tacGia : arr) {
			dem+=this.delete(tacGia);
		}
		return dem;
	}

	@Override
	public int update(TacGiaModel t) {
		if (this.selectById(t)!=null) {
			this.data.remove(t);
			this.data.add(t);
			return 1;
		}
		return 0;
	}
	
}
