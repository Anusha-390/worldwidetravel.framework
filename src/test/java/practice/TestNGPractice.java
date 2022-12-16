package practice;

import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	
	@Test
	public void test1()
	{
		Reporter.log("11111",false);
	}
  @BeforeSuite
  public void test2() {
	  Reporter.log("2222,true");
  }
  
  
}
