package com.practicaljava.lesson11;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

class MyObserver implements PropertyChangeListener {
    
    public MyObserver(TicTacToeApplet model) {
        model.addChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
    	//new value = position of move (integer)
       System.out.println("Changed property: " + event.getPropertyName() + " | [new -> " + event.getNewValue() +"]");
    }
} 
