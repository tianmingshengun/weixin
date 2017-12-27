package weixin.util;

import com.alibaba.fastjson.JSONObject;

/**
 * 客服消息接口工具类
 * @author admin
 *
 */
public class CustomerService {
    
	/**
	 * 调用前应先开通客服功能
	 * 创建客服账号
	 * @param kf_account 账号
	 * @param nickname 昵称
	 * @param password 密码
	 * @return
	 */
	public static String createKFAccount(String kf_account,String nickname,String password){
    	   
    	   //创建账号地址
    	   String url="https://api.weixin.qq.com/customservice/kfaccount/add?access_token=Access_token";
    	   //创建参数体
    	   JSONObject canshu=new JSONObject();
    	   canshu.put("kf_account", kf_account);
    	   canshu.put("nickname", nickname);
    	   canshu.put("password", password);
    	   String body=canshu.toJSONString();
    	   //获取access_token
    	   String access_token=AccessTokenUtil.getAccessToken();
   	   
    	   return  HttpClientUtil.post(url, access_token, body);
    	   
       }
	
	/**
	 * 发送客服消息
	 * @param message
	 * @return
	 */
	public static String sendKFMessage(JSONObject message){
		//消息体
		String body=message.toJSONString();
		//url
		String url="https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=Access_token";
		//获取access_token
		String access_token=AccessTokenUtil.getAccessToken();
		
		return HttpClientUtil.post(url, access_token, body);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		/*{
		    "touser":"OPENID",
		    "msgtype":"text",
		    "text":
		    {
		         "content":"Hello World"
		    }
		}*/
		JSONObject message=new JSONObject();
		message.put("touser", "oyLPrv6Q7ahbkPgLWxHQdqM5T9R8");
		message.put("msgtype","text");
		JSONObject json=new JSONObject();
		json.put("content","大王叫我来寻山");
		message.put("text",json);
	   
		sendKFMessage(message);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
