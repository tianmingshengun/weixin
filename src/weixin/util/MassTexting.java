package weixin.util;

import java.io.File;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 群发接口
 * @author admin
 *
 */
public class MassTexting {
      /**
       * 上传图文消息中的图片
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
	   * 上传图文消息素材
	   * @return
	   */
	  public static String uploadNews(){
		  /*格式
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
		  json.put("title","打飞机");
		  json.put("content_source_url","www.baidu.com");
		  json.put("content","哈哈哈哈哈哈哈浓缩ldlldldlk可你呢切克闹啊北欧北斗七星乾坤丹挪移哈哈哈哈哈哈哈哈哈哈哈东北怎么走西南怎么去啊哈哈哈哈 ");
          array.add(json);
          String body=canshu.toJSONString();
          String access_token=AccessTokenUtil.getAccessToken();
          String url="https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=Access_token";
          HttpClientUtil.post(url, access_token, body);
         return "";
	  }
	  
	  /**
	   * 群发消息
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
