import java.io.*;
class ClassA {
 
  public static void main(String args[]){
       Employee emp = new Employee();
       emp.lName = "Cristina";
       emp.fName = "Cristina"; 
       emp.salary = 50000;
       
       FileOutputStream fOut=null;
       ObjectOutputStream oOut=null;
    try{   
     fOut = new  FileOutputStream("BestEmployee.ser");

     oOut = new ObjectOutputStream(fOut);

     oOut.writeObject(emp);  //serializing employee
   } catch (IOException e){
	  try{ 
        oOut.flush();
        oOut.close();
        fOut.close();
	  }catch (IOException ioe){
		  ioe.printStackTrace();
	  }
   }  
   System.out.println("The Employee object has been serialized into BestEmployee.ser");
  } 
}