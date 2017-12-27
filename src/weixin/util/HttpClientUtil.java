package weixin.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


/**
 * ���ڷ���http����
 * 
 * @author admin
 *
 */
public class HttpClientUtil {
	// ����Ĭ�ϵ�http�ͻ���
	private static CloseableHttpClient httpclient = HttpClients.createDefault();

	/**
	 * ����post����
	 * 
	 * @param url
	 * @return
	 */
	public static String post(String url, Map map) {
		// ��������ʽ
		HttpPost post = new HttpPost(url);
		// ��Ӧ��
		CloseableHttpResponse postResponse = null;
		// ���ò���
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		// ��ȡmap�ļ�ֵ����
		Set set = map.keySet();
		for (Object key : set) {
			params.add(new BasicNameValuePair(key.toString(), map.get(key).toString()));
		}
		try {
			
			post.setEntity(new UrlEncodedFormEntity(params,Consts.UTF_8));
			postResponse = httpclient.execute(post);
			if (postResponse != null) {
				HttpEntity entity = postResponse.getEntity();			
				System.out.println("��������֮�󷵻ص�״̬" + postResponse.getStatusLine());			
				String result = EntityUtils.toString(entity, "UTF-8");
				System.out.println("��������󷵻ص�����"+result);
				EntityUtils.consume(entity);
				postResponse.close();
				return result;
			}

		} catch (Exception e) {
			System.out.println("���������ˡ�������������������������������");
			e.printStackTrace();
		}

		return "error";
	}
	/**
	 * ����get����
	 * @return
	 */
	public static String  get(String url,Map map){		
		
		if(map!=null){
			//�������������������url
			Set set=map.keySet();
			url+="?";
			for (Object key : set) {
		    	url+=key+"="+map.get(key).toString()+"&";
			}
		}
		
		//��������ʽ
		HttpGet get=new HttpGet(url);
		
		// ��Ӧ��
	     CloseableHttpResponse getResponse = null;
		try {
			getResponse=httpclient.execute(get);
			if(getResponse !=null){
			HttpEntity entity=getResponse.getEntity();
			
			System.out.println("��������֮�����Ӧ״̬"+getResponse.getStatusLine());
			String result =EntityUtils.toString(entity, "UTF-8");
			System.out.println("���ص�����"+result);			
			EntityUtils.consume(entity);
			getResponse.close();
			return result;
			}
		} catch (Exception e) {
			System.out.println("���������ˡ�������������������������������");
			e.printStackTrace();
		}
		
		return "error";
	}
	/**
	 * �����޲������Ƶ�post����
	 * 
	 * @param url
	 * @return
	 */
	public static String post(String url,String access_token ,String body) {
		//�齨�µ�url
		String newUrl=url.replaceAll("Access_token", access_token);
		// ��������ʽ
		HttpPost post = new HttpPost(newUrl);
		
		// ��Ӧ��
		CloseableHttpResponse postResponse = null;
		try {  
			
			StringEntity bodyEntity = new StringEntity(body,"UTF-8");
			post.setEntity(bodyEntity);
			
			postResponse = httpclient.execute(post);
			if (postResponse != null) {
				HttpEntity entity = postResponse.getEntity();			
				System.out.println("��������֮�󷵻ص�״̬" + postResponse.getStatusLine());			
				String result = EntityUtils.toString(entity, "UTF-8");
				System.out.println("��������󷵻ص�����"+result);
				EntityUtils.consume(entity);
				postResponse.close();
				return result;
			}

		} catch (Exception e) {
			System.out.println("���������ˡ�������������������������������");
			e.printStackTrace();
		}

		return "error";
	}
	/**
	 * ����post�����ϴ��ļ���ģ��curl
	 * 
	 * @param url
	 * @return
	 */
	public static String post(String url,String access_token,File file) {
		//�齨�µ�url
		String newUrl=url.replaceAll("Access_token", access_token);
		
		if(!file.exists()){
		   return "�ļ�������";	
		}
		// ��������ʽ
		HttpPost post = new HttpPost(newUrl);
		
		// ��Ӧ��
		CloseableHttpResponse postResponse = null;
		try {  
			//��ʼ��װ�ļ�
			FileBody bodyEntity=new FileBody(file);
			HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .addPart("bodyEntity", bodyEntity)
                    .build();
			post.setEntity(reqEntity);
			
			postResponse = httpclient.execute(post);
			if (postResponse != null) {
				HttpEntity entity = postResponse.getEntity();			
				System.out.println("��������֮�󷵻ص�״̬" + postResponse.getStatusLine());			
				String result = EntityUtils.toString(entity, "UTF-8");
				System.out.println("��������󷵻ص�����"+result);
				EntityUtils.consume(entity);
				postResponse.close();
				return result;
			}

		} catch (Exception e) {
			System.out.println("���������ˡ�������������������������������");
			e.printStackTrace();
		}

		return "error";
	}
	
}
