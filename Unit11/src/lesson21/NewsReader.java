package lesson21;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class NewsReader extends SwingWorker<String, Integer> {
	//doInBackground returns String (the content of the file)
	//process should take an argument of type Integer, but not overriden here
	
	private JTextArea newsArea;
	private File file;
	
	NewsReader(JTextArea textArea, File file) {
        //initialize
		newsArea = textArea;
		this.file = file;
    }

	@Override
	protected String doInBackground(){
		String theWholeFile = null;
		String txt;
		BufferedReader buff = null;
		try{
			buff = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			while((txt=buff.readLine()) != null){
				System.out.println(txt);
				theWholeFile = theWholeFile + txt;
			}
		}
		catch(FileNotFoundException e){
			System.out.println("File not found");
		}
		catch(IOException e){
			System.out.println("I/O exception");
		}
		finally{
			try{
				buff.close();
			}
			catch(IOException e){
				System.out.println("I/O exception");
			}
		}
		return theWholeFile;
	}
	
	@Override
    protected void done() {
        try {
            newsArea.setText(get());
        } catch (Exception e) {
        	System.out.println("Exception in newsArea.setText()");
        }
    }

}
