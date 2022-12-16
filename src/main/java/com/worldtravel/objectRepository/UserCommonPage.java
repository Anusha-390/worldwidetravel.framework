package com.worldtravel.objectRepository;

import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * This class is used to handle user common page
 * @author Anusha M
 *
 */
public class UserCommonPage {
	@FindBy(linkText="Tour Packages")private WebElement tourPackageButton;
	@FindBy(xpath="//h4[contains(text(),'Package Name: Manali Trip') ] /../following-sibling::div/a")private WebElement packageName;
	@FindBy(xpath="//input[@id='datepicker']")private WebElement passFromDate;
     @FindBy(xpath="//input[@id='datepicker1']")private WebElement passToDate ;
     @FindBy(xpath="//input[@name='comment']")private WebElement comment;
     @FindBy(xpath="//button[@name='submit2']") private WebElement submitbutton;
     @FindBy(xpath="//a[.='My Tour History']") private WebElement myTourHistoryButton;
     @FindBy(xpath="//table/tbody/tr/td[2]")private List<WebElement>  AllBookingId;
     @FindBy(xpath = "(//div[@class='container'])[5]") private WebElement successPage;
     
     String partialxpath="//td[.='%s']/following-sibling::td[6]";
     
     @FindBy(xpath="//div[@class='container']/form[@name='chngpwd']") private WebElement errormessage;
     
     
     /**
      * This method is used to handle dynamic xpath
      * @param partialxpath
      * @param replacedData
      * @return
      */
     public WebElement formateXpath(String partialxpath,String replacedData )
     {
    	 String xpath = String.format(partialxpath, replacedData);
    	 return driver.findElement(By.xpath(xpath));
    	 
     }
     
     private WebDriver driver; 
     public UserCommonPage (WebDriver driver) {
    	 this.driver=driver;
 		PageFactory.initElements( driver, this);
 	}
     /**
      * This method is used to handle click on tour package
      */
     public void clickOnTourPackage(){
    	 tourPackageButton.click(); 
     }
     /**
      * This method is used to handle click on select package
      */
     public void clickOnSelectPackage() {
    	 packageName.click(); 
     }
     
     /**
      * This method is used to handle to enter the date
      * @param SendFromDate
      * @param sendToDate
      */
     public void enterDetails( String SendFromDate,String sendToDate ) {
    	 passFromDate.sendKeys(SendFromDate); 
    	 passToDate.sendKeys(sendToDate);
    	 
     }
     /**
      * This method is used to handle to enter comment
      * @param userComment
      */
     public void enterComment(String userComment) {
    	 comment.sendKeys(userComment); 
    	 submitbutton.click();
    	 
     }
     /**
      * This method is used to click on my tour history
      */
     public void clickOnMyTourHistory() {
    	 myTourHistoryButton.click(); 
     }
     /**
      * This method is used to get the confirmation on allBookingID
      * @return
      */
     public List<WebElement> getAllBookingId() {
    	 List<WebElement> allBookingId=AllBookingId;
    	return allBookingId;
     }
     /**
      * This method is used to get the booking time
      * @param allBookingId
      * @param expectedBookingTime
      * @return
      */
     public int getBookingTime(List<WebElement> allBookingId,String expectedBookingTime) {
    	 int count = 0;
    	 for(int i=0;i<allBookingId.size();i++)
			{
    		 String actualMessage = successPage.getText();
       	  System.out.println(actualMessage);
				String actualId = allBookingId.get(i).getText();
				String actualBookingTime = formateXpath(partialxpath,actualId).getText();
				if(actualBookingTime.contains(expectedBookingTime))
				{
					System.out.println("updated sucessfully");
					count++;
					System.out.println(i);
					break;
				}
			}
    	 return count;
     }
     
     public int getSuccessMessage(String expectedMessage)
     {
    	 int count = 0;
    	  String actualMessage = successPage.getText();
    	  System.out.println(actualMessage);
    	  if(actualMessage.contains(expectedMessage))
    	  {
    		  System.out.println(expectedMessage);
    		  count++;
    	  }
    	  return count;
     }
     
     /**
      * this method is used to get the error message
      * @return
      */
     public String getErrorMsg()
     {
            String ErrorMessage = errormessage.getText();
            return ErrorMessage;
     }
    }

