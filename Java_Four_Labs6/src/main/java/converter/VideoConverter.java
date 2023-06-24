package converter;

import java.util.ArrayList;
import java.util.List;

import dto.VideoDTO;

public class VideoConverter {

	public static VideoConverter getInstance() {
		return new VideoConverter();
	}

	public List<VideoDTO> toListVideo(List<Object[]> objects) {
		List<VideoDTO> videos = new ArrayList<>();
		objects.forEach(item -> {
			VideoDTO video = new VideoDTO();
			video.setId((String) item[0]);
			video.setTitle((String) item[4]);
			video.setViews((Integer) item[5]);
			video.setActive((Boolean) item[1]);
			videos.add(video);
		});
		return videos;
	}
}
