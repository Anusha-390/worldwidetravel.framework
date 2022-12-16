package com.worldtravel.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class is used to handle the user login page
 * @author Anusha M
 *
 */
public class UserLoginPage {
	@FindBy(linkText="/ Sign In") private WebElement signin;
	@FindBy(xpath="//input[@name='email' and @placeholder='Enter your Email']") private WebElement userLOginTextField;
	@FindBy(xpath="//input[@id='password' and @placeholder='Password']") private WebElement userPasswordTextField;
	@FindBy(name="signin")private WebElement signinButton;
	public UserLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to login to the application as user
	 * @param userId
	 * @param userPwd
	 */
	public void loginAsUser(String userId, String userPwd){
		{
			signin.click();	
			userLOginTextField.sendKeys(userId);
			userPasswordTextField.sendKeys(userPwd);
			signinButton.click();
		}
	}
}
