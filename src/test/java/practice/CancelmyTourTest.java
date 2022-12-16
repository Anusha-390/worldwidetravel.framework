package practice;

//import java.io.FileNotFoundException;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.genericUtility.GetDataFromExcel;
import com.genericUtility.GetDataFromPropertyFile;
import com.genericUtility.IConstantPath;
import com.genericUtility.PropertyFileKeys;
import com.genericUtility.SheetName;
import com.genericUtility.WebdriverUtility;
import com.worldtravel.objectRepository.UserCommonPage;
import com.worldtravel.objectRepository.UserLoginPage;

public class CancelmyTourTest {
	public static void main(String[] args) throws InterruptedException{

		GetDataFromPropertyFile getDataFromPropertyFile=new GetDataFromPropertyFile();
		GetDataFromExcel getDataFromExcel=new GetDataFromExcel();
		WebdriverUtility webDriverUtility=new WebdriverUtility();

		getDataFromExcel.openExcel(IConstantPath.EXCEL_PATH);
		getDataFromPropertyFile.openPropertyFile(IConstantPath.PROPERTY_FILE_PATH);

		String browser  = getDataFromPropertyFile.getDataPropertyFile(PropertyFileKeys.BROWSER.convertToString());
		System.out.println(browser);
		String userlogin = getDataFromPropertyFile.getDataPropertyFile(PropertyFileKeys.USER_LOGIN.convertToString());
		String userpassword = getDataFromPropertyFile.getDataPropertyFile(PropertyFileKeys.USER_PWD.convertToString());
		//String timeout = getDataFromPropertyFile.getDataPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.TIMEOUT.convertToString());
		String url = getDataFromPropertyFile.getDataPropertyFile(PropertyFileKeys.URL.convertToString());

		WebDriver driver = webDriverUtility.launchApplication(browser, url);
		UserLoginPage UserLoginPage =new UserLoginPage(driver);
		UserCommonPage UserCommonPage=new UserCommonPage(driver);
		try {
			
			UserLoginPage.loginAsUser(userlogin, userpassword);
			/*driver.findElement(By.linkText("/ Sign In")).click();
			driver.findElement(By.xpath("//input[@name='email' and @placeholder='Enter your Email']")).sendKeys(userlogin);
			driver.findElement(By.xpath("//input[@id='password' and @placeholder='Password']")).sendKeys(userpassword);
			driver.findElement(By.name("signin")).click();*/
			
			UserCommonPage.clickOnMyTourHistory();
			//driver.findElement(By.xpath("//a[.='My Tour History']")).click();
			List<WebElement> allBookingId=UserCommonPage.getAllBookingId();
			//List<WebElement> allbookingId = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));

			
			for(WebElement allId:allBookingId)
			{
				String actualId = allId.getText();
				System.out.println(actualId);
				if(!actualId.equals("#BK47"))
				{
					String cancelConfirmation = driver.findElement(By.xpath("//td[.='"+actualId+"']/following-sibling::td[7]")).getText();

					if(cancelConfirmation.equals("Cancel"))
					{
						driver.findElement(By.xpath("//td[.='"+actualId+"']/following-sibling::td[7]")).click();

						// handling alert
						webDriverUtility.switchToAlertWindowAndAccept();
						System.out.println("ohhhhh bantu");
						break;
					}
					else
					{
						//System.out.println("ohhhh barlilla");
					}
				}
			}
			//WebDriverWait wait = webDriverUtility.intializeWebDriverWait(10);
			//wait.until(ExpectedConditions.visibilityOf(""));
			Thread.sleep(10000);
			String errormessage = driver.findElement(By.xpath("//div[@class='container']/form[@name='chngpwd']")).getText();
			System.out.println(errormessage);
			if(errormessage.contains("SUCCESS"))
			{
				//getDataFromExcel.excelData(IConstantPath.EXCEL_PATH, SheetName.CANCELTOURPACKAGEDATA.convertToString(), 0, 0);
				getDataFromExcel.setExcelData(IConstantPath.EXCEL_PATH, SheetName.CANCELTOURPACKAGEDATA.convertToString(), 1, 0, "Testcase is pass");

				System.out.println("Testcase is pass");

			}
			else {
				System.out.println("Testcase is fail");
			}
			driver.findElement(By.xpath("//a[.='/ Logout']")).click();
		}
		finally {
			getDataFromExcel.closeExcel();
			//driver.quit();
		}
	}
}



