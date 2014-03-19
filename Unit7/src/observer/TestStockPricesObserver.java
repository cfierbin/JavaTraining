package observer;

import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class TestStockPricesObserver {
	
	private static enum StockSymbol {AAPL, ORCL, IBM, AMZN, FB, MSFT, MSI}
	
	private static StockSymbol symbol;
	private static int price;
	
    private static java.util.Random randomInstance = new java.util.Random();
    
	static private void getMarketNews() {
		symbol = StockSymbol.values()[getRandomSymbol()];	
		price = getRandomPrice();
	}
	
	static private int getRandomPrice() {
		return randomInstance.nextInt(100);		
	}
	
	static private int getRandomSymbol() {
		return randomInstance.nextInt(7);	
	}

	public static void main(String[] args) {
		//create timer
		java.util.Timer timer = new java.util.Timer();
		
		// create frames
		JFrame frame1 = new JFrame("Stock Prices Panel");
		JFrame frame2 = new JFrame("Trading Panel");
		
		// create a StockPricesPanel
		final StockPricesPanel stockPricesPanel = new StockPricesPanel();
		// add layout to StockPricesPanel
		stockPricesPanel.setLayout(new BoxLayout(stockPricesPanel,BoxLayout.Y_AXIS));
		// add StockPricesPanel to JFrame
		frame1.setContentPane(stockPricesPanel);
		//set frame properties
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setLocation(200, 200);
		frame1.setSize(250,200);
		// show window
		frame1.setVisible(true);
		
		// create a TradingPanel observing stockPricesPanel
		TradingPanel tradingPanel = new TradingPanel(stockPricesPanel);
		// add TradingPanel to its JFrame
		frame2.setContentPane(tradingPanel);
		// show TradingPanel window
		frame2.setLocation(500, 200);
		frame2.setSize(250,100);
		frame2.setVisible(true);
				
        //generate stock symbols and prices
		int delay = 0;
		int period = randomInstance.nextInt(10000);
		
		timer.schedule(new TimerTask() {

            @Override
            public void run() {
            	TestStockPricesObserver.getMarketNews();
            	stockPricesPanel.setStockSymbol(String.valueOf(symbol));
            	stockPricesPanel.setPrice(String.valueOf(price));
            }

        }, delay, period);
		

    }

	}


