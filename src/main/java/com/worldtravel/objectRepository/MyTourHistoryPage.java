package com.worldtravel.objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebdriverUtility;

/**
 * This class is used to handle my tour history page
 * @author Anusha M
 *
 */
public class MyTourHistoryPage {
	String str1="//td[.='%s']/following-sibling::td[7]";
    
    
    private WebDriver driver; 
    
    
    public MyTourHistoryPage (WebDriver driver) {
   	 this.driver=driver;
		PageFactory.initElements( driver, this);
	}
    
    /**
     * This method is used to handle dynamic xpath
     * @param str
     * @param replaceData
     * @return
     */
    public WebElement formateXpath( String str,String replaceData) {
    	String xpath = String.format(str, replaceData);
    	return driver.findElement(By.xpath(xpath));
    }
    
    /**
     * This method is used to perform click on cancel button
     * @param allBookingId
     * @param webDriverUtility
     */
public void ClickOnCancelBbutton( List<WebElement> allBookingId , WebdriverUtility webDriverUtility ) {

	for(int i=allBookingId.size()-1;i>=0;i--)
	{
		String actualId = allBookingId.get(i).getText();
		System.out.println(actualId);
		//if(!actualId.equals("#BK135"))
		//{
			String cancelConfirmation = formateXpath(str1, actualId).getText();

			if(cancelConfirmation.equals("Cancel"))
			{
				formateXpath(str1, actualId).click();
				// handling alert
				webDriverUtility.switchToAlertWindowAndAccept();
				System.out.println("ohhhhh bantu");
				break;
			}		
		//}
	}
}
}
