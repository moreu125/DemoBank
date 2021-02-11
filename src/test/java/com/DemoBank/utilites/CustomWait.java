package com.DemoBank.utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWait {
	public static WebDriverWait wait(long timeUnits, WebDriver driver) {

		return new WebDriverWait(driver, timeUnits);

	}



	public static WebElement visibilityOfElementLocated(By locators, long timeUnitsSecond, WebDriver driver) {
		return  new WebDriverWait(driver, timeUnitsSecond).until(ExpectedConditions.visibilityOfElementLocated(locators));
		
	}
}
