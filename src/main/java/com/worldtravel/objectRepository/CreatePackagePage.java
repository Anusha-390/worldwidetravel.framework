package com.worldtravel.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class is used to handle the create package page
 * @author Anusha M
 *
 */
public class CreatePackagePage {
	@FindBy(name="packagename")private WebElement packageNameTextField;
	@FindBy(id="packagetype")private WebElement packageTypeTextField;
	@FindBy(name="packagelocation")private WebElement packageLocationTextField;
	@FindBy(name="packageprice")private WebElement packagePriceTextField;
	@FindBy(name="packagefeatures")private WebElement packageFeaturesTextField;
	@FindBy(name="packagedetails")private WebElement packageDetailsTextField;
	@FindBy(name="packageimage")private WebElement packageImageTextField;
	@FindBy(xpath="//button[@name='submit']")private WebElement submitButton;
	@FindBy(xpath="//div[@class='left-content']")private WebElement confirmasionMesssage;
	
	public CreatePackagePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to enter the package name 
	 * @param value
	 */
public void packageNameTextField(String value) 
{
	packageNameTextField.sendKeys(value);
}


/**
 * This method is used to enter the packageTypeTextField
 * @param value
 */
public void packageTypeTextField(String value) 
{
	packageTypeTextField.sendKeys(value);
}

/**
 * This method is used to enter the package location 
 * @param value
 */
public void packageLocationTextField(String value) 
{
	packageLocationTextField.sendKeys(value);
}

/**
 * This method is used to enter the data in packagePriceTextField
 * @param value
 */
public void packagePriceTextField(String value) 
{
	packagePriceTextField.sendKeys(value);
}

/**
 * This method is used to enter the data in packagePriceTextField
 * @param value
 */
public void packageFeaturesTextField(String value) 
{
	packageFeaturesTextField.sendKeys(value);
}

/**
 * This method is used to enter the data in packagePriceTextField
 * @param value
 */
public void packageDetailsTextField(String value) 
{
	packageDetailsTextField.sendKeys(value);
}


/**
 * This method is used to enter the data in packagePriceTextField
 * @param value
 */
public void packageImageTextField(String value) 
{
	packageImageTextField.sendKeys(value);
}


/**
 * This method is used to perform the click action on Submit button
 * return
 */
public void clickSubmitButton() 
{
	submitButton.click();
}

/**
 * This method is used to get the confirmation message
 * return
 */
public String getConfirmasionMesssage() 
{
	return confirmasionMesssage.getText();
}

}
