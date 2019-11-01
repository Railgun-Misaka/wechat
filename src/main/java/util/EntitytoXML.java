package util;

import com.thoughtworks.xstream.XStream;

public class EntitytoXML {
	public static String transform(Object obj) {
		XStream xstream = new XStream();
		//扫描实体类上的注解
		xstream.processAnnotations(obj.getClass());
		String xml = xstream.toXML(obj);
		System.out.println(xml);
		return xml;
	}
}
