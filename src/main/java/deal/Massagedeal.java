package deal;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.*;
import entity.massage.MusicMassage;
import entity.massage.NewsMassage;
import entity.massage.TextMassage;
import entity.massage.VideoMassage;
import entity.massage.VoiceMassage;
import util.EntitytoXML;

@Component
public class Massagedeal {
	
	@Autowired TextMassage textMassage ;
	@Autowired MusicMassage musicMassage ;
	@Autowired NewsMassage newsMassage ;
	@Autowired VideoMassage videoMassage ;
	@Autowired VoiceMassage voiceMassage ;
	
	public String textdeal(Map<String, String> map) {
		newsMassage.putMap(map);
		newsMassage.updateLastArticle("五更琉璃", "黑猫", "http://flly.free.idcfengye.com/img/五更 瑠璃.jpg", "mxd.sdo.com");
		return EntitytoXML.transform(newsMassage);
	}
	public String imagedeal(Map<String, String> map) {
		
		return null;
	}
	public String voicedeal(Map<String, String> map) {
		
		return null;
	}
	public String videodeal(Map<String, String> map) {
		
		return null;
	}
	public String shortvideodeal(Map<String, String> map) {
		
		return null;
	}
	public String locationdeal(Map<String, String> map) {
		
		return null;
	}
	public String linkdeal(Map<String, String> map) {
		
		return null;
	}
}
