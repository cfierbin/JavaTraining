package com.practicaljava.lesson24;
import java.lang.reflect.*;
public class ReflectionSample {
  @SuppressWarnings("rawtypes")
public static void main(String args[]) {
     try {
       Class c = Class.forName("com.practicaljava.lesson24.Employee");
       Method methods[] = c.getDeclaredMethods();
       System.out.println("The  Employee methods:");

       for (int i = 0; i < methods.length; i++){
            System.out.println("*** Method Signature:" + 
                                    methods[i].toString());
       }

       Class superClass = c.getSuperclass();
       System.out.println("The name of the superclass is " 
                                   + superClass.getName());

       Method superMethods[] = superClass.getDeclaredMethods();
       System.out.println("The superclass has:");

       for (int i = 0; i < superMethods.length; i++){
            System.out.println("*** Method Signature:" + 
                               superMethods[i].toString());
            System.out.println("      Return type: " + 
                superMethods[i].getReturnType().getName());
       }
       
       
       Class parameterTypes[]= new Class[] {String.class, int.class};
       
    @SuppressWarnings("unchecked")
	Method myMethod = c.getMethod( "changeAddress", parameterTypes);

       Object arguments[] = new Object[2];
       arguments[0] = "250 Broadway";
       arguments[1] = 1;
       myMethod.invoke(c.newInstance(),arguments);     

     } catch (Exception e) {
           e.printStackTrace();
     }
  }
}
