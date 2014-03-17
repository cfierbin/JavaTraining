package observer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StockPricesPanel extends JPanel {
	
	//formatting constants
	private static final java.text.SimpleDateFormat SDF = new java.text.SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	
      //this JPanel is observable
	  private List<PropertyChangeListener> listener = new ArrayList<PropertyChangeListener>();
	
	  public void addChangeListener(PropertyChangeListener newListener) {
		    listener.add(newListener);
		  }
	  
	  private void notifyListeners(Object object, String property, String oldValue, String newValue) {
		    for (PropertyChangeListener name : listener) {
		      name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
		    }
		  }
	  
	  //panel components
	  private JLabel stockSymbol;
	  private JLabel price;
	  private JLabel date;
	  
	  private JButton buyButton;
	  
	  /**
	   * constructor adds mouse listener which notifies observers of this object;
	   * also create and add components to JPanel
	   */
	  public StockPricesPanel(){
		  buyButton = new JButton("Buy");
	       buyButton.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e)
					{
					notifyListeners(this, "stockSymbol", "", stockSymbol.getText());
					}	
				}
		  );
	       stockSymbol = new JLabel("Stock Symbol");
	       price = new JLabel("Price");
	       date = new JLabel((SDF.format(new Date())));
	       this.add(stockSymbol);
	       this.add(price);
	       this.add(date);
	       this.add(buyButton);
	  }
	  
	//getters and setters

	public String getStockSymbol() {
		return stockSymbol.getText();
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol.setText(stockSymbol);
	}

	public String getPrice() {
		return price.getText();
	}

	public void setPrice(String price) {
		this.price.setText(price);
	}

	public String getDate() {
		return date.getText();
	}

	public void setDate(String date) {
		this.date.setText(date);
	}

}
