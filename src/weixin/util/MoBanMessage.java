package weixin.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * 模板消息
 * 
 * @author admin
 *
 */
public class MoBanMessage {
	/**
	 * 设置所属行业
	 * 
	 * @param industry
	 * @return
	 */
	public static String setIndustry(JSONObject industry) {

		// 参数
		String body = industry.toJSONString();
		String access_token = AccessTokenUtil.getAccessToken();
		String url = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=Access_token";
		HttpClientUtil.post(url, access_token, body);
		return "";
	}

	/**
	 * 获取设置的行业信息
	 * 
	 * @return
	 */
	public static String getIndustryMessage() {

		String url = "https://api.weixin.qq.com/cgi-bin/template/get_industry";
		Map<String, String> map = new HashMap<String, String>();
		map.put("access_token", AccessTokenUtil.getAccessToken());
		HttpClientUtil.get(url, map);

		return "";
	}

	/**
	 * 获取模板列表
	 * 
	 * @return
	 */
	public static String getTemplateList() {

		String url = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template";
		Map<String, String> map = new HashMap<String, String>();
		map.put("access_token", AccessTokenUtil.getAccessToken());
		HttpClientUtil.get(url, map);

		return "";
	}

	/**
	 * 发送模板消息
	 * 
	 * @return
	 */
	public static String sendTemplateMessage() {
		/*
		 * { "touser":"OPENID",
		 * "template_id":"ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY", "data":{
		 * "first": { "value":"恭喜你购买成功！", "color":"#173177" }, "keynote1":{
		 * "value":"巧克力", "color":"#173177" }, "keynote2": { "value":"39.8元",
		 * "color":"#173177" }, "keynote3": { "value":"2014年9月22日",
		 * "color":"#173177" }, "remark":{ "value":"欢迎再次购买！", "color":"#173177"
		 * } } }
		 */
		JSONObject json1 = new JSONObject();
		json1.put("touser", "oyLPrv6Q7ahbkPgLWxHQdqM5T9R8");
		json1.put("template_id", "Doclyl5uP7Aciu-qZ7mJNPtWkbkYnWBWVja26EGbNyk");
		/*JSONObject data = new JSONObject();
		json1.put("data", data);
		JSONObject first = new JSONObject();
		first.put("value", "这是一个测试标题");
		data.put("first", first);

		JSONObject keynote1 = new JSONObject();
		keynote1.put("value", "关键词1");
		data.put("keynote1", keynote1);

		JSONObject keynote2 = new JSONObject();
		keynote2.put("value", "关键词2");
		data.put("keynote2", keynote2);

		JSONObject keynote3 = new JSONObject();
		keynote3.put("value", "关键词3");
		data.put("keynote3", keynote3);

		JSONObject remark = new JSONObject();
		keynote3.put("value", "this is remark");
		data.put("remark", remark);*/

		// 参数
		String body = json1.toJSONString();
		String access_token = AccessTokenUtil.getAccessToken();
		String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=Access_token";
		HttpClientUtil.post(url, access_token, body);
		return "";
	}

	public static void main(String[] args) {
		sendTemplateMessage();
	}
}
