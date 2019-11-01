package entity.massage;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 *	Title			非必须		音乐标题
	Description		非必须		音乐描述
	MusicURL		非必须		音乐链接
	HQMusicUrl		非必须		高质量音乐链接，WIFI环境优先使用该链接播放音乐
	ThumbMediaId	必须			缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
 * @author Administrator
 *
 */

@XStreamAlias("xml")
@Component
public class MusicMassage extends BaseMassage {
	@XStreamAlias("Music")
	private Music music = new Music() ;
	
	public MusicMassage() {
		super();
		this.setMsgType("music");
	}
	
	public MusicMassage(Map<String, String> map) {
		super(map);
		this.setMsgType("music");
	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(String title, String description, String musicUrl, String hQMusicUrl, String thumbMediaId) {
		music.setTitle(title);
		music.setDescription(description);
		music.setMusicUrl(hQMusicUrl);
		music.sethQMusicUrl(hQMusicUrl);
		music.setThumbMediaId(thumbMediaId);
	}
}

class Music {
	
	@XStreamAlias("Title")
	private String title ;
	@XStreamAlias("Description")
	private String description ;
	@XStreamAlias("MusicUrl")
	private String musicUrl ;
	@XStreamAlias("HQMusicUrl")
	private String hQMusicUrl ;
	@XStreamAlias("ThumbMediaId")
	private String thumbMediaId ;
	
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
	public String getMusicUrl() {
		return musicUrl;
	}
	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}
	public String gethQMusicUrl() {
		return hQMusicUrl;
	}
	public void sethQMusicUrl(String hQMusicUrl) {
		this.hQMusicUrl = hQMusicUrl;
	}
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	
	
}
