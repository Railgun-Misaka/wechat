package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLtoMAP {
	public static Map<String, String> transform(InputStream is){
		
		SAXReader reader = new SAXReader();
		Map<String, String> map = new HashMap<String, String>();
		
		//System.out.println(is);
		Document document;
		try {
			document = reader.read(is);
			//获取根节点
			Element e = document.getRootElement();
			//获取元素
			List<Element> elements = e.elements();
			for(Element element : elements)
				map.put(element.getName(), element.getStringValue());
		} catch (DocumentException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}finally {
			if(is != null)
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		
		if(map.isEmpty())
			System.out.println("XML无内容");
		return map ;
	}
}
