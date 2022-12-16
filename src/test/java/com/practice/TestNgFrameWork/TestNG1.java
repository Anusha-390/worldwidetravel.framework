package com.practice.TestNgFrameWork;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG1 {
	@BeforeSuite()
	public void test1()
	{
		Reporter.log("before suite",true);
	}
	@BeforeTest()
	public void test2() {
		Reporter.log("before test",true);
	}
	
	@BeforeMethod()
	public void test3() {
		Reporter.log("before method",true);
	}
	
	@BeforeClass()
	public void test4() {
		Reporter.log("before class",true);
	}
	
	@Test()
	public void test5()
	{
		Reporter.log("at test",true);
		
	}
	@AfterClass()
	public void test6() {
		Reporter.log("after class",false);
		
	}
	@AfterMethod()
	public void test7() {
		Reporter.log("after method",true);
	}
	@AfterTest()
	public void test8() {
		Reporter.log("after test",false);
		
	}
	@AfterSuite()
	public void test9() {
		Reporter.log("after suite",false);
		
	}
	
	
}

	