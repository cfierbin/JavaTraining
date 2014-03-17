package observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TradingPanel extends JPanel implements PropertyChangeListener{

	private JLabel confirmOrder;
	
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		// get args from event object
		String property = event.getPropertyName();
	    String newValue = (String) event.getNewValue();
	    String oldValue = (String) event.getOldValue();
	    setConfirmOrder("Buy " + newValue + " stock");	
	}
	
	/**constructor registers this object as a listener to a StockPricesPanel;
	 * also creates and adds components to JPanel
	 * @param stockPricesPanel
	 */
	
    public TradingPanel(StockPricesPanel stockPricesPanel) {
        stockPricesPanel.addChangeListener(this);
        confirmOrder = new JLabel("Order confirmation");
        this.add(confirmOrder);
    }
    
    //no-arg constructor
    public TradingPanel() {
        confirmOrder = new JLabel("Order confirmation");
        this.add(confirmOrder);
    }

    //getters and setters
    
	public String getConfirmOrder() {
		return confirmOrder.getText();
	}

	public void setConfirmOrder(String confirmOrder) {
		this.confirmOrder.setText(confirmOrder);
	}

}
