package com.genericUtility;


 
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.worldtravel.objectRepository.AdminLoginPage;
import com.worldtravel.objectRepository.AdminLogoutPage;
import com.worldtravel.objectRepository.UserCommonPage;
import com.worldtravel.objectRepository.UserLogOutPage;
import com.worldtravel.objectRepository.UserLoginPage;
//import com.worldtravel.objectRepository.CommonPage;
import com.worldtravel.objectRepository.adminCommonPage;
/*
 * This class contains the before class and before method and also after class annotations
 */


public class BaseClass {
	protected WebDriver driver;
	protected  WebdriverUtility webDriverUtility;
	protected GetDataFromPropertyFile getDataFromPropertyFile;
	protected GetDataFromExcel getDataFromExcel;
	protected AdminLoginPage AdminLoginPage;
	protected adminCommonPage adminCommonPage;
	protected UserLoginPage UserLoginPage;
	protected AdminLogoutPage AdminLogoutPage;
	protected String adminlogin ;
	protected String adminpassword;
	protected String userlogin;
	protected String userpassword;
	protected UserCommonPage UserCommonPage;
	protected UserLogOutPage UserLogOutPage;
	protected AdminLogoutPage AdminLogoutPage1;
    public static WebDriver sdriver ;

/*
 * This method handle beforeclass annotation
 */

	@BeforeClass(groups = "System",alwaysRun=true)
	public void Test1() {

		getDataFromPropertyFile=new GetDataFromPropertyFile();
		getDataFromExcel=new GetDataFromExcel();
		webDriverUtility=new WebdriverUtility();

		getDataFromExcel.openExcel(IConstantPath.EXCEL_PATH);
		getDataFromPropertyFile.openPropertyFile(IConstantPath.PROPERTY_FILE_PATH);

		String browser = getDataFromPropertyFile.getDataPropertyFile(PropertyFileKeys.BROWSER.convertToString());
		String url = getDataFromPropertyFile.getDataPropertyFile(PropertyFileKeys.URL.convertToString());

		adminlogin = getDataFromPropertyFile.getDataPropertyFile(PropertyFileKeys.ADMIN_LOGIN.convertToString());
		adminpassword = getDataFromPropertyFile.getDataPropertyFile(PropertyFileKeys.ADMIN_PWD.convertToString());

		userlogin = getDataFromPropertyFile.getDataPropertyFile(PropertyFileKeys.USER_LOGIN.convertToString());
		userpassword = getDataFromPropertyFile.getDataPropertyFile(PropertyFileKeys.USER_PWD.convertToString());

		ThreadSafe.setwebDriverutility(webDriverUtility);
		 
		driver = webDriverUtility.launchApplication(browser, url);
		sdriver = driver;
	}
	/*
	 * This method handle the beforemethod annotation
	 */
	@BeforeMethod(alwaysRun=true)
	public void test1()
	{
		UserLoginPage =new UserLoginPage(driver);
		UserCommonPage=new UserCommonPage(driver);
		AdminLoginPage=new AdminLoginPage(driver);
		adminCommonPage=new adminCommonPage(driver);
		AdminLogoutPage =new AdminLogoutPage(driver);
	    UserLogOutPage=new UserLogOutPage(driver);
	
	}

/*
 * This method handle aftermethod annotation
 */
	@AfterMethod(alwaysRun=true)
	public void methodTearSetup()
	{

		//UserLogOutPage.logOutAsUser();
		//AdminLogoutPage.logOutAdmin(); 

	}
/*
 * this method handle afterclass annotation
 */
	@AfterClass(alwaysRun=true)
	public void classTearSetup()
	{
		getDataFromExcel.closeExcel();
		getDataFromPropertyFile.closePropertyFile();
		driver.quit();
	}

}
