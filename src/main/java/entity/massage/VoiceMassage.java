package entity.massage;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 *	MediaId	必须	通过素材管理中的接口上传多媒体文件，得到的id
 * @author Administrator
 *
 */

@XStreamAlias("xml")
@Component
public class VoiceMassage extends BaseMassage {
	
	@XStreamAlias("Voice")
	private Voice voice = new Voice();
	
	public VoiceMassage() {
		super();
		super.setMsgType("voice");
	}
	
	public VoiceMassage(Map<String, String> map) {
		super(map);
		super.setMsgType("voice");
	}

	public Voice getVoice() {
		return voice;
	}
	
	public void setVoice(String mediaId) {
		voice.setMediaId(mediaId); ;
	}
	
}

class Voice{
	@XStreamAlias("MediaId")
	private String mediaId ;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
}
