package converter;

import java.util.ArrayList;
import java.util.List;

import dto.ReportDTO;
import util.DateUtil;

public class ReportConverter {

	public static ReportConverter getInstance() {
		ReportConverter a = null;
		if (a == null) {
			a = new ReportConverter();
		}
		return a;
	}

	public List<ReportDTO> toListReport(List<Object[]> objects) {
		List<ReportDTO> reports = new ArrayList<>();
		objects.forEach(item -> {
			ReportDTO reportDTO = new ReportDTO();
			reportDTO.setGroup(Long.valueOf(item[0]+""));
			reportDTO.setLikes(Long.valueOf(item[1]+""));
			reportDTO.setNewest(DateUtil.getInstance().toDate(item[2] + "", "yyy-MM-dd"));
			reportDTO.setOldest(DateUtil.getInstance().toDate(item[3] + "", "yyy-MM-dd"));
			reports.add(reportDTO);
		});
		return reports;
	}
}
