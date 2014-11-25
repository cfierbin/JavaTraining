package reusablecalculatorcomponents;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class CalculatorEngine implements EventHandler<ActionEvent>{
	
	 private CalculatorPane parent; // a reference to the Calculator
	 
	 private String firstNumber; 
	 private String operator; // selected action 
	 private double result;
	 private String previouslyPressedButton = "";
		
	 // Constructor stores the reference to the 
	 // Calculator window in  the member variable parent
	 CalculatorEngine(CalculatorPane parent){
	   this.parent = parent;
	 }

	@Override
	public void handle(ActionEvent e) {
		   // Get the source of this action
		   Button clickedButton =  (Button) e.getSource();
			
		   switch(clickedButton.getText()){
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
			case "0":
			case ".":
				previouslyPressedButton = clickedButton.getText();
				displayDigit(clickedButton);
				break;
			case "+":
			case "-":
			case "/":
			case "*":
			case "%":
					// Store the first number and the operator in corresponding variables
				firstNumber = parent.getDisplayValue();
				operator = clickedButton.getText();
				previouslyPressedButton = operator;
					// Erase the number from the display
				parent.setDisplayValue("");		
				break;
			case "=":
				
					// do nothing if previously pressed button was the equal sign, 
					// a unary operator or dot
				if ("=".equals(previouslyPressedButton) ||
					"sqrt".equals(previouslyPressedButton) ||
					"+/-".equals(previouslyPressedButton) ||
					"1/x".equals(previouslyPressedButton) ||
					"C".equals(previouslyPressedButton) || 
					"Backspace".equals(previouslyPressedButton) ||
					".".equals(previouslyPressedButton)) break; 
						
				try{
					// Perform the selected action
					if ("+".equals(operator)) {
						result = Double.parseDouble(parent.getDisplayValue()) + Double.parseDouble(firstNumber);
					}
					if ("-".equals(operator)) {
						result = Double.parseDouble(firstNumber) - Double.parseDouble(parent.getDisplayValue());
					}
					if ("*".equals(operator)) {
						result = Double.parseDouble(firstNumber) * Double.parseDouble(parent.getDisplayValue());
					}
					if ("/".equals(operator)) {
						//validate input
						if (Double.parseDouble(parent.getDisplayValue()) == 0){
						// Display error message in red if user attempts to divide by zero
							parent.setDisplayValue("You cannot divide by zero!", "red");
							break;
						}
						else
							result = Double.parseDouble(firstNumber) / Double.parseDouble(parent.getDisplayValue());
					}
					if ("%".equals(operator)) {
						result = Double.parseDouble(firstNumber) % Double.parseDouble(parent.getDisplayValue());
					}
				}
				catch(NumberFormatException exception){
					parent.setDisplayValue("Operand is not a number!", "red");
					break;
				}

					// Store the result in firstNumber
				firstNumber = String.valueOf(result);
					// Display the result
				parent.setDisplayValue(firstNumber);
				previouslyPressedButton = "=";
				break;
			
			case "C":
				// erase the number or message from the display
				parent.setDisplayValue("");
				previouslyPressedButton = clickedButton.getText();
				break;
				
			case "sqrt":
				//store result in firstNumber
				firstNumber = String.valueOf(Math.sqrt(Double.parseDouble(parent.getDisplayValue())));
				//display the result
				parent.setDisplayValue(firstNumber);
				previouslyPressedButton = clickedButton.getText();
				break;
				
			case "1/x":
				if (Double.parseDouble(parent.getDisplayValue()) == 0){
					// Display error message in red if user attempts to divide by zero
					parent.setDisplayValue("You cannot divide by zero!", "red");
					previouslyPressedButton = clickedButton.getText();
					break;
				}
				else{
					//store result in firstNumber
					firstNumber = String.valueOf(1/(Double.parseDouble(parent.getDisplayValue())));
					//display the result
					parent.setDisplayValue(firstNumber);
				}
				previouslyPressedButton = clickedButton.getText();
				break;
				
			case "+/-":
				//store result in firstNumber
				firstNumber = String.valueOf(0.0-(Double.parseDouble(parent.getDisplayValue())));
				//display the result
				parent.setDisplayValue(firstNumber);
				previouslyPressedButton = clickedButton.getText();
				break;
				
			case "Backspace":
				if((parent.getDisplayValue().length()) != 0) {
					parent.setDisplayValue(parent.getDisplayValue().substring(0,parent.getDisplayValue().length()-1));
				}
				previouslyPressedButton = clickedButton.getText();
				break;
			
			default:
			parent.setDisplayValue("Undefined action");
			}
		
	}

		public void displayDigit(Button clickedButton){
			
				// Get the existing text from the Calculator's display field
			String dispFieldText = parent.getDisplayValue();
			
				// Get the button's label
			String clickedButtonLabel = clickedButton.getText();
			
			parent.setDisplayValue(dispFieldText + clickedButtonLabel);
	}

}
