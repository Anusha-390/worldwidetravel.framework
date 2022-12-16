package com.practice.TestNgFrameWork;

import org.testng.annotations.Test;

public class TestngGroupExecution {

	@Test(groups= "smokeTest")
	public void groupTest1() {
		System.out.println("groupTest1 is executed");
	}

	@Test (groups="regression")
	public void groupTest2() {
		System.out.println("groupTest2 is executed");
	}
    
}
