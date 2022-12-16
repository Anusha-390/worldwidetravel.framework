package com.practice.TestNgFrameWork;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG2 {
	
	@Test(dataProvider="getData")
	public void test1(String cityname,int pincode)
	{
		System.out.println("city name---"+cityname+" pincode---"+pincode+"");
		System.out.println();
}
	@DataProvider
	public Object[][] getData(){
		Object[][]arr=new Object[3][2];
				
		arr[0][0]="banglore";
		arr[0][1]=012345;
			
		arr[1][0]="mysore";
		arr[1][1]=567896;
		
		arr[2][0]="chitradurga";
		arr[2][1]=577544;
		return arr;
		   
			
	}
	
}