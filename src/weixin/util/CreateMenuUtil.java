package weixin.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 创建自定义菜单
 * @author admin
 *
 */
public class CreateMenuUtil {
      
	/**
       * 创建自定义菜单 
       */
	  public static void createMenu(){
		  //创建菜单url
		  String url="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=Access_token";
		  /*StringBuffer sb=new StringBuffer();
		  sb.append("{\"button\":[{\"name\":\"打炮\",\"type\":\"click\",\"key\":\"daopao\"},{\"name\":\"菜单\",\"sub_button\":[{\"name\":\"百度一下\",\"type\":\"view\",\"url\":\"https://www,baidu.com/\"}]}]}");
		  */
		  //此处json体的构造可优化，可采用面向对象的方式建立相应的实体类
		 /* {
			    "button": [
			        {
			            "name": "打炮", 
			            "type": "click", 
			            "key": "dapao"
			        }, 
			        {
			            "name": "菜单", 
			            "sub_button": [
			                {
			                    "name": "百度一下", 
			                    "type": "view", 
			                    "url": "https://www.baidu.com"
			                }
			            ]
			        }
			    ]
			}*/
		  //开始构造json
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
	      json3.put("name","菜单");
	      json3.put("sub_button",jsonArray3);
	      jsonArray.add(json3);
	      
	      JSONObject json4=new JSONObject();
	      json4.put("type","view");
	      json4.put("name","百度一下");
	      json4.put("url","https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx520c15f417810387&redirect_uri=https%3A%2F%2Fchong.qq.com%2Fphp%2Findex.php%3Fd%3D%26c%3DwxAdapter%26m%3DmobileDeal%26showwxpaytitle%3D1%26vb2ctag%3D4_2030_5_1194_60&response_type=code&scope=snsapi_base&state=123#wechat_redirect");
	      
	      jsonArray3.add(json4);
	    
		  //创建参数
		  String access_token= AccessTokenUtil.getAccessToken();
		
		  String body=json1.toJSONString();
		  
		  HttpClientUtil.post(url, access_token,body);
		
	      System.out.println(json1.toJSONString());
	  }
	  /**
	   * 查询菜单结构
	   * @return
	   */
	  public static String getMenu(){
		  
		  //获取菜单结构url
		  String url = "https://api.weixin.qq.com/cgi-bin/menu/get";
		  
		  //创建参数
		  Map<String, String> map =new HashMap<String,String>();
		  map.put("access_token",AccessTokenUtil.getAccessToken());
		  	  
		  return HttpClientUtil.get(url, map);
	  }
	  /**
	   * 删除菜单
	   * @return
	   */
	  public static String delMenu(){
		  
		  //删除菜单url
		  String url="https://api.weixin.qq.com/cgi-bin/menu/delete";
		  
		  //创建参数
		  Map<String, String> map =new HashMap<String,String>();
		  map.put("access_token",AccessTokenUtil.getAccessToken());
		  
		  return HttpClientUtil.get(url, map);
		  
		  
	  }
	  
	  /**
	   * 创建个性化自定义菜单
	   */
	  public static void createIndividuationMenu(){
		  //创建个性化自定义菜单url
		  String url="https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=Access_token";
		  String accessToken=AccessTokenUtil.getAccessToken();
		 //构建个性化菜单
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
	      json3.put("name","菜单");
	      json3.put("sub_button",jsonArray3);
	      jsonArray.add(json3);
	      
	      JSONObject json4=new JSONObject();
	      json4.put("type","view");
	      json4.put("name","Google一下");
	      json4.put("url","https://www.baidu.com/");
	      
	      jsonArray3.add(json4);
	      
	      //个性化菜单校验规则	      
	      JSONObject json5=new JSONObject();
	      json5.put("country","中国");
	      json5.put("province","河南");
	      json5.put("city","郑州");
	      json1.put("matchrule", json5);
	      
	      String body=json1.toJSONString();
	      
	      
	      
		  HttpClientUtil.post(url, accessToken, body);
	  }
	  
	  
	  /**
	   * 获取自定义菜单配置
	   * @return
	   */
	  public static String getMenuConfiguration(){
		  //获取自定义菜单url
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
