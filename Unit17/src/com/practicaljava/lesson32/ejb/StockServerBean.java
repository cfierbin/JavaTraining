package com.practicaljava.lesson32.ejb;

import java.util.ArrayList;
import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import com.practicaljava.lesson31.MessageSender;

/**
 * Session Bean implementation class StockServerBean
 */
@Stateless
@LocalBean
public class StockServerBean {
	
	private String price=null;
	private MessageSender mySender;
	private ArrayList<String> nasdaqSymbols = new ArrayList<String>();
	private Random numericGenerator;

    /**
     * Default constructor. 
     */
    public StockServerBean() {
    	
    	//create message sender
    	mySender=new MessageSender();
    	
        // Define some hard-coded NASDAQ symbols
    	nasdaqSymbols.add("AAPL");
    	nasdaqSymbols.add("ORCL");
    	nasdaqSymbols.add("MSFT");
    	nasdaqSymbols.add("YHOO");
    	nasdaqSymbols.add("IBM");
    	nasdaqSymbols.add("ORAN");
    	nasdaqSymbols.add("GOOG");
    	nasdaqSymbols.add("FB");
    	nasdaqSymbols.add("FBOK34.SA");
    	nasdaqSymbols.add("AMZN");
    	nasdaqSymbols.add("YNDX");
    	
		numericGenerator = new Random();
    }
    
    @Schedule(second = "*/1", minute = "*", hour = "*", persistent=false)    
    public void getQuote(){
    	    //String symbol = nasdaqSymbols.get(numericGenerator.nextInt(11));
    		price = (new Double(Math.random()*100)).toString();
    	    //send a text message with the price to the queue MyJMSTestQueue
    		//MessageSender mySender=new MessageSender();
    		mySender.sendMessage(price);
    }
    
    public String getQuote(String symbol){
    	if(nasdaqSymbols.indexOf(symbol.toUpperCase()) != -1){
    		//generate a random price for valid symbols
    		//price = (new Double(Math.random()*100)).toString();
    	}
    	//System.out.println("The price of " + symbol + " is " + price);
    	return price;
    }
    
    

}
