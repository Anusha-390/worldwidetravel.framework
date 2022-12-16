package com.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class is used to handle the property file
 * @author Anusha M
 *
 */
public class GetDataFromPropertyFile {
	private FileInputStream fis;
	 private    Properties property;
	/**
	 * This method is used to fetch data from property file
	 * @param propertyFilePath
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public void openPropertyFile(String propertyFilePath){
		try {
			fis=new FileInputStream(propertyFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getDataPropertyFile(String key){
	 
	String value=property.getProperty(key);
	return value;
	}

/**
 * This method is used to close the property file
 */
public void closePropertyFile()
{
try {
	fis.close();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}