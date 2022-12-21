package practice;

import org.testng.annotations.Test;

public class Parametarization {
	@Test
	public void paramerizationTest() {
		String url = System.getProperty("url");
		String username = System.getProperty("username");
		String password = System.getProperty("password");
		String browser = System.getProperty("browser");
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		System.out.println(browser);
		
		
	}

}
