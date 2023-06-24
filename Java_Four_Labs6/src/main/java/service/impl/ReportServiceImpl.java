package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import converter.ReportConverter;
import dao.IReportDao;
import dto.ReportDTO;
import entity.Report;
import service.IReportService;

public class ReportServiceImpl implements IReportService {

	@Inject
	private IReportDao reportDao;

	@Override
	public List<Report> findList() {
		return reportDao.findList();
	}

	@Override
	public List<ReportDTO> findStore(int year) {
		Map<String, Object> params = new HashMap<>();
		params.put("year", year);
		return ReportConverter.getInstance().toListReport(reportDao.findStore(params));
	}

}
