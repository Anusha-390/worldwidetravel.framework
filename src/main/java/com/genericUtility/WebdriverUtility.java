package com.genericUtility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.poi.ss.formula.functions.T;
//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains common web driver actions
 * @author Anusha M
 *
 */
public class WebdriverUtility {
	private WebDriver driver;

	/**
	 * This method is used to launch browser based on browser key
	 * maximize the browser
	 * provide implicit wait
	 * @param browser
	 *@param url
	 * @return
	 */




	public WebDriver launchApplication(String browser,String url) {
		if(browser.contains("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		/*else if(browser.contains("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.contains("ie"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new InternetExplorerDriver();

		}*/
		else {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();	
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		return driver;
	}
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebElement element) 
	{

		new Actions(driver).moveToElement(element).perform();

	}
	
	public WebDriverWait intializeWebDriverWait(long timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		return wait;
	}
	/**
	 * @param driver
	 * @param javaScript
	 */
	public void javascriptExecuteAction(String javaScript) {
		
		 ((JavascriptExecutor)driver).executeScript(javaScript);
		
	}
	/**
	 * wait for page to load before identifying any assynchronized [java scripts actions]element in DOM[HTML-Document
	 * @param driver
	 */
	@SuppressWarnings("deprecation")
	public void waitForPageToLoadForJSElement() {
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		}
       /**
        * used to wait for element to be clickable in GUI,& check for specific element for every 500 milli seconds
        * @param driver
        * @param element
        */
	 public void waitForElementToBeClickable(WebElement element) {
		 @SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,20);
		 wait.until(ExpectedConditions.elementToBeClickable(element));
	 }
	 
	/* public void waitForElementWithCumtomTimeOut(WebElement element,int pollingTime);
	 {
		 FluentWait wait = new fluentWait(driver);
		 Duration pollingTime;
		wait.pollingEvery(pollingTime);
		 wait.wait(20);
		 By element;
		wait.until(ExpectedConditions.elementToBeClickable(element));
	 }*/
	 /**
	  * used to Switch to any Window based on Window Title
	  * @param driver
	  * @param partialWindowTitle
	  */
	 public void swithToWindow(String partialWindowTitle) {
		 Set<String> set = driver.getWindowHandles();
		 Iterator<String> it = set.iterator();
		 while(it.hasNext()) {
			 String wID=it.next();
			 driver.switchTo().window(wID);
			 String currentWindowTitle=driver.getTitle();
			 if(currentWindowTitle.contains(partialWindowTitle()))
					 
					 {
				 break;
					 }
		 }
	 }
		private CharSequence partialWindowTitle() {
		// TODO Auto-generated method stub
		return null;
	}
     /**
      * used to Switch to Alert Window & click on OK button 
      * @param driver
      */
		public void switchToAlertWindowAndAccept() { 
			driver.switchTo().alert().accept();
		}
		/**
		 * used to Switch to Alert & click on Cancel button
		 * @param driver
		 */
		public void switchToAlertWindowAndCancel() {
			driver.switchTo().alert().dismiss();
		}
		/**
		 * used to Switch to Frame Window based on index 
		 * @param driver
		 * @param index
		 */
		public void switchToFrame(int index) {
			driver.switchTo().frame(index);
		}
		/**
		 * used to Switch to Frame Window based on id or name attribute
		 * @param driver
		 * @param id_name_attribute
		 */
		public void switchToFrame(String id_name_attribute) {
			driver.switchTo().frame(id_name_attribute);
		}
		/**
		 * used to Switch to Frame Window based on element address
		 * @param element_address
		 */
		public void switchToFrameByAddress(WebElement element_address) {
			driver.switchTo().frame(element_address);
		}
		/**
		 * used to select the value from the dropdown based on index 
		 * @param element
		 * @param index
		 */
		public void selectByIndex(WebElement element,int index) {
			Select sel=new Select(element);
			sel.selectByIndex(index);
		}
		/**
		 * used to select the value from the dropdown based on value/option available in GUI
		 * @param element
		 * @param text
		 */
		public void selectByVisibleText(WebElement element,String text) {
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
		}
		/**
		 * used to select the value from the dropdown based on value
		 * @param element
		 * @param value
		 */
		
		public void selectByValue(WebElement element,String text) {
			Select sel = new Select(element);
			sel.selectByValue(text);
		}
		/**
		 * used to deselect the value from the dropdown based on index
		 * @param element
		 * @param index
		 */
		public void deselectByIndex(WebElement element,int index) {
			Select sel = new Select(element);
			sel.deselectByIndex(index);
		}
		/**
		 * used to deselect the value from the dropdown based on text
		 * @param element
		 * @param text
		 */
		public void deselectByVisibleText(WebElement element,String text) {
			Select sel = new Select(element);
			sel.deselectByVisibleText(text);
		}
        /**
         * used to deselect the value from the dropdown based on value
         * @param element
         * @param text
         */
		public void deselectByValue(WebElement element,String text) {
			Select sel = new Select(element);
			sel.deselectByValue(text);
		}
		/**
		 * used to deselectAll  the element from the dropdwon
		 * @param element
		 */
		public void deselectAll(WebElement element) {
			Select sel = new Select(element);
			sel.deselectAll();
		}	
			/**
			 * used to 
			 * @param element
			 * @return
			 */
		public boolean isMultiple(WebElement element) {
			Select sel = new Select(element);
			boolean result = sel.isMultiple();
			return result;
		}
		/**
		 * used to getwrappedelement from the dropdown
		 * @param element
		 * @return
		 */
		public WebElement getWrappedElement(WebElement element) {
			Select sel = new Select(element);
			 WebElement result = sel.getWrappedElement();
			 return result;
			 	}
		
		/**
		 * used to getFirstSelectedOption from the dropdown
		 * @param element
		 * @return
		 */
		public WebElement getFirstSelectedOption(WebElement element) {
			Select sel = new Select(element);
			 WebElement result = sel.getFirstSelectedOption();
			 return result;
				}
			
        /**
         * used to get
         * @param element
         * @return
         */
		public List<WebElement> getOptions(WebElement element) {
			Select sel = new Select(element);
			  List<WebElement> result = sel.getOptions();
			  return result;
			 
				}
			/**
			 * used to switch to parentframe
			 * @param driver
			 */
			public void switchToParentFrame() {
				driver.switchTo().parentFrame();
			}
			
		
		
		/**
		 * used to right click on specified element
		 * @param driver
		 * @param element
		 */
			
		public void rightClickOnElement(WebElement element) 
		{

			new Actions(driver).contextClick(element).perform();

		}	
		/**
		 * used to dragAndDrop on the specified element
		 * @param driver
		 * @param source
		 * @param destination
		 */
		public void dragAnddrop(WebElement source,WebElement destination) {
			new Actions(driver).dragAndDrop(source, destination).perform();
		}
		/**
		 * used to doubleclick on the specified element
		 * @param driver
		 * @param element
		 */
		public void doubleClick(WebElement element) {
			new Actions(driver).doubleClick(element).perform();
		}
		/**
		 *  used to take the screenshot
		 * @param driver
		 * @param screenshotName
		 * @return 
		 * @throws IOException
		 */
		public String takeScreenshot(String screenshotName)
		{
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_YY_HH_mm_ss");
			String date1 = sdf.format(date);
			System.out.println(date);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dest=new File("./screenshot/"+screenshotName+date1+".png");
			try {
				FileUtils.copyFile(src,dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return dest.getAbsolutePath();
		}
}			

	
		
		
		
		
		
		
		
			
			
			
			
			
		
		
		
		
		
		
			 
				 
				 
				 
				 
			 
		 
	 



