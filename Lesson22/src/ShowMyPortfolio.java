
public class ShowMyPortfolio {
	
	public static void main(String[] args){
	
		Portfolio myPortfolio = new Portfolio();
		Thread p = new Thread(myPortfolio, "Portfolio Data");
		p.start();
		
	/*uses Oracle Database 11g Express Edition
		OracleHRSchemaDAO hr = new OracleHRSchemaDAO();
		Thread o = new Thread(hr, "Country Data");
		o.start();
	*/
		
	}
}
