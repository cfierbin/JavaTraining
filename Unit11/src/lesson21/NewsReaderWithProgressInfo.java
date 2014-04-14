package lesson21;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class NewsReaderWithProgressInfo extends SwingWorker<List<Integer>, Integer>{
	//doInBackground returns List<Integer> (bytes read)
	//process takes an argument of type Integer (number of bytes read)
	
	private JTextArea newsArea;
	private File file;
	
	NewsReaderWithProgressInfo(JTextArea textArea, File file) {
        //initialize
		newsArea = textArea;
		this.file = file;
    }

	@Override
	protected List<Integer> doInBackground() throws Exception {
		ArrayList<Integer> bytes = new ArrayList<Integer>();
		FileInputStream myFile = new FileInputStream(file);
		long fileSize = file.length();
		boolean eof = false;
		while (!eof) { 
			 int byteValue = myFile.read(); 
			 System.out.print((char)byteValue);
			 bytes.add(byteValue);
			 //used by process
			 publish(byteValue);
			 //property to be sent to listeners
			 setProgress((int)(100 * bytes.size() / fileSize));
			 if (byteValue == -1){ 
			 eof = true; 
			 } 
		}
		myFile.close();
		return bytes;
	}
	
    @Override
    protected void process(List<Integer> chunks) {
        for (int number : chunks) {
            newsArea.append(""+(char)number);
        }
    }

}
