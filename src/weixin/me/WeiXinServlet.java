package weixin.me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weixin.util.CheckWeiXinUrl;
import weixin.util.XmlMapSwap;

/**
 * 用于接入公众号
 * 
 * @author admin
 *
 */
@WebServlet(urlPatterns = "/WeiXinServlet")
public class WeiXinServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// 用作生成签名
	private final String token = "me";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接受微信服务器参数
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		// 开始校验
		System.out.println("开始校验。。。。。。。。。。。。。");
		CheckWeiXinUrl check = new CheckWeiXinUrl();
		String localSignature = check.checkUrl(token, timestamp, nonce);

		if (localSignature != "" && localSignature != null && localSignature.equals(signature)) {
			System.out.println("校验成功。。。。。。。。。。。。。。");
			resp.getWriter().write(echostr);
		} else {
			System.out.println("校验失败。。。。。。。。。。。。。。。。");
		}

	}

	// 消息和事件入口
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
	    Map map = XmlMapSwap.xmlToMap(req.getInputStream());
		//String responseMessage=XmlMapSwap.mapToXml(map);
		int time = Integer.parseInt((String) map.get("CreateTime"));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(time);
		Date date = calendar.getTime();

		System.out.println(format.format(date));
		System.out.println(map.toString());
       /* if(map.containsKey("msg")){
        resp.getWriter().println("");
        }else{
        	resp.getWriter().println(responseMessage);
        }*/
	}
}
