
package com.practicaljava.lesson31;

import javax.jms.*;
import javax.naming.*;


public class MessageSender {
 
    public void sendMessage(String messageToSend){
	 Session session=null;
	 ConnectionFactory factory=null;
	 Connection connection=null;
	 
	 try{  
	      // Find the JNDI context
	      Context jndiContext = new InitialContext();
	      // Look up the factory and the queue
	      factory = (ConnectionFactory) jndiContext.lookup("MyTestConnectionFactory");
	      Queue ioQueue = (Queue) jndiContext.lookup("MyJMSTestQueue");
	      
	      connection = factory.createConnection();
	
	      connection.start();

	      session = connection.createSession( 
	                          false, Session.AUTO_ACKNOWLEDGE);
	      MessageProducer queueSender = session.createProducer(ioQueue);
	      
	      // Send message	      
	      TextMessage outMsg = session.createTextMessage(messageToSend);
	     
	      queueSender.send(outMsg);
	      queueSender.close();
	      
	      System.out.println("MessageSender: Successfully sent a message");
	    }
	    catch (JMSException e){
	           System.out.println("Error: " + e.getMessage());
	    } catch (NamingException e) {
			
			e.printStackTrace();
		} 
	    finally{
	       try{
	          session.close();
	          connection.close();
	       } catch (Exception e) {
	          System.out.println("Can't close JMS connection/session " + e.getMessage());
	      }
	    }	
}	
	
}
