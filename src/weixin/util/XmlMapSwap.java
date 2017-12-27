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
 * xml��map����ת������
 * 
 * @author admin
 *
 */
public class XmlMapSwap {

	

	/**
	 * xmlתmap
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
			//�˴����Ż���Ӧ�ð�ѭ��������ȥ����װ��һ��������Ȼ��ݹ�
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
	 * xmlתmap
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
			//�˴����Ż���Ӧ�ð�ѭ��������ȥ����װ��һ��������Ȼ��ݹ�
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
	 * mapתxml
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
