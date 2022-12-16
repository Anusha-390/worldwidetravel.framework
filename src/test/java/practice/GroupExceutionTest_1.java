package practice;

import org.testng.annotations.Test;

import com.genericUtility.BaseClass;

public class GroupExceutionTest_1 extends BaseClass {

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
	
	@Test(groups = "Regrassion")
	public void grpTest14()
	{
		System.out.println("grpTest14");
	}
}
