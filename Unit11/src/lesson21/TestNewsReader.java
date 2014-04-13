package lesson21;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TestNewsReader implements ActionListener{
	
	//files to be read in background by NewsReader threads
	private static String fileName1 = "amzn.dat"; //"http://finance.yahoo.com/q?s=AMZN";
	private static String fileName2 = "orcl.dat"; //"http://finance.yahoo.com/q?s=ORCL";
	
	//GUI components
	private JTextArea newsArea1;
	private JScrollPane scroll1;
	
	private JTextArea newsArea2;
	private JScrollPane scroll2;
	
	private JButton readNewsButton;
	
	private JPanel windowContent;
	
	//constructor creates components and adds them to the frame
	public TestNewsReader(){
		
		windowContent = new JPanel();
		//Set the layout manager for this panel
		BorderLayout layoutManager = new BorderLayout();
		windowContent.setLayout(layoutManager);
		
		//add newsArea1 in the East
		newsArea1 = new JTextArea();
		newsArea1.setEditable(false);
		newsArea1.setLineWrap(true);
		newsArea1.setSize(300,400);
		scroll1 = new JScrollPane (newsArea1, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		windowContent.add("East", scroll1);
		
		//add newsArea2 in the West
		newsArea2 = new JTextArea();
		newsArea2.setEditable(false);
		newsArea2.setLineWrap(true);
		newsArea2.setSize(300,400);
		scroll2 = new JScrollPane (newsArea2, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		windowContent.add("West", scroll2);
		
		//add the button in the South area
		readNewsButton = new JButton("Read news");
		readNewsButton.addActionListener(this);
		windowContent.add("South",readNewsButton);
		
		//create the frame and set its content pane
		JFrame frame = new JFrame("News Reader");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(windowContent);
		
		//display the window
		frame.setLocation(100, 100);
		frame.setSize(700,500);
		frame.setVisible(true);
				
	}
	
	public static void main(String[] args){
		new TestNewsReader();
	}

	@Override
	public void actionPerformed(ActionEvent event) {		
		(new NewsReader(newsArea1, new File(fileName1))).execute();
		(new NewsReader(newsArea2, new File(fileName2))).execute();

}
}
