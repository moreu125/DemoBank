package com.DemoBank.WebElementMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.DemoBank.Base.TestBase;

public class WebMethods extends TestBase{
    //Action Method
	 public void click(String locators) {
		 driver.findElement(By.xpath(ORPro.getProperty(locators))).click();;
		 log.debug("Click to " + locators);

	 }
	 
	 public void type(String locators , String value) {
		 WebElement inputBox =  driver.findElement(By.xpath(ORPro.getProperty(locators)));
		 inputBox.sendKeys(value);
	 }
	 //Verification Method
	 
	 public boolean isElementDisplayed(String locators) {
		  WebElement element = driver.findElement(By.xpath(ORPro.getProperty(locators)));
		  
		 log.debug(locators + " is Displayed");
		 return element.isDisplayed();
	                     	 
	 }
	 
	 public String PageTitle() {
		 log.debug("Login Page Title is  :" + driver.getTitle());
		 return driver.getTitle();
	 }
	 
	 //DropDownMethod
	 public void SelectOption(String locatorsForDropDown ,  String optionToSelected) {
		 WebElement dropDown = driver.findElement(By.xpath(ORPro.getProperty(locatorsForDropDown)));
		 Select select = new Select(dropDown);
		 select.selectByVisibleText(optionToSelected);
		 log.debug("From "+locatorsForDropDown + " option " +optionToSelected +" is selected"   );
	 }
	 
	 
	 
}














