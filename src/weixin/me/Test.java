package weixin.me;

import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import weixin.service.MyWebService;
import weixin.service.MyWebServiceImplService;

/**
 * 调用外部service服务
 * 
 * @author admin
 *
 */
public class Test {
    
	// 关于cxf建立客户端的几个问题	
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
