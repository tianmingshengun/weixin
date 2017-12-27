package weixin.util;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;





/**
 * 用于获取accesstoken
 * @author admin
 *
 */
public class AccessTokenUtil {
      
	  private static String access_token; 
	  private static long getAccessTokenTime;//获取accesstoken的时间
	 
	  /**
	   * 获取accesstoken
	   * @return
	   */
	  public static String getAccessToken(){
		  //accesstoken调用频次有限制，且有效期为7200S,所以要加上逻辑,合理利用资源
		  if(access_token ==null || (getAccessTokenTime+7200*1000)<System.currentTimeMillis()){
			 String str=sendRequest();
		     JSONObject json=new JSONObject(str);
			 access_token=(String)json.get("access_token");
			 //建立获取accesstoken的时间
			 getAccessTokenTime=System.currentTimeMillis();
		  }
		  return access_token;
	  }
	  /**
	   * 返回请求结果，格式为：{"access_token":"ACCESS_TOKEN","expires_in":7200}
	   * @return
	   */
	  public static String sendRequest(){
		  //获取access_token的url,获取请求的方式是get
		  String url="https://api.weixin.qq.com/cgi-bin/token";
		  //构建所需参数
		  Map<String, String> map =new HashMap<String,String>();
		  map.put("grant_type", "client_credential");
		  map.put("appid", "");
		  map.put("secret","");
		  //发送请求
		  String result =HttpClientUtil.get(url, map);
		  return result;
	  }
	  public static void main(String[] args) {
		  AccessTokenUtil util =new AccessTokenUtil();
		  System.out.println(util.getAccessToken());
	}
	   
}
