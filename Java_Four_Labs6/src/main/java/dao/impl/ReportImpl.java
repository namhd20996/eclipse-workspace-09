package dao.impl;

import java.util.List;
import java.util.Map;

import dao.AbstractDao;
import dao.IReportDao;
import entity.Report;

public class ReportImpl extends AbstractDao<Report> implements IReportDao {

	@Override
	public List<Report> findList() {
		String sql = "SELECT new Report(o.video.title, count(o), max(o.likeDate), min(o.likeDate)) FROM Favorites o GROUP BY o.video.title";
		return findMany(Report.class, sql);
	}

	@Override
	public List<Object[]> findStore(Map<String, Object> params) {
		return callStored("Report.favoriteByYear", params);
	}

}
