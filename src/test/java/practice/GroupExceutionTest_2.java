package practice;

import org.testng.annotations.Test;

import com.genericUtility.BaseClass;

public class GroupExceutionTest_2 extends BaseClass
{

	@Test(groups = "sanity")
	public void grpTest21()
	{
		System.out.println("grpTest21");
	}
	
	@Test(groups = {"System"})
	public void grpTest22()
	{
		System.out.println("grpTest22");
	}
	
	@Test(groups = "Integration")
	public void grpTest23()
	{
		System.out.println("grpTest23");
	}
	
	@Test(groups = "Regression")
	public void grpTest24()
	{
		System.out.println("grpTest24");
	}
}
