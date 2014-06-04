package com.practicaljava.lesson30;

import javax.jms.*;
import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.ConnectionConfiguration;


public class MessageReceiver implements MessageListener{

	Session session=null;
	 ConnectionFactory factory;
	 QueueConnection connection=null;
	 MessageConsumer consumer=null;
	
	MessageReceiver(){
		 try{
		      factory = new com.sun.messaging.ConnectionFactory();  
		      factory.setProperty(ConnectionConfiguration.imqAddressList, "mq://localhost:7676,mq://localhost:7676");
		      connection = factory.createQueueConnection("admin","admin");
		      
		      connection.start();


		      Session session = connection.createQueueSession( 
		                      false, Session.AUTO_ACKNOWLEDGE);

		      Queue ioQueue = session.createQueue( "TestQueue" );

		      consumer = session.createConsumer(ioQueue);
		      consumer.setMessageListener(this);
		      
		      System.out.println("Listening to the TestQueue...");
		      
		      // Don't finish -  wait for messages
		      Thread.sleep(100000);
		    
		   } catch (InterruptedException e){
	           System.out.println("Error: " + e.getMessage());
	       }
		    catch (JMSException e){
		           System.out.println("Error: " + e.getMessage());
		    } 
		    finally{
		       try{
		         // session.close();
		          connection.close();
		       } catch (Exception e) {
		          System.out.println("Can’t close JMS connection/session " + e.getMessage());
		      }
		    }	
	
	}
	
 public static void main(String[] args){
	  new MessageReceiver();
	}	

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
