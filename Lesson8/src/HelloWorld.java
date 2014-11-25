import javax.swing.JFrame;
import javax.swing.JButton;

public class HelloWorld extends JFrame {

    public HelloWorld(){
    	setSize(200,300);
    	setTitle("Hello World");
    	setVisible(true);
    	
    	// Adding a button
    	JButton myButton = new JButton ("Click me");
        add(myButton); 
        //pack();
    }
	public static void main(String[] args) {
	    new HelloWorld();
	}

}
