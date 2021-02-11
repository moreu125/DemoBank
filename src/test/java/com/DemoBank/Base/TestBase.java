package com.DemoBank.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.DemoBank.utilites.PropertiesUtiles;
import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static File file;
	public static Properties configPro ;
	public static Properties ORPro ;
	public static  Logger log = Logger.getLogger("devpinoyLogger");
	public WebDriverWait wait ; 

	@BeforeSuite
	public void setProperties() throws IOException {
		 PropertyConfigurator.configure("log4j.properties");
		configPro = PropertiesUtiles.set(".\\src\\test\\resources\\properties\\config.properties");
		ORPro = PropertiesUtiles.set(".\\src\\test\\resources\\properties\\ORProperties.properties");
	}
	@Parameters("browserName")
	@BeforeMethod
	public void setupMethod(@Optional("Chrome")String browserName) throws IOException {

	//	String browserName = configPro.getProperty("BrowserName");

		if (browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.debug("Chrome is open");
		} else if (browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.debug("Firefox is open");
		} else if (browserName.equals("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			log.debug(" IE is open");
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.debug("No correct BrowserName provided so Chrome open");

		}

		driver.get(configPro.getProperty("url"));
		log.debug("Navigate to URL :  " + configPro.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}









