package com.genericUtility;


import java.util.Date;
import java.util.Random;

/**
 * This class is used to handle the java Utility file
 * @author Anusha M
 *
 */
public class JavaUtility {
	/**
	 * its used to generate random number
	 * @return int data
	 */

    public int getRanDomNumber() {
    	Random random=new Random();
    	int intRandom= random.nextInt(10000);
    	return intRandom;
    	}
    /**
     * used to get system date and time in IST format
     * @return
     */
    public String getSystemDateAndTime() {
    	Date date =new Date();
    	 return date.toString();
    }
    /**
     * used to get system date in YYYY-MM-DD format
     * @return
     */
    public String getSystemDateWithFormate() {
       Date date=new Date();
       String dateAndTime=date.toString();
    	String YYYY=dateAndTime.split(" ")[5];
    	String DD=dateAndTime.split(" ")[2];
    	@SuppressWarnings("deprecation")
		int MM=date.getMonth()+1;
    	String finalFormate=YYYY+"-"+MM+"-"+DD;
    	
    	return finalFormate;
    			
    }
}
