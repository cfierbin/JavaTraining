package lesson13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OrderWindow extends JFrame implements ActionListener{
	
	private JComboBox bikeModelsCombo;
	private JTextField quantity;
	private JButton placeOrder;
	
	private JPanel container;
	
	private String bikeModel;
	
	private String[] bikeModels = {"Street 1", "Street 2", "Practical", "Classical", "Mini"};
	
	/**
	 * constructor creates panel and components, adds components to the panel
	 */
	
	public OrderWindow(){
		container = new JPanel();
		container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
		this.setContentPane(container);
		bikeModelsCombo = new JComboBox(bikeModels);
		bikeModelsCombo.addActionListener(this);
		quantity = new JTextField();
		placeOrder = new JButton("Place Order");
		container.add(bikeModelsCombo);
		container.add(quantity);
		container.add(placeOrder);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
        String bikeModel = (String)cb.getSelectedItem();
        this.bikeModel = bikeModel;		
	}

}
