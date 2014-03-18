package lesson13;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class TestTooManyBikesException {

	public static void main(String[] args) {
		
		// create an instance of OrderWindow		
		OrderWindow myOrder = new OrderWindow();
		myOrder.setTitle("Pegas Bicycles");
		myOrder.setSize(new Dimension(350,310));
		myOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myOrder.setResizable(false);
//		myOrder.pack();
		myOrder.setVisible(true);

	}

}
