package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelExecutionTest_3 {

	@Test(groups = "sanity")
	public void plltest31()
	{
		System.out.println(Thread.currentThread().getId());
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.google.com");
		driver.quit();
	}
	
	@Test(groups = "Integration")
	public void plltest32()
	{
		System.out.println(Thread.currentThread().getId());
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.google.com");
		driver.quit();
	}
	
	@Test(groups = "Regrassion")
	public void plltest33()
	{
		System.out.println(Thread.currentThread().getId());
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.google.com");
		driver.quit();
	}
}
