package weixin.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;


/**
 * 获取微信服务器ip列表
 * 
 * @author admin
 *
 */
public class WXServerIpUtil {

	/**
	 * 获取Ip列表地址
	 */
	public static JSONObject getIpList() {
		JSONObject result = new JSONObject();
		String url = "https://api.weixin.qq.com/cgi-bin/getcallbackip";
		Map<String, String> map = new HashMap<String, String>();
		map.put("access_token", AccessTokenUtil.getAccessToken());		
		result=result.parseObject(HttpClientUtil.get(url, map));
		return result;
	}
	public static void main(String[] args) {
		  System.out.println(getIpList().toString());
	}
}