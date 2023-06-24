package util;

import java.security.MessageDigest;


import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.digester.SystemPropertySource;

public class MaHoa {
	// md5
	// sha-1 => thường được sử dụng

	public static String toSHA1(String str) {
		String salt = "abjqfjfntdtnfjtndh;sdjgbjer";
		String result = null;
		str += salt;
		try {
			byte[] dataByte = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			result = Base64.encodeBase64String(md.digest(dataByte));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(toSHA1("123"));
	}
}
