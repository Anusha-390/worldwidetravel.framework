package practice;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileRatings {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	
		driver.get("https://www.amazon.in/s?k=mobiles&crid=2UUPJH844H3JQ&sprefix=mobiles%2Caps%2C399&ref=nb_sb_noss_1");
		driver.manage().window().maximize();
		
		
	 WebElement ele = driver.findElement(By.xpath("//span[.='RESULTS']/ancestor::div[5]/div[3]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"));
	//WebElement ele = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-beside-button a-text-bold']"));

	Actions a=new Actions(driver);
	a.moveToElement(ele).perform();
	 WebElement actualResult = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-beside-button a-text-bold']"));

	
	String ExpectedResult = "Samsung Galaxy M13 (Aqua Green, 4GB, 64GB Storage) | 6000mAh Battery | Upto 8GB RAM with RAM Plus";
	
		if(ExpectedResult.equals(actualResult)) {
			String star = actualResult.getText();
			System.out.println(star);
		}
		
	}}


