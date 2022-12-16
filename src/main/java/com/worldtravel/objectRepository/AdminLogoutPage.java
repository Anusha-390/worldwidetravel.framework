package com.worldtravel.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class is used to handle the admin logout page
 * @author Anusha M
 *
 */
public class AdminLogoutPage {
	@FindBy(xpath="//i[@class='fa fa-angle-down']") private WebElement  adminLogOutButton;
    @FindBy(xpath="//i[@class='fa fa-sign-out']") private WebElement signout;
	@FindBy(xpath="//a[.='Back to home']") private WebElement backToHomeButton;
	
	public AdminLogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
}
	/**
	 *This method is used to logout from the application as admin
	 */
public void logOutAdmin()
{
	adminLogOutButton.click();
	signout.click();
	backToHomeButton.click();
}
}