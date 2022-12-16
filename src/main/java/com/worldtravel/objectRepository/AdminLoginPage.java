package com.worldtravel.objectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class is used to handle adminloginpage
 * @author Anusha M
 *
 */

public class AdminLoginPage {
	@FindBy(xpath="//a[.='Admin Login']") private WebElement adminLoginButton ;
	@FindBy(xpath="//input[@class='name']") private WebElement AdminNameTextField;
	@FindBy(xpath="//input[@class='password']") private WebElement AdminpasswordTextField;
	
	public AdminLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/** 
	 * This method is used to login to the application as admin
	 * @param adminName
	 * @param adminPassword
	 */
	public void loginAsAdmin(String adminName, String adminPassword)
	{
		adminLoginButton.click();
		AdminNameTextField.sendKeys(adminName);
		AdminpasswordTextField.sendKeys(adminPassword,Keys.ENTER);
	}
	

}
