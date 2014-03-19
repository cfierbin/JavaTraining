package lesson13;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class OrderWindow extends JFrame implements ActionListener{
	
	private JComboBox bikeModelsCombo;
	private JTextField quantity;
	private JButton placeOrder;
	
	private JLabel bikeModelsLabel;
	private JLabel quantityLabel;
	
	private JPanel container, panel1, panel2;
	
	private String bikeModel = "Street 1";
	
	private String[] bikeModels = {"Street 1",  "Mini", "Street 2", "Practical", "Classical"};
	private ImageIcon[] images;
	private JLabel bikeImage;
	private JLabel txtResult;
	
	/**
	 * constructor creates panel and components, adds components to the panel
	 */
	
	public OrderWindow(){
		
		container = new JPanel();
//		container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
		this.setContentPane(container);
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		bikeModelsCombo = new JComboBox(bikeModels);
		
        images = new ImageIcon[bikeModels.length];
        for (int i = 0; i < bikeModels.length; i++) {
  //          images[i] = new ImageIcon("D:\\JavaTraining\\Unit7\\Images\\bike" + i + ".jpg");
            images[i] = new ImageIcon("./Images/bike" + i + ".jpg");
        }
		
		bikeModelsCombo.addActionListener(this);
		quantity = new JTextField("1");
		quantity.setPreferredSize(new Dimension(100,20));
		quantity.setHorizontalAlignment(JTextField.RIGHT);
		placeOrder = new JButton("Place Order");
		placeOrder.addActionListener(this);
		bikeModelsLabel = new JLabel("Bike model: ");
		quantityLabel = new JLabel("Quantity: ");
		bikeImage = new JLabel();
		
		txtResult = new JLabel("<html>Choose model and quantity. "
				+ "<br> Can ship at most 100 \"Mini\"s <br> "
				+ "or at most 90 pieces <br> of any other model.</html>");
		
	//	ImageIcon icon1 = new ImageIcon("D:\\JavaTraining\\Unit7\\Images\\bike0.jpg"); 
		ImageIcon icon1 = new ImageIcon("./Images/bike0.jpg");
		bikeImage.setIcon(icon1);

		panel1.add(bikeModelsLabel);
		panel1.add(bikeModelsCombo);
		panel2.add(quantityLabel);
		panel2.add(quantity);
		container.add(panel1);
		container.add(panel2);
		container.add(bikeImage);
		container.add(txtResult);
		container.add(placeOrder);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JComboBox){
			JComboBox cb = (JComboBox)e.getSource();
			String bikeModel = (String)cb.getSelectedItem();
			int index = cb.getSelectedIndex();
			this.bikeModel = bikeModel;
			bikeImage.setIcon(images[index]);
		}
		else {
			//the user clicked on the "Validate Order" button
			try{
				BikeOrder.validateOrder(bikeModel, Integer.parseInt(quantity.getText()));
				displayMessage(txtResult,"The order is valid.",Color.BLACK);
			}
			catch(TooManyBikesException exception){
				displayMessage(txtResult,exception.getMessage(),Color.RED);
			}
			catch(NumberFormatException exception){
				displayMessage(txtResult,"Please input desired quantity",Color.RED);
			}
	}
	}

	private void displayMessage(JLabel label, String message, Color color) {
		label.setForeground(color);
		label.setText(message);
	}

}
