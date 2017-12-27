package weixin.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * ����У����������õ�url�Ƿ���ȷ
 * 
 * @author a
 *
 */
public class CheckWeiXinUrl {
	/**
	 * У�������url
	 * ����signature
	 * @return
	 */
	public String checkUrl(String token, String timestamp, String nonce) {
		String[] array = { token, timestamp, nonce };
		String strSort = sort(array);

		return jiami(strSort);
	}

	/**
	 * �ֵ�����
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
	 * sha1����
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
