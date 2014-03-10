package com.practicaljava.lesson11;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class TicTacToeApplet extends JApplet implements MouseListener
{
    private static final String PLAYERX = "Player X";
    private static final String PLAYERO = "Player O";
    private static final int BUTTON_FONT_SIZE = 40;
    private static final Color WIN_HIGHLIGHT_COLOR = Color.magenta;
	
    private String playerName = PLAYERX;
    
    private javax.swing.JButton[] arrayOfButtons = new javax.swing.JButton[9];
    
    private javax.swing.JButton playAgain;
	
    private javax.swing.JLabel playerNumber;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel basePanel;

    public void init(){
        initComponents();
    }

    private void initComponents(){
        buttonsPanel = new javax.swing.JPanel();
        buttonsPanel.setLayout(new java.awt.GridLayout(3, 3));
        bottomPanel = new javax.swing.JPanel();
        bottomPanel.setLayout(new java.awt.FlowLayout());
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
        Font buttonFont = new Font("Times New Roman", Font.PLAIN, BUTTON_FONT_SIZE);
        for (int i=0; i<9; i++){
        	arrayOfButtons[i] = new javax.swing.JButton();
        }
        for(javax.swing.JButton button: arrayOfButtons){
        	button.addMouseListener(this);
        	button.setFont(buttonFont);
        	buttonsPanel.add(button);
        }       
        setPlayerName(PLAYERX); 
        bottomPanel.add(playerNumber);
        bottomPanel.add(playAgain);
        basePanel.add(buttonsPanel);
        basePanel.add(bottomPanel);
        add(basePanel);
    }
	
    private void setPlayerName(String playerName){
        this.playerName = playerName;
  //      playerNumber.setText(playerName  + " your turn. ");
    }
	
    private void reset(){
        for(javax.swing.JButton button: arrayOfButtons){
        	button.setText("");
        	button.setForeground(Color.black);
        }
        setPlayerName(PLAYERX);
        playerNumber.setText("");
    }
	
   public void checkForWinner(){
        if(findThreeInARow()){
        	//highlight winning combination
        	highlightWinningCombination();
        	//determine and display the name of the winner
            String winnerName=(playerName == PLAYERX)?PLAYERO:PLAYERX;
            playerNumber.setText(winnerName.concat(" won!!! Congratulations!!!"));
        }    
        
    }
    
	
    public void mouseClicked(MouseEvent e) {
        javax.swing.JButton currentButton = (JButton)e.getComponent();
        if (currentButton.getText() == ""){
           // if (playerName == PLAYERX) {
        		setPlayerName(PLAYERX);
                currentButton.setText("X");
                checkForWinner();
                setPlayerName(PLAYERO);
                //generate random move by computer using java.util.Random.nextInt()
                //if the randomly generated square is occupied, call the method again
                //make moves smarter by using minimax strategy
                java.util.Random randomInstance = new java.util.Random();
                int computerMove;
                do {
                	computerMove = randomInstance.nextInt(9);
                }
                while(arrayOfButtons[computerMove].getText()!="");
                arrayOfButtons[computerMove].setText("O");
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
}