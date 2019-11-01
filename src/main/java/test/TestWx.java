package test;

import org.junit.Test;

import cn.hutool.json.JSONObject;
import entity.*;
import entity.massage.NewsMassage;
import entity.token.Get_access_token;
import util.EntitytoXML;

public class TestWx {
	@Test
	public void test() {
		NewsMassage tm = new NewsMassage();
		System.out.println(EntitytoXML.transform(tm));
	}
	
	@Test
	public void test1() {
		System.out.println(this.getClass().getResource("/"));
		System.out.println(this.getClass().getResource(""));
		System.out.println(System.getProperty("user.dir"));
		System.out.println(ClassLoader.getSystemResource(""));
		Get_access_token gat = new Get_access_token();
		gat.getAccess_token();
	}
	
	@Test
	public void test2() {
//		String str = "{'access_token':'26_uTHkCfk6uXSrl2iKQc_cHOjqqrOKNDUv1ndjzV5oGny9ofjhiNE401a7EDIsngezueIZ9AK-GnaD96bjB0CDU0VK64EadUCPVvsV_15yUwQS0KH4FPxMBevnTR559k47l1OQ_hJIwyqAokWQETVfAEARGI','expires_in':7200}";
//		JSONObject json = new JSONObject(str);
//		System.out.println(json.getStr("access_token"));
	}
}
