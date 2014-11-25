package calculatorpieces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


public class SimpleCalculatorEngine implements EventHandler<ActionEvent> {
 
 SimpleCalculatorGridAndBorder parent; // a reference to the Calculator
	
 // Constructor stores the reference to the 
 // Calculator window in  the member variable parent
 SimpleCalculatorEngine(SimpleCalculatorGridAndBorder parent){
   this.parent = parent;
 }

@Override
public void handle(ActionEvent e) {
	   // Get the source of this action
	   Button clickedButton =  (Button) e.getSource();
	   	
	   // Get the existing text from the Calculator's
	   // display field. Reaching inside another object is bad.
	   String dispFieldText = parent.getDisplayValue();

	   // Get the button's label 
	   String clickedButtonLabel = clickedButton.getText();
	   	
	   parent.setDisplayValue(dispFieldText + 
	                                   clickedButtonLabel);
	
}
}

