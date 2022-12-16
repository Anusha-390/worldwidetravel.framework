package com.worldtravel.objectRepository;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebdriverUtility;


/**
 * This class is used to handle the adminmanagebooking page
 * @author Anusha M
 *
 */
public class AdminManageBookingPage {

	@FindBy(xpath="//table/tbody/tr/td[1]/span[1]") private List<WebElement> BookingId;

	@FindBy(xpath="//div[@class='left-content']") private WebElement BookingSucessfully;
	private WebDriver driver;
	public AdminManageBookingPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements( driver, this);
	}


	/**
	 * This method is used get all booking id
	 * @return
	 */
	public List<WebElement> getAllBookingId()
	{
		List<WebElement>allBookingId=BookingId;
		return allBookingId;
	}
	/**
	 * this method is used to perform scroll bar action
	 * @param expectedId
	 */

	public void scrollUptoTheElement(String expectedId)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;

		int X = driver.findElement(By.xpath("//span[.='"+expectedId+"']")).getLocation().getX();
		int Y = driver.findElement(By.xpath("//span[.='"+expectedId+"']")).getLocation().getY();
		js.executeScript("window.scrollBy("+X+","+Y+")");
	}
	/**
	 * this method is used to perfrom click on confirmation button
	 * @param expectedId
	 * @param webDriverUtility
	 * @throws InterruptedException
	 */

	public void clickOnConfirmButton(String expectedId,WebdriverUtility webDriverUtility) throws InterruptedException
	{
		driver.findElement(By.xpath("//span[.='"+expectedId+"']/../following-sibling::td[8]/span/a[2]")).click();
		Thread.sleep(2000);

		// handling alert
		webDriverUtility.switchToAlertWindowAndAccept();

	}

	/**
	 * This method is used to get the confirmation message
	 * @return
	 */
	public String getConfirmationMessage() {
		String bookingsucessfully = BookingSucessfully.getText();
		return bookingsucessfully;

	}


}
