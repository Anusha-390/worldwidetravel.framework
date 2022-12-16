package com.practice.TestNgFrameWork;

import org.testng.annotations.Test;

public class TestNG3 {
	
	@Test(groups= {"smokeTest"})
	public void test1() {
		System.out.println(" test1 is executed");
	}
	@Test(groups= {"regressionTest"})
	public void test2() {
		System.out.println("test2 is executed");
	}
	
	

}
