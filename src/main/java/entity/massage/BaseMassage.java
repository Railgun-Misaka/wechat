package entity.massage;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * 	ToUserName  	必须        	接收方帐号（收到的OpenID）
	FromUserName 	必须 		开发者微信号
	CreateTime 		必须 		消息创建时间 （整型）
	MsgType 		必须 		消息类型，文本为text
 * @author Administrator
 *
 */

@XStreamAlias("xml")
@Component
public class BaseMassage {
	
	@XStreamAlias("ToUserName") 
	private String toUserName ;
	@XStreamAlias("FromUserName") 
	private String fromUserName ;
	@XStreamAlias("CreateTime") 
	private String createTime ;
	@XStreamAlias("MsgType") 
	private String msgType ;
	
	public BaseMassage() {
		this.setCreateTime(System.currentTimeMillis()/1000 + "");
	}
	
	public BaseMassage(Map<String, String> map) {
		this.setToUserName(map.get("FromUserName"));
		this.setFromUserName(map.get("ToUserName"));
		this.setCreateTime(System.currentTimeMillis()/1000 + "");
	}
	
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	public void putMap(Map<String, String> map) {
		this.setToUserName(map.get("FromUserName"));
		this.setFromUserName(map.get("ToUserName"));
	}
	
}
