package com.practicaljava.lesson23;

import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import org.apache.commons.validator.routines.RegexValidator;

import oracle.jdbc.pool.OracleDataSource;

public class MyFrame  extends JFrame implements TableModelListener{

	private MyTableModel myTableModel; 
	private JTable myTable;

 MyFrame (String winTitle){
  super(winTitle);
  
  myTableModel = new MyTableModel();
  myTable = new JTable(myTableModel );

  //Add the JTable to frame and enable scrolling 
  add(new JScrollPane( myTable));

  // Register an event listener
   myTableModel.addTableModelListener(this);   
   
   //Assign the custom cell renderer to the Symbol column   
   // Get the reference to the second column - Symbol
   TableColumn column = myTable.getColumnModel().getColumn(1);

  // Create a new cell renderer as an anonymous inner 
  // class and assign it to the column price
  
  column.setCellRenderer(
        new DefaultTableCellRenderer(){ 
    public Component  getTableCellRendererComponent( 
             JTable table, Object value, boolean isSelected, 
                       boolean hasFocus, int row, int col) { 

         JLabel label = (JLabel) super.getTableCellRendererComponent(
               table, value, isSelected, hasFocus, row, col); 
       
       // display invalid input message in red
       if ("Invalid input!".equals(value.toString())){
          label.setForeground(Color.RED);
       } else{
    	   label.setForeground(Color.BLACK); 
       }
 
       return label; 

      } // end of getTableCellRendererComponent
     }  // end of new DefaultTableCellRenderer
  );    // end of setCellRenderer(...)
   
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
	    	/*  
	    	  if (col ==2){ 
	    	      return true;
	    	  } else {
	    	    return false;
	    	  }
	    	  */
	    	//Make all cells editable
	    	return true;
	    	}

	    
	    // Update the model when the user changes the quantity
	    public void setValueAt(Object value, int row, int col){
	    
	     if (col== 2){
	       myData.get(row).quantity=(Integer.valueOf(value.toString()));
         }
	     
	     if (col == 1){
	     
	    /*validate stock symbol using a regular expression (1 to 4 capital letters
	     and sometimes a period with 1 or 2 capital letters following) and
	    Apache Commons Validator*/
	     
	     // set up the parameters
	      boolean caseSensitive = true;
	      String regex   = "[A-Z]{1,4}(\\.[A-Z]{1,2})?";

	      // Create the validator
	      RegexValidator validator = new RegexValidator(regex, caseSensitive);

	      // Validate true/false
	      boolean valid = validator.isValid(value.toString());
	      
	      if (valid){    	  
	    	  myData.get(row).stockSymbol=value.toString();
	      }
	      else
	    	  myData.get(row).stockSymbol="Invalid input!";
	      
	     }
	    
		//Notify the world about the change
	      //fireTableDataChanged();
	      
	      TableModelEvent event = new TableModelEvent(this, row, row, col);
	      fireTableChanged(event);
	  }

 }
