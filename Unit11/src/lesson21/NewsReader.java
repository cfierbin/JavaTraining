package lesson21;

import java.net.URL;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class NewsReader extends SwingWorker<String, Integer> {
	//doInBackground returns String (the content of the file)
	//process takes an argument of type Integer (number of bytes in the file)
	
	JTextArea newsArea;
	URL url;
	
	NewsReader(JTextArea textArea, URL url) {
        //initialize
		newsArea = textArea;
		this.url = url;
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
