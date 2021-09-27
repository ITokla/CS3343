package model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
	
	public static String md5(String pwd) {
		String hashtext = "";
		try {
			byte[] digest = MessageDigest.getInstance("md5").digest(pwd.getBytes());
			BigInteger no = new BigInteger(1, digest);
			hashtext = no.toString(16);
			while(hashtext.length() < 32)
				hashtext = "0" + hashtext;
			
		}catch(NoSuchAlgorithmException e) {
			System.out.println("Hash algorithm not found");
			System.exit(0);
		}
		return hashtext;
	}
}
