package com.DemoBank.utilites;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.DemoBank.Base.TestBase;

public class TestUtiles extends TestBase {
	  public static String screenPath;
	  public static String screenshotName ;
      public static void captureScreenShot(String testName){
    	  TakesScreenshot tss = (TakesScreenshot) driver;
    	  File src = tss.getScreenshotAs(OutputType.FILE);
    	  System.out.println(testName);
    	  Date d = new Date();
    	 
  		screenshotName = d.toString().replace(":", "_").replace(" ", "_") +testName+".png";
  		System.out.println(screenshotName);
    	screenPath = System.getProperty("user.dir") + "\\ScreenShot\\" + screenshotName ;
    	  try {
			FileUtils.copyFile(src, new File(screenPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
}
