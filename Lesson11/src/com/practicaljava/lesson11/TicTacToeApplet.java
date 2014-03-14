package com.practicaljava.lesson11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class TicTacToeApplet extends JApplet implements MouseListener
{
    private static final String PLAYERX = "Player X";
    private static final String PLAYERO = "Player O";
    
    //GUI settings
    private static final int BUTTON_FONT_SIZE = 40;
    private static final int BUTTON_Preferred_SIZE_X = 100;
    private static final int BUTTON_Preferred_SIZE_Y = 100;
    private static final Color WIN_HIGHLIGHT_COLOR = Color.magenta;
    private static final String FONT_TYPE = "Times New Roman";
    
    private Font buttonFont = new Font(FONT_TYPE, Font.PLAIN, BUTTON_FONT_SIZE);
    
    //Random object used to generate computer moves; could it be "static"?
    private final java.util.Random randomInstance = new java.util.Random();
	   
    //GUI components
    
    private javax.swing.JButton[] arrayOfButtons = new javax.swing.JButton[9];   
    private javax.swing.JButton playAgain;
    private javax.swing.JLabel playerNumber;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel basePanel;
    
    //current player
    private String playerName = PLAYERX;
    
    //implementing observer design pattern
    private List<PropertyChangeListener> listener = new ArrayList<PropertyChangeListener>();

    //applet callback; called only once when the applet is loaded by the browser's Java Plug-in
    public void init(){
        initComponents();
        //create observer to be notified about computer moves
        MyObserver observer = new MyObserver(this);
    }

    //initialize components
    private void initComponents(){	
    	//buttonsPanel with GridLayout
        buttonsPanel = new javax.swing.JPanel();
        buttonsPanel.setLayout(new java.awt.GridLayout(3, 3));
        //bottomPanel with FlowLayout for displaying text and restarting game
        bottomPanel = new javax.swing.JPanel();
        bottomPanel.setLayout(new java.awt.FlowLayout());
        //basePanel with BoxLayout, holding buttonsPanel and bottomPanel
        basePanel = new javax.swing.JPanel();
        basePanel.setLayout(new javax.swing.BoxLayout(basePanel, javax.swing.BoxLayout.Y_AXIS));
        
        playerNumber = new javax.swing.JLabel(playerName, SwingConstants.CENTER);
        playAgain = new javax.swing.JButton("Play Again");
        playAgain.addMouseListener(new MouseAdapter(){
        								public void mouseClicked(MouseEvent e)
        									{
        										reset();
        									}	
        								}
        						  );

        for (int i=0; i<9; i++){
        	arrayOfButtons[i] = new javax.swing.JButton();
        	arrayOfButtons[i].setName("button"+i);
        }
        for(javax.swing.JButton button: arrayOfButtons){
        	button.addMouseListener(this);
        	button.setFont(buttonFont);
        	button.setPreferredSize(new Dimension(BUTTON_Preferred_SIZE_X, BUTTON_Preferred_SIZE_Y));
        	buttonsPanel.add(button);
        }
        
        //game started by Player X (human)
        setPlayerName(PLAYERX); 
        
        //add components to their containers
        bottomPanel.add(playerNumber);
        bottomPanel.add(playAgain);
        basePanel.add(buttonsPanel);
        basePanel.add(bottomPanel);
        add(basePanel);
    }
	
    private void setPlayerName(String playerName){
        this.playerName = playerName;
  // for game with 2 human players:     playerNumber.setText(playerName  + " your turn. ");
    }
	
    //called when the button playAgain is pressed
    private void reset(){
        for(javax.swing.JButton button: arrayOfButtons){
        	button.setText("");
        	button.setForeground(Color.black);
        }
        setPlayerName(PLAYERX);
        playerNumber.setText("");
    }
    
    private int getIndex(JButton button){
    	return Character.getNumericValue(button.getName().charAt(6));
    }
	
   
    private boolean checkForWinner(){
    //returns true if there is a winner	   
        if(findThreeInARow()){
        	//highlight winning combination
        	highlightWinningCombination();
        	//determine and display the name of the winner
            playerNumber.setText(playerName.concat(" won!!! Congratulations!!!"));
            return true;
        }
        else {
            return false;  
        }           
    }
   
   private boolean lastEmptyCell(){
   //returns true if all the cells are occupied
	   for(JButton button:arrayOfButtons){
		   if ("".equals(button.getText()))
		   return false;
	   }
	   return true;
   }
   
   private int getComputerMove(){
	   int computerMove;
	 //generate random move by computer until it finds an empty cell   
	do {
   		computerMove = randomInstance.nextInt(9);
   		}
   	while(arrayOfButtons[computerMove].getText()!="");
	   
	return computerMove;
   }
   
   private int minimaxComputerMove(){
	   //http://www.youtube.com/watch?v=3sbGRBjsf0o
	   int computerMove = 0;
	 //o = number of rows, columns or diagonals with two O's and no X
	 //x = number of rows, columns or diagonals with one O and no X
	 //z = number of rows, columns or diagonals with two X's and no O
	 //y = number of rows, columns or diagonals with one X and no O
	 //evaluationFunction = 3*o + x - (3*z + y)
	   
	   //calculate evaluation function for each possible move of O
	   //pick move with maximum value of the evaluation function
	   
	   
	   return computerMove;
   }
   
   private int minimaxEvaluationFunction(int[] arrayX, int[] arrayO){
	   //number of rows, columns or diagonals with two O's and no X
	   int o = calcO(arrayX, arrayO);
	   //number of rows, columns or diagonals with one O and no X
	   int x = calcX(arrayX, arrayO);
	   //number of rows, columns or diagonals with two X's and no O
	   int z = calcZ(arrayX, arrayO);
	   // number of rows, columns or diagonals with one X and no O
	   int y = calcY(arrayX, arrayO);
	   return 3*o + x - (3*z + y);	   
   }
   
   private int calcO(int[] arrayX, int[] arrayO){
	 //number of rows, columns or diagonals with two O's and no X
	   int o = 0;
	   if((arrayO[0]==1)&&(arrayO[1]==1)&&(arrayX[2]==0)||
		  (arrayO[0]==1)&&(arrayX[1]==0)&&(arrayO[2]==1)||
		  (arrayX[0]==0)&&(arrayO[1]==1)&&(arrayO[2]==1))
		   o++;
	   if((arrayO[3]==1)&&(arrayO[4]==1)&&(arrayX[5]==0)||
		  (arrayO[3]==1)&&(arrayX[4]==0)&&(arrayO[5]==1)||
		  (arrayX[3]==0)&&(arrayO[4]==1)&&(arrayO[5]==1))
		   o++;
	   if((arrayO[6]==1)&&(arrayO[7]==1)&&(arrayX[8]==0)||
		  (arrayO[6]==1)&&(arrayX[7]==0)&&(arrayO[8]==1)||
		  (arrayX[6]==0)&&(arrayO[7]==1)&&(arrayO[8]==1))
		   o++;
	   if((arrayO[0]==1)&&(arrayO[3]==1)&&(arrayX[6]==0)||
		  (arrayO[0]==1)&&(arrayX[3]==0)&&(arrayO[6]==1)||
		  (arrayX[0]==0)&&(arrayO[3]==1)&&(arrayO[6]==1))
		   o++;
	   if((arrayO[1]==1)&&(arrayO[4]==1)&&(arrayX[7]==0)||
		  (arrayO[1]==1)&&(arrayX[4]==0)&&(arrayO[7]==1)||
		  (arrayX[1]==0)&&(arrayO[4]==1)&&(arrayO[7]==1))
		   o++;
	   if((arrayO[2]==1)&&(arrayO[5]==1)&&(arrayX[8]==0)||
		  (arrayO[2]==1)&&(arrayX[5]==0)&&(arrayO[8]==1)||
		  (arrayX[2]==0)&&(arrayO[5]==1)&&(arrayO[8]==1))
		   o++;
	   if((arrayO[0]==1)&&(arrayO[4]==1)&&(arrayX[8]==0)||
		   (arrayO[0]==1)&&(arrayX[4]==0)&&(arrayO[8]==1)||
		   (arrayX[0]==0)&&(arrayO[4]==1)&&(arrayO[8]==1))
		    o++;
	   if((arrayO[2]==1)&&(arrayO[4]==1)&&(arrayX[6]==0)||
		  (arrayO[2]==1)&&(arrayX[4]==0)&&(arrayO[6]==1)||
		  (arrayX[2]==0)&&(arrayO[4]==1)&&(arrayO[6]==1))
		   o++;
	   return o;
   }
   
   private int calcX(int[] arrayX, int[] arrayO){
	 //number of rows, columns or diagonals with one O and no X  
	   int x = 0;
	   if((arrayO[0]==1)&&(arrayX[1]==0)&&(arrayX[2]==0)||
		  (arrayX[0]==0)&&(arrayO[1]==1)&&(arrayX[2]==0)||
		  (arrayX[0]==0)&&(arrayX[1]==0)&&(arrayO[2]==1))
		   x++;
	   if((arrayO[3]==1)&&(arrayX[4]==0)&&(arrayX[5]==0)||
		  (arrayX[3]==0)&&(arrayX[4]==0)&&(arrayO[5]==1)||
		  (arrayX[3]==0)&&(arrayO[4]==1)&&(arrayX[5]==0))
		   x++;
	   if((arrayO[6]==1)&&(arrayX[7]==0)&&(arrayX[8]==0)||
		  (arrayX[6]==0)&&(arrayX[7]==0)&&(arrayO[8]==1)||
		  (arrayX[6]==0)&&(arrayO[7]==1)&&(arrayX[8]==0))
		   x++;
	   if((arrayO[0]==1)&&(arrayX[3]==0)&&(arrayX[6]==0)||
		  (arrayX[0]==0)&&(arrayX[3]==0)&&(arrayO[6]==1)||
		  (arrayX[0]==0)&&(arrayO[3]==1)&&(arrayX[6]==0))
		   x++;
	   if((arrayO[1]==1)&&(arrayX[4]==0)&&(arrayX[7]==0)||
		  (arrayX[1]==0)&&(arrayX[4]==0)&&(arrayO[7]==1)||
		  (arrayX[1]==0)&&(arrayO[4]==1)&&(arrayX[7]==0))
		   x++;
	   if((arrayO[2]==1)&&(arrayX[5]==0)&&(arrayX[8]==0)||
		  (arrayX[2]==0)&&(arrayX[5]==0)&&(arrayO[8]==1)||
		  (arrayX[2]==0)&&(arrayO[5]==1)&&(arrayX[8]==0))
		   x++;
	   if((arrayO[0]==1)&&(arrayX[4]==0)&&(arrayX[8]==0)||
		   (arrayX[0]==0)&&(arrayX[4]==0)&&(arrayO[8]==1)||
		   (arrayX[0]==0)&&(arrayO[4]==1)&&(arrayX[8]==0))
		    x++;
	   if((arrayO[2]==1)&&(arrayX[4]==0)&&(arrayX[6]==0)||
		  (arrayX[2]==0)&&(arrayX[4]==0)&&(arrayO[6]==1)||
		  (arrayX[2]==0)&&(arrayO[4]==1)&&(arrayX[6]==0))
		   x++;
	   return x;
   }

   private int calcZ(int[] arrayX, int[] arrayO){
	 //number of rows, columns or diagonals with two X's and no O
	   return calcO(arrayO, arrayX);
   }

   private int calcY(int[] arrayX, int[] arrayO){
	// number of rows, columns or diagonals with one X and no O
	   return calcX(arrayO, arrayX);
   }
    
	
    public void mouseClicked(MouseEvent e) {
    	setPlayerName(PLAYERX);
        javax.swing.JButton currentButton = (JButton)e.getComponent();
        //if the user clicks an empty cell and the computer hasn't already won, mark that cell with X
        if ((currentButton.getText() == "")&&(!checkForWinner())){
                //display player X move in applet
        		currentButton.setText("X");
        		getIndex(currentButton);
        		//communicate player X move (integer) to listeners
                notifyListeners(this, currentButton.getText(), "", Character.toString(currentButton.getName().charAt(6)));
                //if the current move is not winning and there still are empty cells, let the computer play its turn
                //checkForWinner() must be evaluated, because the method highlights the winning combination, use & operator 
                if ((!lastEmptyCell())&(!checkForWinner())){
                	setPlayerName(PLAYERO);
                	
                	//generate random move by computer using java.util.Random.nextInt()
                	//if the randomly generated square is occupied, call the method again
                	//make moves smarter by using minimax strategy

                	int computerMove = getComputerMove();
                	
                	//display computer move in applet
                	arrayOfButtons[computerMove].setText("O");
                	//communicate computer move (integer) to listeners
                	notifyListeners(this, arrayOfButtons[computerMove].getText(), "", String.valueOf(computerMove));
                }
                	checkForWinner();            
        }
    }

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
	
	private boolean findThreeInARow(){
	    if ((arrayOfButtons[0].getText() == arrayOfButtons[1].getText() && arrayOfButtons[1].getText() == arrayOfButtons[2].getText() && arrayOfButtons[0].getText() != "") ||
	    	(arrayOfButtons[3].getText() == arrayOfButtons[4].getText() && arrayOfButtons[4].getText() == arrayOfButtons[5].getText() && arrayOfButtons[3].getText() != "") || 
	        (arrayOfButtons[6].getText() == arrayOfButtons[7].getText() && arrayOfButtons[7].getText() == arrayOfButtons[8].getText() && arrayOfButtons[6].getText() != "") ||
	        (arrayOfButtons[0].getText() == arrayOfButtons[3].getText() && arrayOfButtons[3].getText() == arrayOfButtons[6].getText() && arrayOfButtons[0].getText() != "") ||
            (arrayOfButtons[1].getText() == arrayOfButtons[4].getText() && arrayOfButtons[4].getText() == arrayOfButtons[7].getText() && arrayOfButtons[1].getText() != "") ||
            (arrayOfButtons[2].getText() == arrayOfButtons[5].getText() && arrayOfButtons[5].getText() == arrayOfButtons[8].getText() && arrayOfButtons[2].getText() != "") ||
            (arrayOfButtons[0].getText() == arrayOfButtons[4].getText() && arrayOfButtons[4].getText() == arrayOfButtons[8].getText() && arrayOfButtons[0].getText() != "") ||
            (arrayOfButtons[2].getText() == arrayOfButtons[4].getText() && arrayOfButtons[4].getText() == arrayOfButtons[6].getText() && arrayOfButtons[2].getText() != "")
        )
	        return true;
	    else
	        return false;
    }
	
	private void highlightWinningCombination(){
	    if (arrayOfButtons[0].getText() == arrayOfButtons[1].getText() && arrayOfButtons[1].getText() == arrayOfButtons[2].getText() && arrayOfButtons[0].getText() != ""){
	    	changeColor(arrayOfButtons[0],arrayOfButtons[1],arrayOfButtons[2],WIN_HIGHLIGHT_COLOR);
	    }
		if    	(arrayOfButtons[3].getText() == arrayOfButtons[4].getText() && arrayOfButtons[4].getText() == arrayOfButtons[5].getText() && arrayOfButtons[3].getText() != ""){
			changeColor(arrayOfButtons[3],arrayOfButtons[4],arrayOfButtons[5],WIN_HIGHLIGHT_COLOR);		
		    	}
		if        (arrayOfButtons[6].getText() == arrayOfButtons[7].getText() && arrayOfButtons[7].getText() == arrayOfButtons[8].getText() && arrayOfButtons[6].getText() != ""){
			changeColor(arrayOfButtons[6],arrayOfButtons[7],arrayOfButtons[8],WIN_HIGHLIGHT_COLOR);   	
		        }
		if        (arrayOfButtons[0].getText() == arrayOfButtons[3].getText() && arrayOfButtons[3].getText() == arrayOfButtons[6].getText() && arrayOfButtons[0].getText() != ""){
			changeColor(arrayOfButtons[0],arrayOfButtons[3],arrayOfButtons[6],WIN_HIGHLIGHT_COLOR);    	
		        }
	    if        (arrayOfButtons[1].getText() == arrayOfButtons[4].getText() && arrayOfButtons[4].getText() == arrayOfButtons[7].getText() && arrayOfButtons[1].getText() != ""){
	    	changeColor(arrayOfButtons[1],arrayOfButtons[4],arrayOfButtons[7],WIN_HIGHLIGHT_COLOR);    	
	            }
	    if        (arrayOfButtons[2].getText() == arrayOfButtons[5].getText() && arrayOfButtons[5].getText() == arrayOfButtons[8].getText() && arrayOfButtons[2].getText() != ""){
	    	changeColor(arrayOfButtons[2],arrayOfButtons[5],arrayOfButtons[8],WIN_HIGHLIGHT_COLOR);    	
	            }
	    if       (arrayOfButtons[0].getText() == arrayOfButtons[4].getText() && arrayOfButtons[4].getText() == arrayOfButtons[8].getText() && arrayOfButtons[0].getText() != ""){
	    	changeColor(arrayOfButtons[0],arrayOfButtons[4],arrayOfButtons[8],WIN_HIGHLIGHT_COLOR);    	
	            }
	    if        (arrayOfButtons[2].getText() == arrayOfButtons[4].getText() && arrayOfButtons[4].getText() == arrayOfButtons[6].getText() && arrayOfButtons[2].getText() != ""){
	    	changeColor(arrayOfButtons[2],arrayOfButtons[4],arrayOfButtons[6],WIN_HIGHLIGHT_COLOR);    	
	            }
	        
	}
	
	private void changeColor(JButton jb1, JButton jb2, JButton jb3, Color color){
		jb1.setForeground(color);
		jb2.setForeground(color);
		jb3.setForeground(color);
	}

    //implementing observer design pattern
	
	  protected void addChangeListener(PropertyChangeListener newListener) {
		    listener.add(newListener);
		  }
	  protected void notifyListeners(Object object, String property, String oldValue, String newValue) {
		    for (PropertyChangeListener name : listener) {
		      name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
		    }
		  }
}

