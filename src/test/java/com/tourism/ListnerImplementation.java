


package com.tourism;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.genericUtility.ThreadSafe;

public class ListnerImplementation implements ITestListener,IRetryAnalyzer {
	
	private ExtentReports eReports;
	private ExtentTest test;

	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		
		test=eReports.createTest(result.getMethod().getMethodName());
		ThreadSafe.setETest(test);
	}

	
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSucess");
		ThreadSafe.getETest().pass(result.getMethod().getMethodName()+"------->is passed");
		
		
	}

	
	public void onTestFailure(ITestResult result)
	{
		
		String testScriptName = result.getMethod().getMethodName();
		
		String screenShot = ThreadSafe.getwebDriverUtility().takeScreenshot( testScriptName);
		ThreadSafe.getETest().fail(result.getMethod().getMethodName());
		ThreadSafe.getETest().addScreenCaptureFromPath(screenShot,result.getMethod().getMethodName());
		
		
		
		/*
		 * EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.sdriver);
		 * File src = eDriver.getScreenshotAs(OutputType.FILE); File dst = new
		 * File("./screenshot/"+testScript+date+".png"); try { FileUtils.copyFile(src,
		 * dst); } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

	
	public void onTestSkipped(ITestResult result) {
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	public void onStart(ITestContext context) {
		System.out.println("on start");

		ExtentSparkReporter sparkReport=new ExtentSparkReporter("./Reports/extentHtmlre.html");
		sparkReport.config().setDocumentTitle("project extent report");
		sparkReport.config().setReportName("report 1");
		sparkReport.config().setTheme(Theme.STANDARD);
		
		eReports=new ExtentReports();
		eReports.attachReporter(sparkReport);
		
	}

	
	public void onFinish(ITestContext context) {
		System.out.println("on finish");
		eReports.flush();
		
		
	}

	int count=0;
	int retryLimt=5;
	
	public boolean retry(ITestResult result) {
		if(count<retryLimt)
		{
			count++;
			return true;
		}
		return false;
	}
	
	/*Date date=new Date();
		String Screenshotname = result.getMethod().getMethodName();
		WebdriverUtility util=new WebdriverUtility();
		
			try {
				util.takeScreenshot(BaseClass.sdriver, Screenshotname,date);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	

}
