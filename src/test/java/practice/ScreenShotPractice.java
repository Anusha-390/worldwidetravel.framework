package practice;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericUtility.BaseClass;
@Listeners(com.tourism.ListnerImplementation.class)
public class ScreenShotPractice extends BaseClass {
	@Test
	public void test1(){
		System.out.println("execution starts");
		Assert.assertEquals("anusha","chandan");
		System.out.println("Executin ends");
		
	}

}
