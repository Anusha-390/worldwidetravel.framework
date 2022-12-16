package practice;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class fetchDataFromPropertyFile {
public static void main(String[] args) throws IOException {
	FileInputStream fis=new FileInputStream("./src/test/resources/pop.properties");
	Properties property=new Properties();
	property.load(fis);
	
	System.out.println(property.getProperty("url"));
}
}
