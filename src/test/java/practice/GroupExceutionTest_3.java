package practice;

import org.testng.annotations.Test;


public class GroupExceutionTest_3 {

	@Test(groups = "sanity")
	public void grpTest31()
	{
		System.out.println("grpTest31");
	}
	
	@Test(groups = "System")
	public void grpTest32()
	{
		System.out.println("grpTest32");
	}
	
	@Test(groups = {"Integration"})
	public void grpTest33()
	{
		System.out.println("grpTest33");
	}
	
	@Test(groups = "Regression",alwaysRun = true)
	public void grpTest34()
	{
		System.out.println("grpTest34");
	}
}
