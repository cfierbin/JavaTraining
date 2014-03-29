import java.io.*;
public class TestFileInputStream {

	public static void main(String[] args) {
		FileInputStream myFile = null;
		  try {
		            myFile = new  FileInputStream("abc.dat");
		            boolean eof = false;

		            while (!eof) {
		                int byteValue = myFile.read();
		                System.out.print(byteValue + " ");
		                if (byteValue  == -1)
		                    eof = true;
		           }
		       //  myFile.close();          // do not do it here!!!
		  } catch (IOException e) {
		           System.out.println("Could not read file: " + 
		                                           e.toString());
		  } finally{
			  if(myFile != null){
		        try{
		          myFile.close();
		        } catch (Exception e1){
		             e1.printStackTrace();
		        }
			  }  
		  }
		}
	}

