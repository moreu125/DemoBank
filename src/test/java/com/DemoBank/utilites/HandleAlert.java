package com.DemoBank.utilites;

import org.openqa.selenium.Alert;

import com.DemoBank.Base.TestBase;

public class HandleAlert extends TestBase {
	public static Alert alert = driver.switchTo().alert();

	public static void acceptAlert() {

		// log.debug("Alert is present");
		alert.accept();
		log.debug("Alert is accepted");

	}

	public static String AlertText() {
		log.debug("Alert Text is   : " + alert.getText());
		return alert.getText();

	}
	
	public static void dismissAlert() {
		alert.dismiss();
		log.debug("Alert is dismissed ");
	}
}
