package com.practicaljava.lesson31;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Singleton
@Startup
public class MessageReceiver implements MessageListener{

	//@Resource (name = "MyTestConnectionFactory")
	private ConnectionFactory factory;
	
	//@Resource(name = "MyJMSTestQueue")
	private Queue ioQueue;
	
	private Connection connection=null;
	
	MessageReceiver(){
		 try{	 
		      // Find the JNDI context
		      Context jndiContext = new InitialContext();
		      // Look up the factory and the queue
		      factory = (ConnectionFactory) jndiContext.lookup("MyTestConnectionFactory");
		      ioQueue = (Queue) jndiContext.lookup("MyJMSTestQueue");
		     
		      connection = factory.createConnection();
		      
		      connection.start();
		      
		      Session session = connection.createSession( 
		                      false, Session.AUTO_ACKNOWLEDGE);
		      	      
		      MessageConsumer consumer = session.createConsumer(ioQueue);
		      consumer.setMessageListener(this);
		      
		      	      
		      System.out.println("Listening to the TestQueue...");
		      
		      // Don't finish -  wait for messages
		      //Thread.sleep(100000);
		    
		   } 
	/*	 
		 catch (InterruptedException e){
	           System.out.println("Error: " + e.getMessage());
	       }
	*/	 
		    catch (JMSException e){
		           System.out.println("Error: " + e.getMessage());
		    }
		     
		 	catch (NamingException e) {			
				e.printStackTrace();
			}
					
		    finally{
		       try{
		         // session.close();
		          connection.close();
		       } catch (Exception e) {
		          System.out.println("Can't close JMS connection/session " + e.getMessage());
		      }
		    }	
	
	}

	/*
 public static void main(String[] args){
	  new MessageReceiver();
	}
	*/	

 public void onMessage(Message msg){
	 String msgText;
	 try{
	     if (msg instanceof TextMessage){
	             msgText = ((TextMessage) msg).getText();
	            System.out.println("Got from the queue: " + msgText);
	     }else{
	        System.out.println("Got a non-text message");
	     }
	 }
	 catch (JMSException e){
	      System.out.println("Error while consuming a message: " + e.getMessage());
	 } 
 }

 
}

