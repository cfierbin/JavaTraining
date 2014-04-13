package lesson21;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class NewsReader extends SwingWorker<String, Integer> {
	//doInBackground returns String (the content of the file)
	//process takes an argument of type Integer (number of bytes in the file)
	
	JTextArea newsArea;
	File file;
	
	NewsReader(JTextArea textArea, File file) {
        //initialize
		newsArea = textArea;
		this.file = file;
    }

	@Override
	protected String doInBackground() throws Exception {
		String theWholeFile = null;
		String txt;
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		while((txt=buff.readLine()) != null){
			System.out.println(txt);
			theWholeFile = theWholeFile + txt;
		}
		buff.close();
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
