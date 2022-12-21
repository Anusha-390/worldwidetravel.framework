package com.genericUtility;

import com.aventstack.extentreports.ExtentTest;

public class ThreadSafe {
	private static ThreadLocal<WebdriverUtility> webDriverUtility=new ThreadLocal<>();
	private static ThreadLocal<ExtentTest> eTest=new ThreadLocal<>();
	
	public static WebdriverUtility getwebDriverUtility()
	{
		return webDriverUtility.get();
		
	}
	public static void setwebDriverutility(WebdriverUtility swebDriverUtility) {
		webDriverUtility.set(swebDriverUtility);
	}
	
	public static ExtentTest getETest()
	{
		return eTest.get();
	}
	
	public static void setETest( ExtentTest sTest) {
		eTest.set( sTest);
	}
}
