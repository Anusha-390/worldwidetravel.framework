package practice;

import org.testng.annotations.Test;


public class GroupExceutionTest_1 {

	@Test(groups = {"sanity"})
	public void grpTest11()
	{
		System.out.println("grpTest11");
	}
	
	@Test(groups = "System")
	public void grpTest12()
	{
		System.out.println("grpTest12");
	}
	
	@Test(groups = "Integration")
	public void grpTest13()
	{
		System.out.println("grpTest13");
	}
	
	@Test(groups = "Regression")
	public void grpTest14()
	{
		System.out.println("grpTest14");
	}
}
