package com.tourism;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.genericUtility.BaseClass;
import com.genericUtility.IConstantPath;
import com.genericUtility.SheetName;
import com.worldtravel.objectRepository.AdminLogoutPage;
import com.worldtravel.objectRepository.AdminManageBookingPage;
import com.worldtravel.objectRepository.CreatePackagePage;
import com.worldtravel.objectRepository.MyTourHistoryPage;

public class TourismFramework extends BaseClass {
	@Test
	public void UserBookTourpackageTest() throws InterruptedException { 
		
		Date date=new Date();
		System.out.println(date);
		String date1 = date.toString().split(" ")[3];
		System.out.println(date1);
		String date2 = date1.split(":")[0];
		System.out.println(date2);
		String date3 = date1.split(":")[1];
		System.out.println(date3);
		String date4=date2+":"+date3;
		System.out.println(date4);
		String expectedBookingTime=date3.toString();
		
		
		AdminLoginPage.loginAsAdmin(adminlogin,adminpassword);
		AdminLogoutPage AdminLogoutPage =new AdminLogoutPage(driver);

		adminCommonPage.clickDashboard();

		String bookingStatus = adminCommonPage.getConfirmBookingStatus();

		int bs = Integer.parseInt(bookingStatus);
		System.out.println("before ----> "+bs);
		AdminLogoutPage.logOutAdmin();

		UserLoginPage.loginAsUser(userlogin, userpassword);
		UserCommonPage.clickOnTourPackage();
		UserCommonPage.clickOnSelectPackage();


		UserCommonPage.enterDetails("02-12-2022", "15-12-2022");



		UserCommonPage.enterComment("hellooo");
		UserCommonPage.clickOnMyTourHistory();

		//int count = UserCommonPage.getBookingTime(UserCommonPage.getAllBookingId(), expectedBookingTime);

		 
			
		UserLogOutPage.logOutAsUser();

		AdminLoginPage.loginAsAdmin(adminlogin, adminpassword);
		adminCommonPage.clickDashboard();
		String afterbookingStatus = adminCommonPage.getConfirmBookingStatus();
		int abs = Integer.parseInt(afterbookingStatus);

		int ebs = bs+1;

		System.out.println("after bs ----> "+ebs);
		System.out.println("actual ------> "+abs);
		try {
			assertEquals(abs,ebs);




			getDataFromExcel.setExcelData(IConstantPath.EXCEL_PATH, SheetName.USERTOURPACKAGEDATA.convertToString(), 0, 0, "updated sucessfully");

			System.out.println("Testcase is pass");

		}
		catch (Exception e) {
			


			System.out.println("Testcase is fail");
		}
		AdminLogoutPage.logOutAdmin();
	}



	
	


@Test
public  void CreateTourpackageTest() throws InterruptedException  {

	CreatePackagePage CreatePackagePage=new CreatePackagePage(driver);
	AdminLoginPage.loginAsAdmin(adminlogin, adminpassword);

	String[][] data = getDataFromExcel.getDataExcel(SheetName.CREATETOURPACKAGEDATA.convertToString());

	for(int i=0;i<data.length;i++)

	{
		webDriverUtility.mouseOverAction(adminCommonPage.mouseOverOnTourPackage());
		adminCommonPage.clickOnCreateButton();

		CreatePackagePage.packageNameTextField(data[i][0]);
		CreatePackagePage.packageTypeTextField(data[i][1]);
		CreatePackagePage.packageLocationTextField(data[i][2]);
		CreatePackagePage.packagePriceTextField(data[i][3]);


		webDriverUtility.javascriptExecuteAction("window.scrollBy(0,500)");

		CreatePackagePage.packageFeaturesTextField(data[i][4]);
		CreatePackagePage.packageDetailsTextField(data[i][5]);


		Thread.sleep(2000);

		CreatePackagePage.packageImageTextField(data[i][6]);
		CreatePackagePage.clickSubmitButton();
		String packagecreated=CreatePackagePage.getConfirmasionMesssage();
		try {

		assertTrue(packagecreated.contains("Package Created Successfully"));

		getDataFromExcel.setExcelData(IConstantPath.EXCEL_PATH, SheetName.CREATETOURPACKAGEDATA.convertToString(), i+1, 8, "Testcase pass");

		System.out.println(i+" ----->Testcase is pass");


	}
		catch (Exception e) {
			System.out.println("Testcase is fail");
		}


}
	AdminLogoutPage.logOutAdmin();

}


@Test
public  void CancelmyTourTest() throws InterruptedException{

	MyTourHistoryPage MyTourHistoryPage=new MyTourHistoryPage(driver);
	
		UserLoginPage.loginAsUser(userlogin, userpassword);
		
		UserCommonPage.clickOnMyTourHistory();
		
		MyTourHistoryPage.ClickOnCancelBbutton(UserCommonPage.getAllBookingId(), webDriverUtility);
		
		String ErrorMessage = UserCommonPage.getErrorMsg();
		try {
		assertTrue(ErrorMessage.contains("SUCCESS"));
		
		
			
			getDataFromExcel.setExcelData(IConstantPath.EXCEL_PATH, SheetName.CANCELTOURPACKAGEDATA.convertToString(), 1, 0, "Testcase is pass");

			System.out.println("Testcase is pass");

		
		}
		catch (Exception e) {
			System.out.println("Testcase is fail");
		}
		
	
}

@Test
public  void AdminManageBookinTest() throws InterruptedException, AWTException  {


	AdminManageBookingPage AdminManageBookingPage=new AdminManageBookingPage(driver);

	AdminLoginPage.loginAsAdmin(adminlogin,adminpassword);

	adminCommonPage.clickManageBooking();

	String expectedId = "#BK-18";
	
	Robot r=new Robot();
	
	for(int i=1;i<=3;i++)
	{
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_MINUS);
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyRelease(KeyEvent.VK_MINUS);
	}


	AdminManageBookingPage.scrollUptoTheElement(expectedId);


	List<WebElement> allBookingId = AdminManageBookingPage.getAllBookingId();
	int count = allBookingId.size();
	System.out.println(count);

	for(WebElement bookingId:allBookingId)
	{
		String actualId = bookingId.getText();

		System.out.println(actualId+" --------> actual id");

		if(actualId.equals(expectedId))
		{
			//assertEquals(actualId,expectedId);

			AdminManageBookingPage.clickOnConfirmButton(expectedId, webDriverUtility);
			break;
		}

	}

	String status = "successfully";
	String bookingsucessfully = AdminManageBookingPage.getConfirmationMessage();
	System.out.println(bookingsucessfully);

	assertTrue(bookingsucessfully.contains(status),"Testcase is fail bcoz expected is "+status+" but actual result is "+bookingsucessfully+" ");

	System.out.println("Testcase is pass");
	getDataFromExcel.setExcelData(IConstantPath.EXCEL_PATH, SheetName.ADMINMANAGEBOOKINGDATA.convertToString(), 1, 0, "Testcase is pass");	
}
}




