package com.practicaljava.lesson23;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.pool.OracleDataSource;

public class OrderDAO {
	public static void createTable() {
		OracleDataSource ods;
		try {
			//create data source
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
			//if table MYPORTFOLIO does not exist, create it	
			//DatabaseMetaData example taken from http://content.hccfl.edu/pollock/AJava/DerbyDemo.htm

				String createTable = "CREATE TABLE myportfolio(" +
							"id NUMBER NOT NULL," +
							"symbol VARCHAR2(10) NOT NULL," +
							"quantity VARCHAR2(10) NOT NULL,"+
							"price NUMBER(10,3) NOT NULL, CONSTRAINT port_id_pk PRIMARY KEY(id))";

				DatabaseMetaData dbmd = conn.getMetaData();
				try (ResultSet rs = dbmd.getTables(null, null, "MYPORTFOLIO", null);
					PreparedStatement	stmt = conn.prepareStatement(createTable);){
							if(!rs.next())
							{
								System.out.println("Table does not exist. Creating table.");
								stmt.execute();				
							}
				}catch (SQLException e) {
					System.out.println("Table creation failed. "+ e.getErrorCode() + e.getMessage());
						}
						
				//populate table myportfolio
				String[] insertValues = new String[7];
				insertValues[0] = "INSERT INTO myportfolio VALUES (1,'IBM','500',189.63)";
				insertValues[1] = "INSERT INTO myportfolio VALUES (2,'AMZN','1000',15.25)";
				insertValues[2] = "INSERT INTO myportfolio VALUES (3,'AAPL','2000', 572.50)";
				insertValues[3] = "INSERT INTO myportfolio VALUES (4,'IBM','100',189.63)";
				insertValues[4] = "INSERT INTO myportfolio VALUES (5,'AAPL','300', 572.50)";
				insertValues[5] = "INSERT INTO myportfolio VALUES (6,'ORCL','500', 39.45)";
				insertValues[6] = "INSERT INTO myportfolio VALUES (7,'MSI','2000', 62.50)";
								
				for(int i=0; i<7; i++){
				try (PreparedStatement stmt = conn.prepareStatement(insertValues[i]);)
						{
							stmt.execute();
				}catch (SQLException e) {
					System.out.println("Insert failed. "+ e.getErrorCode() + e.getMessage());
						}
				}
						
				//Execute SQL SELECT and get the ResultSet object		
				String sqlQuery = "SELECT * FROM myportfolio";
				try (PreparedStatement stmt = conn.prepareStatement(sqlQuery);
					 ResultSet	rs = stmt.executeQuery();)
				{
							//Process the result set
							while(rs.next()){
								String symbol = rs.getString("symbol");
								String quantity = rs.getString("quantity");
								double price = rs.getDouble("price");
								double totalPrice = price * Double.valueOf(quantity);
								System.out.println(symbol + " quantity=" + quantity +
										" price=" + totalPrice);
							}
							
				}catch (SQLException e) {
						System.out.println("SELECT failed. "+ e.getErrorCode() + e.getMessage());
				}
/*									
				//drop table MYPORTFOLIO
				String dropTable = "DROP TABLE myportfolio";
				try (PreparedStatement stmt = conn.prepareStatement(dropTable);){
							stmt.execute();
				}catch (SQLException e) {
					System.out.println("Failed to drop table. "+ e.getErrorCode() + e.getMessage());
				}
*/
				
		} catch (SQLException e) {
				System.out.println(e.getMessage()+","+e.getErrorCode());	
		}
}

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
