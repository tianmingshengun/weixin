package weixin.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 用于校验服务器配置的url是否正确
 * 
 * @author a
 *
 */
public class CheckWeiXinUrl {
	/**
	 * 校验服务器url
	 * 返回signature
	 * @return
	 */
	public String checkUrl(String token, String timestamp, String nonce) {
		String[] array = { token, timestamp, nonce };
		String strSort = sort(array);

		return jiami(strSort);
	}

	/**
	 * 字典排序
	 * 
	 * @return
	 */
	public String sort(String array[]) {
		Arrays.sort(array);
		StringBuilder sb = new StringBuilder();
		for (String str : array) {
			sb.append(str);
		}
		return sb.toString();
	}

	/**
	 * sha1加密
	 * 
	 * @param afterSort
	 * @return
	 */
	public String jiami(String afterSort) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.update(afterSort.getBytes());
			byte[] messageDigest = digest.digest();
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
