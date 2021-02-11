package com.DemoBank.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.DemoBank.Base.TestBase;
import com.DemoBank.WebElementMethod.WebMethods;
import com.DemoBank.utilites.CustomWait;
//import com.DemoBank.utilites.ExplicitWait;

public class LoginPageTestCase extends WebMethods {
	@Test
	public void loginPageTitleTest() {
		String expected = "Protractor practice website - Banking App";
		log.debug("loginPageTitleTest is start");
		
		Assert.assertEquals(PageTitle(), expected, "Actual and Expected title are not match");
		
		log.debug("loginPageTitleTest is done");
	}

	@Test
	public void loginHomePageButtonTest() {
		log.debug("loginPageHomeButtonTest is start");
	  
		Assert.assertTrue(isElementDisplayed("btnHome"), "Home button is not display");
		click("btnHome");
      
		log.debug("loginPageHomeButton");
		
	}

	@Test
	public void loginToManagerTest() throws InterruptedException {
		log.debug("loginToManagerTest is start");

		click("btnLoginToManager");
		
		Assert.assertTrue(isElementDisplayed("btnAddCustomer"), "Login is not done");
		log.debug("loginToManagerTest is done ");
	}
}















