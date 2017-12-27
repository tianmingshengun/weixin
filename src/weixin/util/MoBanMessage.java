package weixin.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * ģ����Ϣ
 * 
 * @author admin
 *
 */
public class MoBanMessage {
	/**
	 * ����������ҵ
	 * 
	 * @param industry
	 * @return
	 */
	public static String setIndustry(JSONObject industry) {

		// ����
		String body = industry.toJSONString();
		String access_token = AccessTokenUtil.getAccessToken();
		String url = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=Access_token";
		HttpClientUtil.post(url, access_token, body);
		return "";
	}

	/**
	 * ��ȡ���õ���ҵ��Ϣ
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
	 * ��ȡģ���б�
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
	 * ����ģ����Ϣ
	 * 
	 * @return
	 */
	public static String sendTemplateMessage() {
		/*
		 * { "touser":"OPENID",
		 * "template_id":"ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY", "data":{
		 * "first": { "value":"��ϲ�㹺��ɹ���", "color":"#173177" }, "keynote1":{
		 * "value":"�ɿ���", "color":"#173177" }, "keynote2": { "value":"39.8Ԫ",
		 * "color":"#173177" }, "keynote3": { "value":"2014��9��22��",
		 * "color":"#173177" }, "remark":{ "value":"��ӭ�ٴι���", "color":"#173177"
		 * } } }
		 */
		JSONObject json1 = new JSONObject();
		json1.put("touser", "oyLPrv6Q7ahbkPgLWxHQdqM5T9R8");
		json1.put("template_id", "Doclyl5uP7Aciu-qZ7mJNPtWkbkYnWBWVja26EGbNyk");
		/*JSONObject data = new JSONObject();
		json1.put("data", data);
		JSONObject first = new JSONObject();
		first.put("value", "����һ�����Ա���");
		data.put("first", first);

		JSONObject keynote1 = new JSONObject();
		keynote1.put("value", "�ؼ���1");
		data.put("keynote1", keynote1);

		JSONObject keynote2 = new JSONObject();
		keynote2.put("value", "�ؼ���2");
		data.put("keynote2", keynote2);

		JSONObject keynote3 = new JSONObject();
		keynote3.put("value", "�ؼ���3");
		data.put("keynote3", keynote3);

		JSONObject remark = new JSONObject();
		keynote3.put("value", "this is remark");
		data.put("remark", remark);*/

		// ����
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
