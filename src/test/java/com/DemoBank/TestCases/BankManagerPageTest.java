package com.DemoBank.TestCases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.DemoBank.WebElementMethod.WebMethods;
import com.DemoBank.utilites.HandleAlert;

import net.bytebuddy.jar.asm.Handle;

public class BankManagerPageTest extends WebMethods {
	@Test

	public void AddCustomerTest() {
		log.debug("Add Customer Test Star");

		click("btnLoginToManager");
		click("btnAddCustomer");
		type("txtBoxFirstName", "Uday");
		type("txtBoxLastName", "More");
		type("txtBoxPostCode", "413108");
		click("btnAddbutton");
                //update are done is This test case
		Assert.assertEquals("Customer added successfully with customer id :6", HandleAlert.AlertText());

		HandleAlert.acceptAlert();

		log.debug("Add Customer Test is done ");

	}

	//@Test
	public void OpenAccountTest() throws InterruptedException {
		log.debug("Open Account Test start");
		click("btnLoginToManager");
		click("btnOpenAccount");

		SelectOption("dropDownCustomerName", "Ron Weasly");
		SelectOption("dropDownCurrency", "Rupee");

		click("btnProcess");
		
		Thread.sleep(5000);

		System.out.println(HandleAlert.AlertText());



	}

}






