
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;


public class CalculatorEngine implements ActionListener{

	Calculator parent;
	
	String firstNumber, operator, secondNumber;
	double result;
	
	CalculatorEngine(Calculator parent){
		this.parent = parent;
	}
	
	
	public void displayDigit(JButton clickedButton){
		String dispFieldText = parent.getDisplayFieldValue();
		String clickedButtonLabel = clickedButton.getText();
		parent.setDisplayFieldValue(dispFieldText + clickedButtonLabel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//get the source of this action
		JButton clickedButton = (JButton) e.getSource();
		
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
			displayDigit(clickedButton);
			break;
		case "+":
		case "-":
		case "/":
		case "*":
			// store first number and operator in corresponding variables
			firstNumber = parent.getDisplayFieldValue();
			operator = clickedButton.getText();
			// erase the number from the display
			parent.setDisplayFieldValue("");
			//print info on system console
			System.out.println("The first number is: " + firstNumber);
			System.out.println("The operation required is: " + operator);
			break;
		case "=":
			//print info on system console
			System.out.println("The second number is: " + parent.getDisplayFieldValue());
			System.out.println("The operation required is " + operator);
			
			//perform the selected action
			try {	
				if ("+".equals(operator)) {
					result = Double.parseDouble(parent.getDisplayFieldValue()) + Double.parseDouble(firstNumber);
				}
				if ("-".equals(operator)) {
					result =  Double.parseDouble(firstNumber) - Double.parseDouble(parent.getDisplayFieldValue());
				}
				if ("*".equals(operator)) {
					result =  Double.parseDouble(firstNumber) * Double.parseDouble(parent.getDisplayFieldValue());
				}
				if ("/".equals(operator)) {
					result =  Double.parseDouble(firstNumber) / Double.parseDouble(parent.getDisplayFieldValue());
				}
			}
			catch(Exception exception){
					JOptionPane.showMessageDialog(null, "An exception occured!", "Exception", JOptionPane.ERROR_MESSAGE);	
				}			
			//store result in firstNumber
			firstNumber = String.valueOf(result);
			//display the result
			parent.setDisplayFieldValue(firstNumber);
			break;
		case "Backspace":
			JOptionPane.showMessageDialog(null, "Not yet implemented!", "Not implemented!", JOptionPane.INFORMATION_MESSAGE);
			break;
		case "CE":
			JOptionPane.showMessageDialog(null, "Not yet implemented!", "Not implemented!", JOptionPane.INFORMATION_MESSAGE);
			break;
		case "C":
			JOptionPane.showMessageDialog(null, "Not yet implemented!", "Not implemented!", JOptionPane.INFORMATION_MESSAGE);
			break;
		case "MC":
			JOptionPane.showMessageDialog(null, "Not yet implemented!", "Not implemented!", JOptionPane.INFORMATION_MESSAGE);
			break;
		case "MR":
			JOptionPane.showMessageDialog(null, "Not yet implemented!", "Not implemented!", JOptionPane.INFORMATION_MESSAGE);
			break;
		case "MS":
			JOptionPane.showMessageDialog(null, "Not yet implemented!", "Not implemented!", JOptionPane.INFORMATION_MESSAGE);
			break;
		case "M+":
			JOptionPane.showMessageDialog(null, "Not yet implemented!", "Not implemented!", JOptionPane.INFORMATION_MESSAGE);
			break;
		case "sqrt":
			JOptionPane.showMessageDialog(null, "Not yet implemented!", "Not implemented!", JOptionPane.INFORMATION_MESSAGE);
			break;
		case "%":
			JOptionPane.showMessageDialog(null, "Not yet implemented!", "Not implemented!", JOptionPane.INFORMATION_MESSAGE);
			break;
		case "1/x":
			JOptionPane.showMessageDialog(null, "Not yet implemented!", "Not implemented!", JOptionPane.INFORMATION_MESSAGE);
			break;
		case "+/-":
			JOptionPane.showMessageDialog(null, "Not yet implemented!", "Not implemented!", JOptionPane.INFORMATION_MESSAGE);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Undefined action", "Undefined action", JOptionPane.INFORMATION_MESSAGE);;	
		}
		
	}

}
