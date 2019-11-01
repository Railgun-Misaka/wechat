package entity.token;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import cn.hutool.json.JSONObject;
import util.EntitytoXML;
import util.XMLtoMAP;

/**
 *       获取access_token
 * @author Administrator
 *
 */

@XStreamAlias("xml")
public class Get_access_token {
	
	private String grant_type = "client_credential" ;
	private String appid = "wxfd2295a9448b9c50";
	private String secret = "883cb0db935bb2df418977c0d7e29810";
	private String access_token ;
	private String expires_in ;
	private String date ;
	@XStreamOmitField
	private String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	@XStreamOmitField
	private File file ;
	
	public Get_access_token() {
		file = new File(System.getProperty("user.dir") + "/target/classes/Access_Token.xml");
		if(file.exists()) {
			try(FileInputStream fis = new FileInputStream(file)){
				Map<String, String> map = XMLtoMAP.transform(fis);
				this.grant_type = map.get("grant_type");
				this.appid = map.get("appid");
				this.secret = map.get("secret");
				this.access_token = map.get("access_token");
				this.expires_in = map.get("expires_in");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getAccess_token() {
		
		if(null == access_token || access_token.equals("")) 
			gainAccess_token();
		
		if(isOverdue())
			gainAccess_token();
		
		return access_token;
	}
	
	
	/**
	 * 判断是否过期
	 * @return
	 */
	private boolean isOverdue() {
		long now = System.currentTimeMillis()/1000;
		return now < Long.parseLong(date) + Long.parseLong(expires_in);
	}
	
	/**
	 * 从URL中获取token
	 */
	private void gainAccess_token() {
		url = url.replace("APPID", appid).replace("APPSECRET", secret);
		//System.out.println(url);
		try {
			URL urlobj = new URL(url);
			URLConnection connection = urlobj.openConnection();
			InputStream is = connection.getInputStream();
			byte[] b = new byte[1024];
			int len ;
			StringBuilder sb = new StringBuilder();
			while(-1 != (len = is.read(b))) {
				sb.append(new String(b, 0, len));
			}
			is.close();
			//System.out.println(sb);
			JSONObject json = new JSONObject(sb.toString());
			//System.out.println(json.getStr("access_token"));
			this.date = System.currentTimeMillis() / 1000 + "";
			this.access_token = json.getStr("access_token");
			this.expires_in = json.getStr("expires_in");
			save(this);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void save(Get_access_token get_access_token) {
		String xml = EntitytoXML.transform(get_access_token);
		//System.out.println(xml);
		byte[] b = xml.getBytes();
		if(file.exists())
			file.delete();
		try(FileOutputStream fos = new FileOutputStream(file)){
			fos.write(b);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
}
