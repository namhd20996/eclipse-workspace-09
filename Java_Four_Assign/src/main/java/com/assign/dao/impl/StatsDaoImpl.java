package com.assign.dao.impl;

import java.util.List;

import com.assign.converter.StatsConverter;
import com.assign.dao.AbstractDao;
import com.assign.dao.IStatsDao;
import com.assign.dto.VideoLikedInfo;

public class StatsDaoImpl extends AbstractDao<Object[]> implements IStatsDao {

	@Override
	public List<VideoLikedInfo> findVideoLikedInfo() {
		String sql = "select\r\n" + "	v.id, v.title, v.href, sum(CAST(h.islike as int)) as totalLike\r\n" + "from\r\n"
				+ "	video v left join history h on v.id = h.videoid\r\n" + "where\r\n" + "	v.isActive = 1\r\n"
				+ "group by \r\n" + "	v.id, v.title, v.href\r\n" + "order by \r\n"
				+ "	sum(CAST(h.islike as int)) desc";
		List<Object[]> objects = findManyByNativeQuery(Object[].class, sql);
		return StatsConverter.getInstance().toListVideoInfo(objects);
	}

}
