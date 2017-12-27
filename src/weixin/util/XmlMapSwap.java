package weixin.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * xml与map互相转换工具
 * 
 * @author admin
 *
 */
public class XmlMapSwap {

	

	/**
	 * xml转map
	 * 
	 * @param xml
	 * @return
	 */
	@SuppressWarnings("finally")
	public static Map xmlToMap(InputStream inputStream) {
		Map<String, String> result = new HashMap<String, String>();
        try {
			SAXReader reader=new SAXReader();			
        	Document document=reader.read(inputStream);
			Element root=document.getRootElement();
			List<Element> elements=root.elements();
			//此处可优化，应该把循环独立出去，封装成一个方法，然后递归
			for (Element ele : elements) {
				if(ele.elements().isEmpty()==true){
					result.put(ele.getName(),ele.getStringValue());
				}else{
					List<Element> childElements=ele.elements();
					for (Element child : childElements) {
						result.put(child.getName(),child.getStringValue());
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.put("msg","ERROR");
			
		}finally{
			return result;
		}
		
	}
	/**
	 * xml转map
	 * 
	 * @param xml
	 * @return
	 */
	@SuppressWarnings("finally")
	public static Map xmlToMap(String xml) {
		Map<String, String> result = new HashMap<String, String>();
        try {					
        	Document document=DocumentHelper.parseText(xml);
			Element root=document.getRootElement();
			List<Element> elements=root.elements();
			//此处可优化，应该把循环独立出去，封装成一个方法，然后递归
			for (Element ele : elements) {
				if(ele.elements().isEmpty()==true){
					result.put(ele.getName(),ele.getStringValue());
				}else{
					List<Element> childElements=ele.elements();
					for (Element child : childElements) {
						result.put(child.getName(),child.getStringValue());
					}
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.put("msg","ERROR");
			
		}finally{
			return result;
		}
		
	}
	/**
	 * map转xml
	 * @param map
	 * @return
	 */
	public static String mapToXml(Map map){
	  String xml= String.format("<xml>" 
				   + "<ToUserName><![CDATA[%s]]></ToUserName>"
				   + "<FromUserName><![CDATA[%s]]></FromUserName>" 
				   + "<CreateTime>%s</CreateTime>"
				   + "<MsgType><![CDATA[%s]]></MsgType>" 
				   +"<Image>"
				   + "<MediaId><![CDATA[%s]]></MediaId>"
				   +"</Image>"
				   + "</xml>",map.get("FromUserName").toString(),
				              map.get("ToUserName").toString(),
				              map.get("CreateTime").toString(),
				              map.get("MsgType").toString(),
				              map.get("MediaId").toString());
		
		return xml;
	}
	public static void main(String[] args) {
		String xml = "<xml>" 
				   + "<ToUserName><![CDATA[toUser]]></ToUserName>"
				   + "<FromUserName><![CDATA[fromUser]]></FromUserName>" 
				   + "<CreateTime>1348831860</CreateTime>"
				   + "<MsgType><![CDATA[text]]></MsgType>" 
				   + "<Content><![CDATA[this is a test]]></Content>"
				   + "<MsgId>1234567890123456</MsgId>" 
				   + "</xml>";
		System.out.println(xmlToMap(xml).toString());
	}
}
