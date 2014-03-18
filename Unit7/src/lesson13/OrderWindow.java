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

public class OrderWindow extends JFrame implements ActionListener{
	
	private JComboBox bikeModelsCombo;
	private JTextField quantity;
	private JButton placeOrder;
	
	private JLabel bikeModelsLabel;
	private JLabel quantityLabel;
	
	private JPanel container, panel1, panel2;
	
	private String bikeModel;
	
	private String[] bikeModels = {"Street 1",  "Mini", "Street 2", "Practical", "Classical"};
	private ImageIcon[] images;
	private JLabel bikeImage;
	
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
            images[i] = new ImageIcon("D:\\JavaTraining\\Unit7\\Images\\bike" + i + ".jpg");
        }
		
		bikeModelsCombo.addActionListener(this);
		quantity = new JTextField("                     ");
		placeOrder = new JButton("Place Order");
		bikeModelsLabel = new JLabel("Bike model: ");
		quantityLabel = new JLabel("Quantity: ");
		bikeImage = new JLabel();
		
		ImageIcon icon1 = new ImageIcon("D:\\JavaTraining\\Unit7\\Images\\bike0.jpg"); 
		bikeImage.setIcon(icon1);

		panel1.add(bikeModelsLabel);
		panel1.add(bikeModelsCombo);
		panel2.add(quantityLabel);
		panel2.add(quantity);
		container.add(panel1);
		container.add(panel2);
		container.add(bikeImage);
		container.add(placeOrder);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
        String bikeModel = (String)cb.getSelectedItem();
        int index = cb.getSelectedIndex();
        this.bikeModel = bikeModel;
		bikeImage.setIcon(images[index]);
	}

}
