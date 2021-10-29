package util_test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.Hash;

public class Hash_test {
	@Test
	public void md5_test() {
		String pwd = "123456"; 
		String target = "e10adc3949ba59abbe56e057f20f883e";
		String hashedPassword = Hash.md5(pwd);
		assertEquals(target, hashedPassword);
	}
}
