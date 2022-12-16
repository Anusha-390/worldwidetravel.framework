package com.worldtravel.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class is used to handle userlogout page
 * @author Anusha M
 *
 */
public class UserLogOutPage {
@FindBy(xpath="//a[.='/ Logout']")private WebElement userLogoutButton;
public UserLogOutPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

/**
 * This method is used to logout as user from the application
 */
public void logOutAsUser() {
	userLogoutButton.click();	
}
}