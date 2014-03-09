package com.practicaljava.lesson11;

import java.awt.Font;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TicTacToeApplet1 extends JApplet
{
    private static String PLAYERX = "Player X";
    
	
    private String playerName = PLAYERX;
	
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JLabel playerNumber;
    private java.awt.Panel buttonsPanel;

    public void init(){
        initComponents();
    }

    private void initComponents(){
        buttonsPanel = new java.awt.Panel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        playerNumber = new JLabel(playerName, SwingConstants.CENTER);
	    
    
        Font buttonFont = new Font("Times New Roman", Font.PLAIN, 60);
	    
        button1.setFont(buttonFont);
        button2.setFont(buttonFont);
        button3.setFont(buttonFont);
        button4.setFont(buttonFont);
        button5.setFont(buttonFont);
        button6.setFont(buttonFont);
        button7.setFont(buttonFont);
        button8.setFont(buttonFont);
        button9.setFont(buttonFont);
	    
        buttonsPanel.setLayout(new java.awt.GridLayout(4, 3));
        
        buttonsPanel.add(button1);
        buttonsPanel.add(button2);
        buttonsPanel.add(button3);
        buttonsPanel.add(button4);
        buttonsPanel.add(button5);
        buttonsPanel.add(button6);
        buttonsPanel.add(button7);
        buttonsPanel.add(button8);
        buttonsPanel.add(button9);
        
       // buttonsPanel.add(new Component(){});
        setPlayerName(PLAYERX); 
        buttonsPanel.add(playerNumber);
        
        add(buttonsPanel);
        		
    }
	
    private void setPlayerName(String playerName){
        this.playerName = playerName;
        playerNumber.setText(playerName + ", your turn . ");
    }
	
    private void reset(){
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        setPlayerName(PLAYERX);
    }
    
}   