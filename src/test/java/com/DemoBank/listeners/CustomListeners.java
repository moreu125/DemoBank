package com.DemoBank.listeners;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.DemoBank.utilites.MonitoringMail;
import com.DemoBank.utilites.TestConfig;
import com.DemoBank.utilites.TestUtiles;
import com.DemoBank.utilites.ZipUtils;



//import com.w2a.utilities.TestUtil;

public class CustomListeners implements ITestListener{
	public 	String messageBody;
	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName() + " is Passed");
	}

	public void onTestFailure(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.escape-output","false");
        TestUtiles.captureScreenShot(result.getName());
		Reporter.log(result.getName() + " is Fail");
		
		Reporter.log("Click to see Screenshot");
		Reporter.log("<a target=\"_blank\" href="+TestUtiles.screenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+TestUtiles.screenPath +"><img src="+TestUtiles.screenPath+" height=200 width=200></img></a>");
	
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
	     
		ZipUtils.zip(System.getProperty("user.dir")+"\\test-ouput");
		MonitoringMail mail = new MonitoringMail();
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}















