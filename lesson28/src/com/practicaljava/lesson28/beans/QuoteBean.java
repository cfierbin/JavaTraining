package com.practicaljava.lesson28.beans;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="quoteBean")
@RequestScoped
public class QuoteBean implements Serializable {
	
	private String symbol;
	private int quantity;
	private double price;
	
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public QuoteBean(){
		Random numericGenerator = new Random();
		this.price = numericGenerator.nextDouble()
				+ numericGenerator.nextInt(100) + 90;
	}

	public QuoteBean(String symbol, int quantity, double price){
		this.symbol = symbol;
		this.quantity = quantity;
		this.price = price;
	}

}
