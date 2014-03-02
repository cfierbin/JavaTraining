import java.awt.Dimension;

import javax.swing.BoxLayout;


public class BoxLayoutCalculator extends Calculator{
	
	public BoxLayoutCalculator(){
			
			//constructor of the superclass creates the components
			//registers them with listeners 
			//and adds them to the frame
			super();
			
			//set layout manager for panel
			BoxLayout boxLayout = new BoxLayout(windowContent, BoxLayout.Y_AXIS);
			
			displayField.setPreferredSize(new Dimension(200,20));
			
			//set the size of the frame big enough to accomodate all controls
			frame.pack(); 
			
			//display the window
			frame.setSize(new Dimension(250,310));
			frame.setVisible(true);
	}
}
