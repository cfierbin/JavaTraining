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

import com.practicaljava.lesson32.ejb.HelloWorldBean;
import com.practicaljava.lesson32.ejb.StockServerBean;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> nasdaqSymbols = new ArrayList<String>();
	private Random numericGenerator;
	
	@EJB
	HelloWorldBean myBean;
	
	@EJB
	StockServerBean myStockServerBean;
       
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
		PrintWriter out = response.getWriter();
		out.println(myBean.sayHello());
		
//		String symbol = nasdaqSymbols.get(numericGenerator.nextInt(11));
//		out.println(myStockServerBean.getQuote(symbol));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
