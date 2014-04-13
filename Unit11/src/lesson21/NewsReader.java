package lesson21;

import java.io.File;
import java.io.FileInputStream;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class NewsReader extends SwingWorker<String, Integer> {
	//doInBackground returns String (the content of the file)
	//process takes an argument of type Integer (number of bytes in the file)
	
	JTextArea newsArea;
	FileInputStream file;
	
	NewsReader(JTextArea textArea, FileInputStream file) {
        //initialize
		newsArea = textArea;
		this.file = file;
    }

	@Override
	protected String doInBackground() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
    protected void done() {
        try {
            newsArea.setText(get());
        } catch (Exception ignore) {
        }
    }

}
