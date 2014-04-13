import java.io.FileOutputStream;
//import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


class FileDownload{

  public static void main(String args[]){
    if (args.length!=2){
      System.out.println(
        "Proper Usage: java FileDownload URL OutputFileName");
      System.exit(0);
    }

  InputStream in=null;
  FileOutputStream fOut=null;

  try{
    URL remoteFile=new URL(args[0]);
    URLConnection fileStream=remoteFile.openConnection();

    // Open output and input streams
    fOut=new FileOutputStream(args[1]);
  
    in=fileStream.getInputStream();

    // Save the file
    int data;
    while((data=in.read())!=-1){
         fOut.write(data);
    }  

  } catch (Exception e){
     e.printStackTrace();
  } finally{
	  System.out.println("The file " + args[0] + 
		" has been downloaded successfully as " + args[1]);   
     try{
       in.close();
       fOut.flush(); 
       fOut.close();      
     } catch(Exception e){e.printStackTrace();}
  }
   
 }
}
