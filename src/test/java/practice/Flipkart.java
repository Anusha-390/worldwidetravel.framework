package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.flipkart.com/");
	driver.findElement(By.xpath("//button[text()='✕']")).click();
	driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iphone");
	driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
	List<WebElement> product_list=driver.findElements(By.xpath("//div[@class='_4rR01T']"));
	for(WebElement product:product_list) 
	{
		String name=product.getText();
		System.out.println("PRODUCT NAME"+name);
		String value = driver.findElement(By.xpath("//div[.='"+name+"']/../../div[2]/div[1]/div[1]/div[1]")).getText();
		System.out.println(name+"------------->"+value);
		System.out.println("  ");
	}
	driver.quit();
}
}
