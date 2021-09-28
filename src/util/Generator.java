package util;

public class Generator {
	public static String generatePwd(int length) {
		String pwd = "";

		for (int i = 0; i < length; i++)
			pwd += (char) ((int) ((Math.random()) * 93) + 33);

		return pwd;
	}
}
