package dao;

import java.util.List;
import java.util.Map;

import entity.Report;

public interface IReportDao {
	List<Report> findList();
	List<Object[]> findStore(Map<String, Object> params);
}
