package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDatabase {
	public static void main(String[] args) throws SQLException {
		String mobile_name="galaxyj2";
		int mobile_price=12345;
		String mobile_brand="samsung";
		Driver dbdriver=new Driver();
		DriverManager.registerDriver(dbdriver);
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/anusha", "root", "root");
		try {
		Statement statement=connection.createStatement();
		String query="select * from mobilephone;";
		
		ResultSet result=statement.executeQuery(query);
		List<String> list=new ArrayList<String>();
		while(result.next()) {
			list.add(result.getString("mobile_name").toLowerCase()+" || "+result.getInt("mobile_price")+" || "+result.getString("mobile_brand").toLowerCase());
		}
		if(list.contains(mobile_name.toLowerCase()+" || "+mobile_price+" || "+mobile_brand.toLowerCase()))
		{
			System.out.println("Data already existed");
		}
		else {
			
			statement.executeUpdate("insert into mobilephone values('"+mobile_name+"','"+mobile_price+"', '"+mobile_brand+"');");
			System.out.println("Data updated successfully");		 
		     }
		
		
		}
		finally{
			connection.close();
			System.out.println("connection closed successfully");
		}
		{
			
		}

}
}
