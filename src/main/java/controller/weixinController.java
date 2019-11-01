package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import deal.Massagedeal;
import util.CheckSignature;

@Controller
public class weixinController {
	
	@Autowired Massagedeal massagedeal ;
	
	private final String TOKEN = "FSNB" ;
	/**
	 * 验证消息的确来自微信服务器
	 */
	@RequestMapping(value = "VX", method = RequestMethod.GET)
	@ResponseBody
	public String doGet(String signature, String timestamp, String nonce, String echostr) throws Exception{
		//System.out.println(signature + "|" + timestamp + "|" + nonce + "|" + echostr);
		if(signature == null || timestamp == null || nonce == null || echostr == null) {
			System.out.println("发送请求失败！请重试");
			return "";
		}
		if(CheckSignature.check(TOKEN, signature, timestamp, nonce)) {
			System.out.println("效验成功"); 
			return echostr;
		}
		return "";
	}
	
	@RequestMapping(value = "VX", method = RequestMethod.POST)
	@ResponseBody
	public String doPost(@RequestAttribute Map<String, String> map) throws Exception{
		String msgType = map.get("MsgType");
		System.out.println(msgType);
		switch(msgType) {
			case "text":
				return massagedeal.textdeal(map);
			case "image":
				return massagedeal.imagedeal(map);
			case "voice":
				return massagedeal.voicedeal(map);
			case "video":
				return massagedeal.videodeal(map);
			case "shortvideo":
				return massagedeal.shortvideodeal(map);
			case "location":
				return massagedeal.locationdeal(map);
			case "link":
				return massagedeal.linkdeal(map);
		}
		return "";
	}	
}
