
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Portfolio implements Runnable {

	@Override
	public void run() {			
		//conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Lesson22");
			
		//connect using DataSource 
		org.apache.derby.jdbc.ClientDataSource ds = new org.apache.derby.jdbc.ClientDataSource();
		ds.setServerName("localhost");
		ds.setDatabaseName("Lesson22");
		ds.setDescription("Sample database for Lesson 22");
			
		try (Connection conn = ds.getConnection();){
				
		//if table MYPORTFOLIO does not exist, create it	
		//DatabaseMetaData example taken from http://content.hccfl.edu/pollock/AJava/DerbyDemo.htm
		
		String createTable = "CREATE TABLE myportfolio(" +
					"id INT NOT NULL," +
					"symbol VARCHAR(10) NOT NULL," +
					"quantity VARCHAR(10) NOT NULL,"+
					"price DOUBLE NOT NULL, PRIMARY KEY(id))";
		
		DatabaseMetaData dbmd = conn.getMetaData();
		try (ResultSet rs = dbmd.getTables(null, null, "MYPORTFOLIO", null);
			PreparedStatement	stmt = conn.prepareStatement(createTable);){
					if(!rs.next())
					{
						System.out.println("Table does not exist. Creating table.");
						stmt.execute();				
					}
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				//	e.printStackTrace();
			System.out.println("Table creation failed");
				}
				
		//populate table myportfolio
		String insertValues = "INSERT INTO myportfolio VALUES " +
									"(1,'IBM','500',105.50)," +
									"(2,'AMZN','1000',15.25)," +
									"(3,'AAPL','2000', 272.50)";
		try (PreparedStatement stmt = conn.prepareStatement(insertValues);)
				{
					stmt.execute();
		}catch (SQLException e) {
			System.out.println("Insert failed");
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
				System.out.println("SELECT failed");
		}
							
		//drop table MYPORTFOLIO
		String dropTable = "DROP TABLE myportfolio";
		try (PreparedStatement stmt = conn.prepareStatement(dropTable);){
					stmt.execute();
		}catch (SQLException e) {
			System.out.println("Failed to drop table.");
		}
				
} catch (SQLException e) {
	System.out.println("Failed to open data source.");
	}
			
}

}
