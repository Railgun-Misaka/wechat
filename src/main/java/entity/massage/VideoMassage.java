package entity.massage;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 *	MediaId			必须			通过素材管理中的接口上传多媒体文件，得到的id
	Title			非必须		视频消息的标题
	Description		非必须		视频消息的描述
 * @author Administrator
 *
 */

@XStreamAlias("xml")
@Component
public class VideoMassage extends BaseMassage {
	@XStreamAlias("Video")
	private Video video = new Video() ;
	
	public VideoMassage() {
		super();
		super.setMsgType("video");
	}
	
	public VideoMassage(Map<String, String> map) {
		super(map);
		super.setMsgType("video");
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(String mediaId, String title, String description) {
		video.setMediaId(mediaId);
		video.setTitle(title);
		video.setDescription(description);
	}
	
	public void setVideo(String mediaId) {
		video.setMediaId(mediaId);
	}
}

class Video {
	@XStreamAlias("MediaId")
	private String mediaId ;
	@XStreamAlias("Title")
	private String title ;
	@XStreamAlias("Description")
	private String description;
	
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}