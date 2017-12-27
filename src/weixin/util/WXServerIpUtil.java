package weixin.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;


/**
 * ��ȡ΢�ŷ�����ip�б�
 * 
 * @author admin
 *
 */
public class WXServerIpUtil {

	/**
	 * ��ȡIp�б��ַ
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