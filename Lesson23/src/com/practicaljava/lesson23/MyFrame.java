package com.practicaljava.lesson23;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import oracle.jdbc.pool.OracleDataSource;

public class MyFrame  extends JFrame implements TableModelListener{

	MyTableModel myTableModel; 
	JTable myTable;

 MyFrame (String winTitle){
  super(winTitle);
  
  myTableModel = new MyTableModel();
  myTable = new JTable(myTableModel );

  //Add the JTable to frame and enable scrolling 
  add(new JScrollPane( myTable));

  // Register an event listener
   myTableModel.addTableModelListener(this);   
   
 }

 public void tableChanged(TableModelEvent e) {
  // Code to process data changes goes here
	 System.out.println("Someone changed the data in JTable!");
 }

 public static void main(String args[]){
	 
	 OracleDataDefinitionAndManipulation.createTable(); 
	 
  MyFrame myFrame = new MyFrame( "My Test Window" );
  myFrame.pack();
  myFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
  myFrame.setVisible( true );

}  
		
}

class MyTableModel extends AbstractTableModel {
	    // The data for JTable should be here

		ArrayList<Order> myData = new ArrayList<Order>();
/*
		String[] orderColNames = { "Order ID",   "Symbol", 
                "Quantity", "Price"};
*/ 

	   MyTableModel(){
			myData = OrderDAO.getOrder();
/*			
			myData.add(new Order(1,"IBM", 100, 135.5f));
			myData.add(new Order(2,"AAPL", 300, 290.12f));
			myData.add(new Order(3,"MOT", 2000, 8.32f));
			myData.add(new Order(4,"ORCL", 500, 27.8f));
*/
		}
		
	    public int getColumnCount() {
	      return 4;
	    }

	    public int getRowCount() {
	      return myData.size();
	    	
	    }

	    public Object getValueAt(int row, int col) {
	       
	    	switch (col) {
	    	  case 0:   // col 1
	    	    return myData.get(row).orderID;
	    	  case 1:   // col 2
	    		  return myData.get(row).stockSymbol;
	    	  case 2:   // col 3
	    		  return myData.get(row).quantity;
	    	  case 3:   // col 4 
	    		  return myData.get(row).price;
	    	  default:
	    	    return "";
	    	}
	    	
	    }
	    
	    public String getColumnName(int col){
//	    	return orderColNames[col];
	    	return OrderDAO.getColumnName(col + 1);
	    }

	    
	    public boolean isCellEditable(int row, int col) {
	    	  
	    	  if (col ==2){ 
	    	      return true;
	    	  } else {
	    	    return false;
	    	  }
	    	}

	    
	    // Update the model when the user changes the quantity
	    public void setValueAt(Object value, int row, int col){
	    
	     if (col== 2){
	       myData.get(row).quantity=(Integer.valueOf(value.toString()));
         }
	    
		//Notify the world about the change
	      //fireTableDataChanged();
	      
	      TableModelEvent event = new TableModelEvent(this, row, row, col);
	      fireTableChanged(event);
	  }

 }
