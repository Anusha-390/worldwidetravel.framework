package com.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.Driver;
/**
 * This class is used handle the data Base
 * @author Anusha M
 *
 */

public class DatabaseUtility {
	private Connection con;
	
	/**
	 * This method is used to get data from data base
	 * @param query
	 * @param columnName
	 * @return
	 */
	public List<String> getDataFromDatabase(String query,String columnName)  {
		Statement state = null;
		try {
			state = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet result = null;
		try {
			result = state.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> list = new ArrayList<String>();
		try {
			while(result.next()) {
				list.add(result.getString(columnName));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list; 
	}

	/**
	 * This method is used to connect to Data base
	 * @param dbURL
	 * @param dbUserName
	 * @param dbPassword
	 */
	public void openDBConnection(String dbURL, String dbUserName, String dbPassword )  {
		Driver dbdriver = null;
		try {
			dbdriver = new Driver();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			DriverManager.registerDriver(dbdriver);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection(dbURL, dbUserName, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
	
	/**
	 * This method is used to close the data base
	 */
	public void closeDB()  {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to modify the data in data base
	 * @param query
	 */
	public void modifyDataIntoDB(String query)  {
		Statement state = null;
		try {
			state = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			state.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	/**
	 * This method is used to verify the data in dataBase
	 * @param query
	 * @param coloumName
	 * @param expectedData
	 * @return
	 */
	public boolean verifyDataInDatabase(String query,String coloumName,String expectedData ) {
		  List<String> list = getDataFromDatabase(query,coloumName );
		boolean flag = false;
		if(list.contains(expectedData))flag=true;
		return flag;
		  
		  
		  
		  
		  
	}
}
