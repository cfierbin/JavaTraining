
public class ShowMyPortfolio {
	public static void main(String[] args){
		Portfolio myPortfolio = new Portfolio();
		Thread p = new Thread(myPortfolio, "Portfolio Data");
		p.start();
	}
}
