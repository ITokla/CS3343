package util_test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import util.Generator;

public class Generator_test {
	
	@Test
	public void generatePwd_test() {
		Generator g = null;
		String pwd = g.generatePwd(7);
		assertEquals(7, pwd.length());
	}
}
