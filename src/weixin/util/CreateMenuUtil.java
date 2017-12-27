package weixin.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * �����Զ���˵�
 * @author admin
 *
 */
public class CreateMenuUtil {
      
	/**
       * �����Զ���˵� 
       */
	  public static void createMenu(){
		  //�����˵�url
		  String url="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=Access_token";
		  /*StringBuffer sb=new StringBuffer();
		  sb.append("{\"button\":[{\"name\":\"����\",\"type\":\"click\",\"key\":\"daopao\"},{\"name\":\"�˵�\",\"sub_button\":[{\"name\":\"�ٶ�һ��\",\"type\":\"view\",\"url\":\"https://www,baidu.com/\"}]}]}");
		  */
		  //�˴�json��Ĺ�����Ż����ɲ����������ķ�ʽ������Ӧ��ʵ����
		 /* {
			    "button": [
			        {
			            "name": "����", 
			            "type": "click", 
			            "key": "dapao"
			        }, 
			        {
			            "name": "�˵�", 
			            "sub_button": [
			                {
			                    "name": "�ٶ�һ��", 
			                    "type": "view", 
			                    "url": "https://www.baidu.com"
			                }
			            ]
			        }
			    ]
			}*/
		  //��ʼ����json
		  JSONObject json1=new JSONObject();
		 
		  JSONArray jsonArray=new JSONArray();
		  json1.put("button",jsonArray);
		 
		  JSONObject json2=new JSONObject();
		  json2.put("type","click");
		  json2.put("name","");
		  json2.put("key","dapao");
		 
		 jsonArray.add(json2);
		 
	      JSONObject json3=new JSONObject();
	      JSONArray jsonArray3=new JSONArray();
	      json3.put("name","�˵�");
	      json3.put("sub_button",jsonArray3);
	      jsonArray.add(json3);
	      
	      JSONObject json4=new JSONObject();
	      json4.put("type","view");
	      json4.put("name","�ٶ�һ��");
	      json4.put("url","https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx520c15f417810387&redirect_uri=https%3A%2F%2Fchong.qq.com%2Fphp%2Findex.php%3Fd%3D%26c%3DwxAdapter%26m%3DmobileDeal%26showwxpaytitle%3D1%26vb2ctag%3D4_2030_5_1194_60&response_type=code&scope=snsapi_base&state=123#wechat_redirect");
	      
	      jsonArray3.add(json4);
	    
		  //��������
		  String access_token= AccessTokenUtil.getAccessToken();
		
		  String body=json1.toJSONString();
		  
		  HttpClientUtil.post(url, access_token,body);
		
	      System.out.println(json1.toJSONString());
	  }
	  /**
	   * ��ѯ�˵��ṹ
	   * @return
	   */
	  public static String getMenu(){
		  
		  //��ȡ�˵��ṹurl
		  String url = "https://api.weixin.qq.com/cgi-bin/menu/get";
		  
		  //��������
		  Map<String, String> map =new HashMap<String,String>();
		  map.put("access_token",AccessTokenUtil.getAccessToken());
		  	  
		  return HttpClientUtil.get(url, map);
	  }
	  /**
	   * ɾ���˵�
	   * @return
	   */
	  public static String delMenu(){
		  
		  //ɾ���˵�url
		  String url="https://api.weixin.qq.com/cgi-bin/menu/delete";
		  
		  //��������
		  Map<String, String> map =new HashMap<String,String>();
		  map.put("access_token",AccessTokenUtil.getAccessToken());
		  
		  return HttpClientUtil.get(url, map);
		  
		  
	  }
	  
	  /**
	   * �������Ի��Զ���˵�
	   */
	  public static void createIndividuationMenu(){
		  //�������Ի��Զ���˵�url
		  String url="https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=Access_token";
		  String accessToken=AccessTokenUtil.getAccessToken();
		 //�������Ի��˵�
		  JSONObject json1=new JSONObject();
			 
		  JSONArray jsonArray=new JSONArray();
		  json1.put("button",jsonArray);
		 
		  JSONObject json2=new JSONObject();
		  json2.put("type","click");
		  json2.put("name","");
		  json2.put("key","dapao");
		 
		 jsonArray.add(json2);
		 
	      JSONObject json3=new JSONObject();
	      JSONArray jsonArray3=new JSONArray();
	      json3.put("name","�˵�");
	      json3.put("sub_button",jsonArray3);
	      jsonArray.add(json3);
	      
	      JSONObject json4=new JSONObject();
	      json4.put("type","view");
	      json4.put("name","Googleһ��");
	      json4.put("url","https://www.baidu.com/");
	      
	      jsonArray3.add(json4);
	      
	      //���Ի��˵�У�����	      
	      JSONObject json5=new JSONObject();
	      json5.put("country","�й�");
	      json5.put("province","����");
	      json5.put("city","֣��");
	      json1.put("matchrule", json5);
	      
	      String body=json1.toJSONString();
	      
	      
	      
		  HttpClientUtil.post(url, accessToken, body);
	  }
	  
	  
	  /**
	   * ��ȡ�Զ���˵�����
	   * @return
	   */
	  public static String getMenuConfiguration(){
		  //��ȡ�Զ���˵�url
		  String url="https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info";
		  Map<String,String> map =new HashMap<String,String>();
		  map.put("access_token", AccessTokenUtil.getAccessToken());
		  HttpClientUtil.get(url, map);
		  return "";
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  public static void main(String[] args) {
	   createMenu();
	}
}
