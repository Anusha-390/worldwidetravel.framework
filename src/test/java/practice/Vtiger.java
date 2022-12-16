package practice;

import java.time.Duration;
import java.util.List;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[.='Organizations']")).click();
		String expectedeOrgName="tcs100";
		List<WebElement> listOrg=driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]"));
		System.out.println(" gg ");
		for(int i=1;i<listOrg.size();i++) {
			String actualOrgName=listOrg.get(i).getText();
			System.out.println(" gg ");
			if (actualOrgName.equals(expectedeOrgName)) {
				System.out.println("matches");
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+(i+2)+"]/td/input")).click();
				System.out.println("clicked");
				break;
			}
		}
		driver.findElement(By.xpath("//a[.='/ Logout']")).click();


	}

}



