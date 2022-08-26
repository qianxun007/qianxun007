package Base;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/**
 * @author:beiai
 * @Description:
 * @date：2021-06-17
 */
public class Md5Util {
	public static String charSet = "utf-8";

	/**
	 * Used building output as Hex
	 */
	private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	public static String encrypt(String text, String charSet) {
		MessageDigest msgDigest = null;
		try {
			msgDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("System doesn't support MD5 algorithm.");
		}
		if (charSet != null) {
			try {
				msgDigest.update(text.getBytes(charSet));
			} catch (UnsupportedEncodingException e) {
				throw new IllegalStateException("System doesn't support your  EncodingException.");
			}
		}

		byte[] bytes = msgDigest.digest();
		return new String(encodeHex(bytes));
	}
	public static char[] encodeHex(byte[] data) {
		int l = data.length;
		char[] out = new char[l << 1];
		for (int i = 0, j = 0; i < l; i++) {
			out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS[0x0F & data[i]];
		}
		return out;
	}
	public int sumNum(int nums[]){
		HashMap<Integer,Integer> map =new HashMap<>();
		int sum=0;
		for(int i:nums) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i] + 1));
			}

		}
		for (int j: map.keySet()){
				sum=sum+j;
			}
		return sum;
		}


	public static void main(String arg[]){
		int[] age = {12,12,18,18,13,12,16};



	}


}



