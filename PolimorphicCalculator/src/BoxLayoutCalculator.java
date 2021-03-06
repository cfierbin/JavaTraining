import java.awt.Dimension;

import javax.swing.BoxLayout;


public class BoxLayoutCalculator extends Calculator{
	
	final static int initialFrameSizeX = 250;
	final static int inistialFrameSizeY = 310;
	final static int displayFieldPreferredX = 200;
	final static int displayFieldPreferredY = 20;
	
	public BoxLayoutCalculator(){
			
			//constructor of the superclass creates the components
			//registers them with listeners 
			//and adds them to the frame
			super();
			
			//set layout manager for panel
			BoxLayout boxLayout = new BoxLayout(windowContent, BoxLayout.Y_AXIS);
			
			displayField.setPreferredSize(new Dimension(displayFieldPreferredX,displayFieldPreferredY));
			
			//set the size of the frame big enough to accomodate all controls
			frame.pack(); 
			
			//display the window
			frame.setSize(new Dimension(initialFrameSizeX, inistialFrameSizeY));
			frame.setVisible(true);
	}
}
