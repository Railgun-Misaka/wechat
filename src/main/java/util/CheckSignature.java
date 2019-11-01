package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckSignature {
	public static boolean check(String TOKEN, String signature, String timestamp, String nonce) {
		// 1）将token、timestamp、nonce三个参数进行字典序排序 
		List<String> ss = new ArrayList<String>();
		ss.add(timestamp);
		ss.add(nonce);
		ss.add(TOKEN);
		Collections.sort(ss);
		// 2）将三个参数字符串拼接成一个字符串进行sha1加密
		String str = ss.get(0) + ss.get(1) + ss.get(2);
		String newsignature = sha1(str);
		System.out.println("signature :" + signature);
		System.out.println("newsignature :" + newsignature);
		// 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		if(signature.equals(newsignature))
			return true;
		return false;
	}
	
	/**
	 *sha1加密 
	 *@param str
	 *@return
	 *by Fly
	 */
	private static String sha1(String str) {
		try {
			//获取一个加密对象
			MessageDigest md = MessageDigest.getInstance("sha1");
			//加密
			byte[] digest = md.digest(str.getBytes());
			char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
			StringBuilder sb = new StringBuilder();
			for (byte b : digest) {
				sb.append(c[(b>>4)&15]);
				sb.append(c[b&15]);
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}
}
