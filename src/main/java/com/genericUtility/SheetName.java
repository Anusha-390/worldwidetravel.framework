package com.genericUtility;
/**
 * This enum contains sheet name of the excel
 * @author Anusha M
 *
 */
 

public enum SheetName{
	   
	CREATETOURPACKAGEDATA("createTourPackageData"),USERTOURPACKAGEDATA("userTourPackageData"),CANCELTOURPACKAGEDATA("cancelTourPackageData"),ADMINMANAGEBOOKINGDATA("adminMangeBookingData");
	
	private String shtName;
	//setter(constructor)
	private SheetName( String stName) {
		this.shtName=stName;
	}
   //getter
	public String convertToString(){
		return shtName.toString();
		
	}

}
