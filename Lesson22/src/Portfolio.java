import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Portfolio implements Runnable {

	@Override
	public void run() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			//conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Lesson22");
			
			//connect using DataSource 
			org.apache.derby.jdbc.ClientDataSource ds = new org.apache.derby.jdbc.ClientDataSource();
			ds.setServerName("localhost");
			ds.setDatabaseName("Lesson22");
			ds.setDescription("Sample database for Lesson 22");
			
			conn = ds.getConnection();
					
			String sqlQuery = "SELECT * FROM PORTFOLIO";
			stmt = conn.createStatement();
			//Execute SQL and get the ResultSet object
			rs = stmt.executeQuery(sqlQuery);
			
			//Process the result set
			while(rs.next()){
				String symbol = rs.getString("SYMBOL");
				String quantity = rs.getString("QUANTITY");
				double price = rs.getDouble("PRICE");
				double totalPrice = price * Double.valueOf(quantity);
				System.out.println(symbol + " quantity=" + quantity +
						" price=" + totalPrice);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try{
				rs.close();
				stmt.close();
				conn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}

	}

}
