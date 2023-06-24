package service;

import java.util.List;

import dto.ReportDTO;
import entity.Report;

public interface IReportService {
	List<Report> findList();
	
	List<ReportDTO> findStore(int year);
}
