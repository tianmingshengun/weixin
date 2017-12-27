package weixin.util;

import com.alibaba.fastjson.JSONObject;

/**
 * �ͷ���Ϣ�ӿڹ�����
 * @author admin
 *
 */
public class CustomerService {
    
	/**
	 * ����ǰӦ�ȿ�ͨ�ͷ�����
	 * �����ͷ��˺�
	 * @param kf_account �˺�
	 * @param nickname �ǳ�
	 * @param password ����
	 * @return
	 */
	public static String createKFAccount(String kf_account,String nickname,String password){
    	   
    	   //�����˺ŵ�ַ
    	   String url="https://api.weixin.qq.com/customservice/kfaccount/add?access_token=Access_token";
    	   //����������
    	   JSONObject canshu=new JSONObject();
    	   canshu.put("kf_account", kf_account);
    	   canshu.put("nickname", nickname);
    	   canshu.put("password", password);
    	   String body=canshu.toJSONString();
    	   //��ȡaccess_token
    	   String access_token=AccessTokenUtil.getAccessToken();
   	   
    	   return  HttpClientUtil.post(url, access_token, body);
    	   
       }
	
	/**
	 * ���Ϳͷ���Ϣ
	 * @param message
	 * @return
	 */
	public static String sendKFMessage(JSONObject message){
		//��Ϣ��
		String body=message.toJSONString();
		//url
		String url="https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=Access_token";
		//��ȡaccess_token
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
		json.put("content","����������Ѱɽ");
		message.put("text",json);
	   
		sendKFMessage(message);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
