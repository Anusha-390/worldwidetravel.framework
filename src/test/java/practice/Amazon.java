package practice;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	
	@Test
	public void mobilePrice()
	{
		WebDriverManager.chromedriver().setup();
		//Samsung Galaxy M32 Prime Edition (Black, 6GB RAM, 128GB)
		//*[@id="search"]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div/div/div/div/div/div/div[2]/div/div/div[3]/div[1]/div/div[1]/div[1]/a/span[1]/span[2]/span[2]
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/s?k=mobile+under+15000&crid=17V311JEN0TFR&sprefix=mobile+under+15000%2Caps%2C373&ref=nb_sb_noss_1");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//List<String> productList=new ArrayList<String>();
	String	price=driver.findElement(By.xpath("//span[.='Samsung Galaxy M32 Prime Edition (Black, 6GB RAM, 128GB)']/../../../..div[3]/div[1]/div/div[1]/div[1]/a/span[1]/span[2]/span[2]")).getText();
	Reporter.log(price);
}
	
}
