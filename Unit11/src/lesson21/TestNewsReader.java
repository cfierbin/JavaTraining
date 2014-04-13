package lesson21;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private FileInputStream file1;
	private FileInputStream file2;
	
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
		newsArea1.setText("111111111111111111111111111111111111");
		scroll1 = new JScrollPane (newsArea1, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		windowContent.add("East", scroll1);
		
		//add newsArea2 in the West
		newsArea2 = new JTextArea();
		newsArea2.setEditable(false);
		newsArea2.setText("222222222222222222222222222222222222");
		scroll2 = new JScrollPane (newsArea2, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		windowContent.add("West", scroll2);
		
		//add the button in the South area
		readNewsButton = new JButton("Read news");
		windowContent.add("South",readNewsButton);
		
		//create the frame and set its content pane
		JFrame frame = new JFrame("News Reader");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(windowContent);
		
		//display the window
		frame.setSize(500,500);
		frame.setVisible(true);
				
	}
	
	public static void main(String[] args){
		new TestNewsReader();
		try (FileInputStream file1 = new FileInputStream(fileName1);
				FileInputStream file2 = new FileInputStream(fileName2);) {


			} catch (IOException exception) {
			System.out.println("Could not read file: " + exception.toString());
			}

	}

	@Override
	public void actionPerformed(ActionEvent event) {
				
		(new NewsReader(newsArea1, file1)).execute();
		(new NewsReader(newsArea2, file2)).execute();

}
}
