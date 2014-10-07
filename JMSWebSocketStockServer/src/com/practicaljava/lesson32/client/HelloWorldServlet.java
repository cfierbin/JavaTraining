package com.practicaljava.lesson32.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practicaljava.lesson28.beans.QuoteBean;
import com.practicaljava.lesson32.ejb.StockServerBean;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> nasdaqSymbols = new ArrayList<String>();
	private Random numericGenerator;
		
	//sends messages with stock prices to MyJMSTestQueue
	@EJB StockServerBean myStockServerBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String price;
		
        //content type must be set to text/event-stream
        response.setContentType("text/event-stream");  
 
        //encoding must be set to UTF-8
        response.setCharacterEncoding("UTF-8");
 
        PrintWriter writer = response.getWriter();
 
        for(int i=0; i<100; i++) {
        	
          	price = myStockServerBean.getPrice();
          	
            writer.write("data: "+ price +"\n\n");
            writer.flush();
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
 
        writer.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
