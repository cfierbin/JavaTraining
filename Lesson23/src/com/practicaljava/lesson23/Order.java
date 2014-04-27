package com.practicaljava.lesson23;

public class Order {
    public int orderID;
    public String stockSymbol;
    public int quantity;
    public double price;
    
    public Order(int id, String stockSymbol, int quantity, double price){
    	orderID=id;
    	this.stockSymbol=stockSymbol;
    	this.quantity=quantity;
    	this.price=price;
    }
}
