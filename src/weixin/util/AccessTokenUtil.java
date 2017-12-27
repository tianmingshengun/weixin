package weixin.util;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;





/**
 * ���ڻ�ȡaccesstoken
 * @author admin
 *
 */
public class AccessTokenUtil {
      
	  private static String access_token; 
	  private static long getAccessTokenTime;//��ȡaccesstoken��ʱ��
	 
	  /**
	   * ��ȡaccesstoken
	   * @return
	   */
	  public static String getAccessToken(){
		  //accesstoken����Ƶ�������ƣ�����Ч��Ϊ7200S,����Ҫ�����߼�,����������Դ
		  if(access_token ==null || (getAccessTokenTime+7200*1000)<System.currentTimeMillis()){
			 String str=sendRequest();
		     JSONObject json=new JSONObject(str);
			 access_token=(String)json.get("access_token");
			 //������ȡaccesstoken��ʱ��
			 getAccessTokenTime=System.currentTimeMillis();
		  }
		  return access_token;
	  }
	  /**
	   * ��������������ʽΪ��{"access_token":"ACCESS_TOKEN","expires_in":7200}
	   * @return
	   */
	  public static String sendRequest(){
		  //��ȡaccess_token��url,��ȡ����ķ�ʽ��get
		  String url="https://api.weixin.qq.com/cgi-bin/token";
		  //�����������
		  Map<String, String> map =new HashMap<String,String>();
		  map.put("grant_type", "client_credential");
		  map.put("appid", "");
		  map.put("secret","");
		  //��������
		  String result =HttpClientUtil.get(url, map);
		  return result;
	  }
	  public static void main(String[] args) {
		  AccessTokenUtil util =new AccessTokenUtil();
		  System.out.println(util.getAccessToken());
	}
	   
}
