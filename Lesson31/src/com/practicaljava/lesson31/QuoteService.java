package com.practicaljava.lesson31;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "The servlet that Sends a message to a queue", urlPatterns = { "/quote" }, name="QuoteService")
public class QuoteService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get or create the session
		request.getSession(true);
		
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor=yellow>");
		out.println("<h2>Hello from QuoteService</h2>");
		
		out.println("Sending a message to the TestQueue");
		
		MessageSender mySender=new MessageSender();
		mySender.sendMessage("IBM 200 Buy");
		
		//Destroy the session
		request.getSession(true).invalidate();
	}
	
}

