package entity.massage;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 	Content	必须	回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
 * @author Administrator
 *
 */

@XStreamAlias("xml")
@Component
public class TextMassage extends BaseMassage {
	
	@XStreamAlias("Content")
	private String content ;
	
	public TextMassage() {
		super();
		this.setMsgType("text");
	}
	
	public TextMassage(Map<String, String> map) {
		super(map);
		this.setMsgType("text");
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}