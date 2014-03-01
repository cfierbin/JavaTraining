import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculator {

	//Declare Calculator's graphical components
	JPanel windowContent;
	JMenu edit;
	JMenu view;
	JMenu help;
	JTextField displayField;
	JButton backspace;
	JButton ce;
	JButton c;
	JButton one;
	JButton two;
	JButton three;
	JButton four;
	JButton five;
	JButton six;
	JButton seven;
	JButton eight;
	JButton nine;
	JButton zero;
	JButton mc, mr, ms, mPlus;
	JButton sqrt, mod, inv, equal;
	JButton plus, minus, div, mult;
	JButton dot, plusMinus;
	
	/**
	 * Constructor creates the components, adds them to the frame and displays the window
	 * @param args
	 */
	
	public Calculator(){
		
		//create the components
		
		windowContent = new JPanel();
		
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constr = new GridBagConstraints();
		windowContent.setLayout(gb);
		
		displayField = new JTextField();
		edit = new JMenu("Edit");
		view = new JMenu("View");
		help = new JMenu("Help");
		backspace = new JButton("Backspace");
		ce = new JButton("CE");
		c = new JButton("C");
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		zero = new JButton("0");
		mc = new JButton("MC");
		mr = new JButton("MR");
		ms = new JButton("MS");
		mPlus = new JButton("M+");
		plus = new JButton("+");
		minus = new JButton("-");
		div = new JButton("/");
		mult = new JButton("*");
		sqrt = new JButton("sqrt");
		mod = new JButton("%");
		inv = new JButton("1/x");
		equal = new JButton("=");
		dot = new JButton(".");
		plusMinus = new JButton("+/-");
		
		//set constraints for the components

//first row (menu)
		
		constr.gridx = 0;
		constr.gridy = 0;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 0.0;
		constr.weighty = 0.0;
		gb.setConstraints(edit, constr);
		
		constr.gridx = 1;
		constr.gridy = 0;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 0.0;
		constr.weighty = 0.0;
		gb.setConstraints(view, constr);
		
		constr.gridx = 2;
		constr.gridy = 0;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 0.0;
		constr.weighty = 0.0;
		gb.setConstraints(help, constr);
	
//second row (display field)
		
		constr.gridx = 0;
		constr.gridy = 1;
		constr.gridheight = 1;
		constr.gridwidth = 6;
		constr.fill = GridBagConstraints.BOTH;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(displayField, constr);
		
//first row of buttons (3rd row in grid)
		
		constr.gridx = 1;
		constr.gridy = 2;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(backspace, constr);
		
		constr.gridx = 2;
		constr.gridy = 2;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(ce, constr);
		
		constr.gridx = 3;
		constr.gridy = 2;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(c, constr);
		
//second row of buttons (starting with MC)
		
		constr.gridx = 0;
		constr.gridy = 3;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(mc, constr);
		
		constr.gridx = 1;
		constr.gridy = 3;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(seven, constr);
		
		constr.gridx = 2;
		constr.gridy = 3;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(eight, constr);
		
		constr.gridx = 3;
		constr.gridy = 3;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(nine, constr);
		
		constr.gridx = 4;
		constr.gridy = 3;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(div, constr);
		
		constr.gridx = 5;
		constr.gridy = 3;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(sqrt, constr);
		

//third row of buttons (starting with MR)
		
		constr.gridx = 0;
		constr.gridy = 4;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(mr, constr);
		
		constr.gridx = 1;
		constr.gridy = 4;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(four, constr);
		
		constr.gridx = 2;
		constr.gridy = 4;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(five, constr);
		
		constr.gridx = 3;
		constr.gridy = 4;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(six, constr);
		
		constr.gridx = 4;
		constr.gridy = 4;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(mult, constr);
		
		constr.gridx = 5;
		constr.gridy = 4;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(mod, constr);
		
//fourth row of buttons (starting with MS)
		
		constr.gridx = 0;
		constr.gridy = 5;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(ms, constr);
		
		constr.gridx = 1;
		constr.gridy = 5;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(one, constr);
		
		constr.gridx = 2;
		constr.gridy = 5;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(two, constr);
		
		constr.gridx = 3;
		constr.gridy = 5;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(three, constr);
		
		constr.gridx = 4;
		constr.gridy = 5;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(minus, constr);
		
		constr.gridx = 5;
		constr.gridy = 5;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(inv, constr);
		
//fifth  row of buttons (starting with M+)
		
		constr.gridx = 0;
		constr.gridy = 6;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(mPlus, constr);
		
		constr.gridx = 1;
		constr.gridy = 6;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(zero, constr);
		
		constr.gridx = 2;
		constr.gridy = 6;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(plusMinus, constr);
		
		constr.gridx = 3;
		constr.gridy = 6;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(dot, constr);
		
		constr.gridx = 4;
		constr.gridy = 6;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(plus, constr);
		
		constr.gridx = 5;
		constr.gridy = 6;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1.0;
		constr.weighty = 1.0;
		gb.setConstraints(equal, constr);
		
		//add the components to the panel
		
		windowContent.add(displayField);
		windowContent.add(edit);
		windowContent.add(view);
		windowContent.add(help);
		windowContent.add(backspace);
		windowContent.add(ce);
		windowContent.add(c);
		windowContent.add(one);
		windowContent.add(two);
		windowContent.add(three);
		windowContent.add(four);
		windowContent.add(five);
		windowContent.add(six);
		windowContent.add(seven);
		windowContent.add(eight);
		windowContent.add(nine);
		windowContent.add(zero);
		windowContent.add(plus);
		windowContent.add(minus);
		windowContent.add(div);
		windowContent.add(mult);
		windowContent.add(sqrt);
		windowContent.add(mod);
		windowContent.add(inv);
		windowContent.add(equal);
		windowContent.add(mc);
		windowContent.add(mr);
		windowContent.add(ms);
		windowContent.add(mPlus);
		windowContent.add(dot);
		windowContent.add(plusMinus);
		
		//create the frame and set its content pane
		
		JFrame frame = new JFrame("Cristina's GridBagLayout Calculator");
		frame.setContentPane(windowContent);
		frame.pack(); //set the size big enough to accomodate all controls
		
		//display the window
		
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		Calculator myCalculator = new Calculator();

	}

}
