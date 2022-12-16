package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetMobileRating {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/s?k=mobiles&crid=2UUPJH844H3JQ&sprefix=mobiles%2Caps%2C399&ref=nb_sb_noss_1");
		List<WebElement> productLists = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		
		String ExpectedResult = "Samsung Galaxy M53 5G (Mystique Green, 8GB, 128GB Storage) | 108MP | sAmoled+ 120Hz | 16GB RAM with RAM Plus | Travel Adapter to be Purchased Separately";
		
		for(WebElement pList:productLists)
		{
			String actualName = pList.getText();
			//System.out.println(actualName);
			if(actualName.equals(ExpectedResult))
			{
				 WebElement ratings = driver.findElement(By.xpath("//span[.='"+actualName+"']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/div[2]/div/span[1]/span[2]"));			
				 System.out.println(actualName+" ----> Rating ---> "+ratings.getText());
			}
		}
		
		driver.quit();
	}

}


/*//WebElement ele = driver.findElement(By.xpath("//span[.='Samsung Galaxy M13 5G (Midnight Blue, 6GB, 128GB Storage) | 5000mAh Battery | Upto 12GB RAM with RAM Plus']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/div[2]/div/span[1]/span[2]"));
		//Actions a=new Actions(driver);
		//a.moveToElement(ele).perform();
		
		 //  driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-beside-button a-text-bold']")).click();
		
		*/
