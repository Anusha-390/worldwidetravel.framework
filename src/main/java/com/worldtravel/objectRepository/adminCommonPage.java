package com.worldtravel.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class performing common action in the admin page
 * @author Anusha M
 *
 */
public class adminCommonPage {
	@FindBy(xpath="//span[.='Manage Booking']") private WebElement manageBookingButton;
	@FindBy(xpath="//table/tbody/tr/td[1]/span[1]") private WebElement allBookingId;
	@FindBy(xpath="//span[.='Dashboard']") private WebElement dashBoard;
	@FindBy(xpath="//h3[.='Bookings']/following-sibling::h4[1]") private WebElement bookingStatus;
	@FindBy(xpath="//span[.=' Tour Packages']")private WebElement tourPackageButton;
	@FindBy(xpath="//a[.='Create']")private WebElement createButton;
	
	public adminCommonPage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}
	/**
	 * this method is used to click on manage booking
	 */
	
  public void clickManageBooking() {
	  manageBookingButton.click(); 
  }
  /**
   * this method is used to click on dashboard
   */
  public void clickDashboard() {
	  dashBoard.click();
  }
  /**
   * this method is used to get confirm booking status
   * @return
   */
  public String getConfirmBookingStatus() {
	return  bookingStatus.getText(); 
  }
  /**
   * this method is used to perform mouse over action
   * @return
   */
  public WebElement mouseOverOnTourPackage() {
	   return tourPackageButton;
  }
  /**
   * this method is used to click on craete button
   */
  public void clickOnCreateButton() {
	  createButton.click();  
  }
  
  
}
