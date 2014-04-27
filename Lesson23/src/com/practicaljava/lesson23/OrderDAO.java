package com.practicaljava.lesson23;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.pool.OracleDataSource;

public class OrderDAO {

	public static String getColumnName(int col) {
		// TODO Auto-generated method stub
		return null;
	}

	public static ArrayList<Order> getOrder() {
		
	ArrayList<Order> myData = new ArrayList<Order>();
		
	//create data source and get connection
		
	try{
		OracleDataSource ods;
		ods = new OracleDataSource();
		ods.setDriverType("thin");
		ods.setServerName("localhost");
		ods.setNetworkProtocol("tcp");
		ods.setDatabaseName("xe");
		ods.setPortNumber(1521);
		ods.setUser("HR");
		ods.setPassword("hr");
	//get connection	
		Connection conn = ods.getConnection();
		
		//Execute SQL SELECT and get the ResultSet object		
		String sqlQuery = "SELECT * FROM myportfolio";
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery);
			 ResultSet	rs = stmt.executeQuery();)
		{
					//Process the result set
					int count = 1;
					while(rs.next()){
						String symbol = rs.getString("symbol");
						String quantity = rs.getString("quantity");
						double price = rs.getDouble("price");
						double totalPrice = price * Double.valueOf(quantity);
						myData.add(new Order(count, symbol, Integer.parseInt(quantity), price));
						count++;
					}
					
		}catch (SQLException e) {
				System.out.println("SELECT failed. "+ e.getErrorCode() + e.getMessage());
		}
		
	} catch (SQLException e) {
		System.out.println(e.getMessage()+","+e.getErrorCode());	
}
		return myData;
	}
}
