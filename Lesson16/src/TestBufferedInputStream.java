import java.io.*;
public class TestBufferedInputStream {

	public static void main(String[] args) throws IOException{
		FileInputStream myFile = null;
		BufferedInputStream buff =null;

		  try {
		     myFile = new  FileInputStream("abc.dat");
		     buff = new BufferedInputStream(myFile);
		            boolean eof = false;
		            while (!eof) {
		                int byteValue = buff.read();
		                System.out.print(byteValue + " ");
		                if (byteValue  == -1)
		                    eof = true;
		           }
		} catch (IOException e) { 
			System.out.println(e);
		}
		 finally{ 
             if(myFile != null){
		       buff.close();
		       myFile.close();
             }  
		 }


	}

}
