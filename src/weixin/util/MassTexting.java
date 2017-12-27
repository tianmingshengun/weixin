package weixin.util;

import java.io.File;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Ⱥ���ӿ�
 * @author admin
 *
 */
public class MassTexting {
      /**
       * �ϴ�ͼ����Ϣ�е�ͼƬ
       * @return
       */
	  public static String uploadImage(File file){
		 
		  //url
		  String url="https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=Access_token";
		  String access_token=AccessTokenUtil.getAccessToken();
		  HttpClientUtil.post(url, access_token,file);
		  return "";
	  }
	  /**
	   * �ϴ�ͼ����Ϣ�ز�
	   * @return
	   */
	  public static String uploadNews(){
		  /*��ʽ
		   * {
			   "articles": [
					 {
			             "thumb_media_id":"qI6_Ze_6PtV7svjolgs-rN6stStuHIjs9_DidOHaj0Q-mwvBelOXCFZiq2OsIU-p",
			             "author":"xxx",
						 "title":"Happy Day",
						 "content_source_url":"www.qq.com",
						 "content":"content",
						 "digest":"digest",
			                        "show_cover_pic":1
					 }
			   ]
			}*/
		  JSONObject canshu=new JSONObject();
		  JSONArray array=new JSONArray();
		  canshu.put("articles",array);
		  JSONObject json=new JSONObject();
		  json.put("thumb_media_id","3EjfPepgzqnh3KF5UzRCNWEUitCbq6ZgejvyjxKN7R8sCG4x5wcEB8EoKH-ripWi");
		  json.put("author","qiekenao");
		  json.put("title","��ɻ�");
		  json.put("content_source_url","www.baidu.com");
		  json.put("content","��������������Ũ��ldlldldlk�������п��ְ���ŷ��������Ǭ����Ų�ƹ���������������������������ô��������ôȥ���������� ");
          array.add(json);
          String body=canshu.toJSONString();
          String access_token=AccessTokenUtil.getAccessToken();
          String url="https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=Access_token";
          HttpClientUtil.post(url, access_token, body);
         return "";
	  }
	  
	  /**
	   * Ⱥ����Ϣ
	   * @return
	   */
	  public static String sendMassTexting(){
		 
		  /* {
			   "filter":{
			      "is_to_all":false,
			      "tag_id":2
			   },
			   "text":{
      "content":"CONTENT"
   },
			    "msgtype":"text",
			   
			}*/
		  JSONObject canshu=new JSONObject();
		  JSONObject json1=new JSONObject();
		  json1.put("is_to_all",true);
		  canshu.put("filter",json1);
		  JSONObject json2=new JSONObject();
		  json2.put("media_id","U0sTX_j17WVqBbpQqftvHMZ3hsQygjaM6SgQyViH7pMS-0C6U9zvL_0yrzJzkk6T");
		  canshu.put("mpnews",json2);
		  canshu.put("msgtype","mpnews");
		  canshu.put("send_ignore_reprint",0);
		  
		  String body=canshu.toJSONString();
		  String access_token=AccessTokenUtil.getAccessToken();
		  String url="https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=Access_token";
		  HttpClientUtil.post(url, access_token, body);
		  return "";
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  public static void main(String[] args) {
		sendMassTexting();
	}
}
