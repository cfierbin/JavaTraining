package calculatormain;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class CalculatorPane extends StackPane {
	
	// Declare all calculator's components.
	protected TextField displayField;
	protected Button button0;
	protected Button button1;
	protected Button button2;
	protected Button button3;
	protected Button button4;
	protected Button button5;
	protected Button button6;
	protected Button button7;
	protected Button button8;
	protected Button button9;
	protected Button buttonPoint;
	protected Button buttonEqual;
	protected Button buttonPlus;
	protected Button buttonMinus;
	protected Button buttonMult;
	protected Button buttonDiv;
	
	protected Button buttonSQRT;
	protected Button buttonMOD;
	protected Button buttonINV;
	protected Button buttonOPP;
	
	protected Button buttonBackspace;
	protected Button buttonCE;
	protected Button buttonC;
	
	protected Button buttonMC;
	protected Button buttonMR;
	protected Button buttonMS;
	protected Button buttonMPlus;
	
	// Constructor
	public CalculatorPane(){
		super();
	}
	
	// Define getter and overloaded setters for the display field
	
	   public String getDisplayValue() {
	        return displayField.getText();
	    }
	
	   public void setDisplayValue(String val){
		   String textColor = "  -fx-text-fill: black";
		   displayField.setStyle(textColor);
		   displayField.setText(val);
	   }
    
	   public void setDisplayValue(String val, String color){
		   String textColor = "  -fx-text-fill: " + color;
		   displayField.setStyle(textColor);
		   displayField.setText(val);
	   }

}
