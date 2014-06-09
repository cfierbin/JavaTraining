package com.practicaljava.lesson32.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: MyPriceConsumer
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")//, @ActivationConfigProperty(
//				propertyName = "destination", propertyValue = "MyJMSTestQueue")
		}, 
		mappedName = "MyJMSTestQueue")
public class MyPriceConsumer implements MessageListener {

    /**
     * Default constructor. 
     */
    public MyPriceConsumer() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
   	 String msgText;
   	 try{
   	     if (message instanceof TextMessage){
   	             msgText = ((TextMessage) message).getText();
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
