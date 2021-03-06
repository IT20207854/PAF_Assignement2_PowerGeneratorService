package com;

import java.sql.*;


public class PowerGenerator {
	
	//DB connection
	private Connection connect() 
	{ 
		Connection con = null; 
		try
		{ 
			Class.forName("com.mysql.jdbc.Driver"); 
				 
			//Provide the correct details: DBServer/DBName, username, password 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paf", "root", ""); 
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		return con; 
	} 
		
	//insert
	public String addPowerGenerator(String gCode, String gName, String gType, String gLocation, String gUnitPrice, String gRegDate) 
	{ 
		String output = ""; 
		try
		{ 
			Connection con = connect(); 
			if (con == null) 
			{ 
				return "Error while connecting to the database for inserting."; 
			} 
			 
			// create a prepared statement
			String query = " insert into powergenerators (`gID`,`gCode`,`gName`,`gType`,`gLocation`, `gUnitPrice`, gRegDate)" + " values (?, ?, ?, ?, ?, ?, ?)"; 
			
			PreparedStatement preparedStmt = con.prepareStatement(query); 
			// binding values
			preparedStmt.setInt(1, 0); 
			preparedStmt.setString(2, gCode); 
			preparedStmt.setString(3, gName); 
			preparedStmt.setString(4, gType); 
			preparedStmt.setString(5, gLocation); 
			preparedStmt.setDouble(6, Double.parseDouble(gUnitPrice)); 
			//java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
			//preparedStmt.setDate(7, sqlDate);
			preparedStmt.setString(7, gRegDate); 
			
			// execute the statement
			preparedStmt.execute(); 
			con.close(); 
			String newPowerGenerators = readPowerGenerators(); 
			output = "{\"status\":\"success\", \"data\": \"" + newPowerGenerators + "\"}"; 
		} 
		catch (Exception e) 
		{ 
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the power generator.\"}"; 
			System.err.println(e.getMessage()); 
		} 
		
		return output; 
} 
	
	
	//read all
	public String readPowerGenerators() 
	{ 
		 String output = ""; 
			try
			 { 
				Connection con = connect(); 
				 if (con == null) 
				 { 
					 return "Error while connecting to the database for reading."; 
				 } 
				 // Prepare the html table to be displayed
				 output = "<table><tr><th>Power Generator Code</th>" 
				 + "<th>Power Generator Name</th><th>Type</th>"
				 + "<th>Location</th>><th>Unit Price</th>" 
				 + "<th>Registered Date</th>"
				 + "<th>Update</th><th>Remove</th></tr>"; 
				 String query = "select * from powergenerators"; 
				 Statement stmt = con.createStatement(); 
				 ResultSet rs = stmt.executeQuery(query); 
				 // iterate through the rows in the result set
				 while (rs.next()) 
				 { 
					 String gID = Integer.toString(rs.getInt("gID")); 
					 String gCode = rs.getString("gCode"); 
					 String gName = rs.getString("gName"); 
					 String gType = rs.getString("gType");
					 String gLocation = rs.getString("gLocation");
					 String gUnitPrice = Double.toString(rs.getDouble("gUnitPrice")); 
					 String gRegDate = rs.getString("gRegDate");
					 
					// Add into the html table
					 output += "<tr><td>" + gCode + "</td>"; 
					 output += "<td>" + gName + "</td>"; 
					 output += "<td>" + gType + "</td>"; 
					 output += "<td>" + gLocation + "</td>"; 
					 output += "<td>" + gUnitPrice + "</td>"; 
					 output += "<td>" + gRegDate + "</td>";
					
					 // buttons
					output += "<td><input name='btnUpdate' type='button' value='Update' "
					+ "class='btnUpdate btn btn-secondary' data-gid='" + gID + "'></td>"
					+ "<td><input name='btnRemove' type='button' value='Remove' "
					+ "class='btnRemove btn btn-danger' data-gid='" + gID + "'></td></tr>"; 
				} 
				 con.close(); 
				 // Complete the html table
				 output += "</table>"; 
			 } 
		catch (Exception e) 
		 { 
		 output = "Error while reading the power generators."; 
		 System.err.println(e.getMessage()); 
		 } 
		return output; 
	}
	
	
	/*//read
	public String getPowerGenerator(String gName) 
	 { 
		 String output = ""; 
		 try
		 { 
			 Connection con = connect(); 
				 if (con == null) 
				 {
					 return "Error while connecting to the database for reading."; 
				 } 
			 // Prepare the html table to be displayed
			 output = "<table border='1'><tr><th>Power Generator ID</th><th>Power Generator Code</th>" +
			 "<th>Power Generator Name</th>"+
			 "<th>Power Generator Type</th>" + 
			 "<th>Power Generator Location</th>" +
			 "<th>Unit Price</th>" +
			 "<th>Registered Date/Modified Date</th></tr>"; 
			 
			// create a prepared statement
			 String query = "select * from powergenerators where gName=?"; 
			 PreparedStatement preparedStmt = con.prepareStatement(query); 
			 // binding values
			 preparedStmt.setString(1, gName); 
			 // execute the statement
			 preparedStmt.execute(); 
			
			 String gID = Integer.toString(((ResultSet) preparedStmt).getInt("gID")); 
			 String gCode = ((ResultSet) preparedStmt).getString("gCode"); 
			 String gType = ((ResultSet) preparedStmt).getString("gType");
			 String gLocation = ((ResultSet) preparedStmt).getString("gLocation");
			 String gUnitPrice = Double.toString(((ResultSet) preparedStmt).getDouble("gUnitPrice")); 
			 String gRegDate = ((ResultSet) preparedStmt).getString("gRegDate");
			 
			 // Add into the html table
			 output += "<tr><td>" + gID + "</td>"; 
			 output += "<td>" + gCode + "</td>"; 
			 output += "<td>" + gName + "</td>"; 
			 output += "<td>" + gType + "</td>"; 
			 output += "<td>" + gLocation + "</td>"; 
			 output += "<td>" + gUnitPrice + "</td>"; 
			 output += "<td>" + gRegDate + "</td></tr>";
			 con.close(); 
			 // Complete the html table
			 output += "</table>"; 
		 }
		 catch (Exception e) 
		 { 
		 output = "Error while getting the power generator details."; 
		 System.err.println(e.getMessage()); 
		 } 
		 return output; 
	 }*/
	
	
	//delete
	public String deletePowerGenerator(String gID) 
	{ 
		String output = ""; 
		try
		{ 
			Connection con = connect(); 
			if (con == null) 
			{ 
				return "Error while connecting to the database for deleting."; 
			} 
			// create a prepared statement
			String query = "delete from powergenerators where gID=?"; 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
			
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(gID)); 
			
			// execute the statement
			preparedStmt.execute(); 
			con.close(); 
			String newPowerGenerators = readPowerGenerators(); 
			output = "{\"status\":\"success\", \"data\": \"" + newPowerGenerators + "\"}"; 
		} 
		catch (Exception e) 
		{ 
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the power generator.\"}"; 
			System.err.println(e.getMessage()); 		} 
	 
		return output; 
	} 
	
	
	//update
	public String updatePowerGenerator(String ID, String code, String name, String type, String location, String unitPrice, String regDate) 
	{ 
		String output = ""; 
		try
		{ 
			Connection con = connect(); 
			if (con == null) 
			{
				return "Error while connecting to the database for updating."; 
			} 
			 // create a prepared statement
			 String query = "UPDATE powergenerators SET gCode=?, gName=?, gType=?, gLocation=?, gUnitPrice=?, gRegDate=? WHERE gID=?"; 
			 PreparedStatement preparedStmt = con.prepareStatement(query); 
			 // binding values
			 preparedStmt.setString(1, code); 
			 preparedStmt.setString(2, name); 
			 preparedStmt.setString(3, type); 
			 preparedStmt.setString(4, location); 
			 preparedStmt.setDouble(5, Double.parseDouble(unitPrice)); 
			 preparedStmt.setString(6, regDate);
			 preparedStmt.setInt(7, Integer.parseInt(ID)); 
			 
			 // execute the statement
			 preparedStmt.execute(); 
			 con.close(); 
			 String newPowerGenerators = readPowerGenerators(); 
			 output = "{\"status\":\"success\", \"data\": \"" + newPowerGenerators + "\"}"; 
	 } 
	 catch (Exception e) 
	 { 
		 output = "{\"status\":\"error\", \"data\": \"Error while updating the power generator.\"}"; 
		 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 }

	
	
	/*public String login(String username, String password) {
		String output = null;
		try
		{
			Connection con = connect();
			if (con == null) 
			{
				return "Error while connecting to the database";
			}
			 // create a prepared statement
			
			
			 String query = "select password from users where username=? and password=?"; 
			 PreparedStatement preparedStmt =  con.prepareStatement(query);
			 
			 // binding values
			 preparedStmt.setString(1, username); 
			 preparedStmt.setString(2, password); 
			
			 output =  "Login success";
			
			 con.close();
		}
		catch (Exception e) 
		{
			output = "Error in login function"; 
			System.err.println(e.getMessage()); 
		}
			
		return output;
	}*/

}
