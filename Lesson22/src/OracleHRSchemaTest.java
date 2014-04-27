import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;


public class OracleHRSchemaTest implements Runnable {

	@Override
	public void run() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			//conn = DriverManager.getConnection("jdbc:oracle:thin:HR/hr@localhost:1521:xe");
			
			//connect using DataSource 			
			OracleDataSource ods = new OracleDataSource();
			ods.setDriverType("thin");
			ods.setServerName("localhost");
			ods.setNetworkProtocol("tcp");
			ods.setDatabaseName("xe");
			ods.setPortNumber(1521);
			ods.setUser("HR");
			ods.setPassword("hr");
			conn = ods.getConnection();
			
			String sqlQuery = "SELECT * FROM countries";
			stmt = conn.createStatement();
			//Execute SQL and get the ResultSet object
			rs = stmt.executeQuery(sqlQuery);
			
			//Process the result set
			while(rs.next()){
				String countryName = rs.getString("COUNTRY_NAME");
				System.out.println(countryName);
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
