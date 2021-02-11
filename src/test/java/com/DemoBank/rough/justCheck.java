package com.DemoBank.rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.velocity.texen.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class justCheck {
   public static void main(String args[]) throws IOException {
	    
	   String screenshotPath = "E:\\Screen";
	   String screenshotName = "ud.jpg";
	     WebDriverManager.chromedriver().setup();
	     WebDriver driver = new ChromeDriver();
	     driver.get("https://www.google.com/");
	     
	     TakesScreenshot tks = (TakesScreenshot) driver;
	     File src =  tks.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(src, new File(screenshotPath +"\\"+screenshotName));
	     driver.quit();
	      
	     
   }
}
