package practice;

import org.testng.annotations.Test;

import com.genericUtility.BaseClass;

public class GroupExceutionTest_3 extends BaseClass{

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
	
	@Test(groups = "Regrassion",alwaysRun = true)
	public void grpTest34()
	{
		System.out.println("grpTest34");
	}
}
