package weixin.me;

import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import weixin.service.MyWebService;
import weixin.service.MyWebServiceImplService;

/**
 * �����ⲿservice����
 * 
 * @author admin
 *
 */
public class Test {
    
	// ����cxf�����ͻ��˵ļ�������	
    private static	MyWebServiceImplService bean = new MyWebServiceImplService();
		
	public static void main(String[] args) {
		MyWebService service = bean.getMeport();

		System.out.println(service.say());

	}
	public String say(String str){
		bean.getMeport().say();
		return "  ";
	}
	
}
