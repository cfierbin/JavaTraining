import java.net.*;
import java.io.*;
public class WebSiteReader {
  public static void main(String args[]){
       String nextLine;
       URL url = null;
       URLConnection urlConn = null;
       InputStreamReader  inStream = null;
       BufferedReader buff = null;
       try{
         // index.html is a default URL's  file name  
          url  = new URL("http://www.google.com" );
          urlConn = url.openConnection();
         inStream = new InputStreamReader( 
                           urlConn.getInputStream(), "UTF8");
           buff  = new BufferedReader(inStream);
        
      // Read and print the lines from index.html
        while (true){
             nextLine =buff.readLine();  
             if (nextLine !=null){
                System.out.println(nextLine); 
             }
             else{
               break;
             } 
         }
     } catch(MalformedURLException e){
       System.out.println("Please check the URL:" + 
                                           e.toString() );
     } catch(IOException  e1){
      System.out.println("Can't read  from the Internet: "+ 
                                          e1.toString() ); 
     } finally{
    	 if (inStream != null){
    	   try{	 
    		 inStream.close();
    		 buff.close();
    	   } catch(IOException e1){
    		  System.out.println("Can't close the streams: " + e1.getMessage());
    	   }
    	 }
     }
 }
}
