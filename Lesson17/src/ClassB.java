import java.io.*;
class ClassB {
 
  public static void main(String args[]){
       
       FileInputStream fIn=null;
       ObjectInputStream oIn=null;
       Employee bestEmp = null;
    try{   
     fIn = new  FileInputStream("BestEmployee.ser");

     oIn = new ObjectInputStream(fIn);

     bestEmp=(Employee)oIn.readObject();
     
   }catch (ClassNotFoundException cnf){
	   cnf.printStackTrace();
   } catch (IOException e){
	  try{ 
        oIn.close();
        fIn.close();
	  }catch (IOException ioe){
		  ioe.printStackTrace();
	  }
   }finally{
	   if (oIn != null){
	    try{ 
	        oIn.close();
	        fIn.close();
		  }catch (IOException e1){
			  e1.printStackTrace();
		  }
	   }  
   }
   
   System.out.println("The Employee  object has been deserialized from BestEmployee.ser");
  } 
}