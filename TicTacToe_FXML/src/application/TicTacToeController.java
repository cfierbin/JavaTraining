package application;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class TicTacToeController {
	
    private static final String PLAYERX = "Player X";
    private static final String PLAYERO = "Player O";
    private String playerName = PLAYERX;
    private static final String WIN_HIGHLIGHT_COLOR = "magenta";
    
    //Random object used to generate computer moves
    private final java.util.Random randomInstance = new java.util.Random();
    
    @FXML private Button button1;
    @FXML private Button button2;
    @FXML private Button button3;
    @FXML private Button button4;
    @FXML private Button button5;
    @FXML private Button button6;
    @FXML private Button button7;
    @FXML private Button button8;
    @FXML private Button button9;
           
    @FXML private Label playerNumber;
    @FXML private Button playAgainButton;
	
	@FXML
    private void handleButtonClicked(ActionEvent event) {
		
		Button arrayOfButtons[] = {button1, button2,
				button3, button4, button5, button6, button7, button8, button9};

    	Button currentButton = (Button) event.getSource();
    	//if the user clicks an empty cell and the computer hasn't already won, mark that cell with X
    	if ( ("".equals(currentButton.getText())) && (!checkForWinner(arrayOfButtons)) ) {
        	setPlayerName(PLAYERX);
    		//display player X move
    		currentButton.setText("X");
    		//if the current move is not winning and there still are empty cells, let the computer play its turn
    		//checkForWinner() must be evaluated, because the method highlights the winning combination, use & operator
    		if ((!lastEmptyCell(arrayOfButtons))&(!checkForWinner(arrayOfButtons))){
    			setPlayerName(PLAYERO);

    			//generate random move by computer using java.util.Random.nextInt()
    			//if the randomly generated square is occupied, call the method again

    			int computerMove = getComputerMove(arrayOfButtons);

    			//display computer move
    			arrayOfButtons[computerMove].setText("O");
 
    		}
    		if ( (!checkForWinner(arrayOfButtons)) && lastEmptyCell(arrayOfButtons) )
    			playerNumber.setText("There is no winner.");
    	}
    }
	
    private void setPlayerName(String playerName){
        this.playerName = playerName;
  //      playerNumber.setText(playerName  + " your turn. ");
    }
	
    private boolean checkForWinner(Button arrayOfButtons[]){
    	   	
    	//returns true if there is a winner
    	if(findThreeInARow()){
    		//highlight winning combination
    		highlightWinningCombination(arrayOfButtons);
    		//determine and display the name of the winner
    		playerNumber.setText(playerName.concat(" won!!!"));
    		return true;
    	}
    	else {
    		return false;
    	} 
    }
    
    private boolean lastEmptyCell(Button arrayOfButtons[]){
    	//returns true if all the cells are occupied
    	for(Button button:arrayOfButtons){
    		if ("".equals(button.getText()))
    			return false;
    	}
    	return true;
    }
    
    private int getComputerMove(Button arrayOfButtons[]){
    	int computerMove;
    	//generate random move by computer until it finds an empty cell
    	do {
    		computerMove = randomInstance.nextInt(9);
    	}
    	while(arrayOfButtons[computerMove].getText()!="");

    	return computerMove;
    }
	   
    private boolean findThreeInARow(){
    	if ((button1.getText() == button2.getText() && button2.getText() == button3.getText() && button1.getText() != "") ||
    			(button4.getText() == button5.getText() && button5.getText() == button6.getText() && button4.getText() != "") || 
    			(button7.getText() == button8.getText() && button8.getText() == button9.getText() && button7.getText() != "") ||
    			(button1.getText() == button4.getText() && button4.getText() == button7.getText() && button1.getText() != "") ||
    			(button2.getText() == button5.getText() && button5.getText() == button8.getText() && button2.getText() != "") ||
    			(button3.getText() == button6.getText() && button6.getText() == button9.getText() && button3.getText() != "") ||
    			(button1.getText() == button5.getText() && button5.getText() == button9.getText() && button1.getText() != "") ||
    			(button3.getText() == button5.getText() && button5.getText() == button7.getText() && button3.getText() != "")
    			)
    		return true;
    	else
    		return false;
    }
    
    /*
    
    private void highlightWinningCombination(){
    	if (button1.getText() == button2.getText() && button2.getText() == button3.getText() && button1.getText() != ""){
    		changeColor(button1,button2,button3,WIN_HIGHLIGHT_COLOR);
    	}
    	if (button4.getText() == button5.getText() && button5.getText() == button6.getText() && button4.getText() != ""){
    		changeColor(button4,button5,button6,WIN_HIGHLIGHT_COLOR);	
    	}
    	if (button7.getText() == button8.getText() && button8.getText() == button9.getText() && button7.getText() != ""){
    		changeColor(button7,button8,button9,WIN_HIGHLIGHT_COLOR);
    	}
    	if (button1.getText() == button4.getText() && button4.getText() == button7.getText() && button1.getText() != ""){
    		changeColor(button1,button4,button7,WIN_HIGHLIGHT_COLOR);
    	}
    	if (button2.getText() == button5.getText() && button5.getText() == button8.getText() && button2.getText() != ""){
    		changeColor(button2,button5,button8,WIN_HIGHLIGHT_COLOR);
    	}
    	if (button3.getText() == button6.getText() && button6.getText() == button9.getText() && button3.getText() != ""){
    		changeColor(button3,button6,button9,WIN_HIGHLIGHT_COLOR);
    	}
    	if (button1.getText() == button5.getText() && button5.getText() == button9.getText() && button1.getText() != ""){
    		changeColor(button1,button5,button9,WIN_HIGHLIGHT_COLOR);
    	}
    	if (button3.getText() == button5.getText() && button5.getText() == button7.getText() && button3.getText() != ""){
    		changeColor(button3,button5,button7,WIN_HIGHLIGHT_COLOR);
    	}

    }
    
    */
    
    private void highlightWinningCombination(Button arrayOfButtons[]){
    	if (arrayOfButtons[0].getText() == arrayOfButtons[1].getText() && arrayOfButtons[1].getText() == arrayOfButtons[2].getText() && arrayOfButtons[0].getText() != ""){
    		changeColor(arrayOfButtons[0],arrayOfButtons[1],arrayOfButtons[2],WIN_HIGHLIGHT_COLOR);
    	}
    	if (arrayOfButtons[3].getText() == arrayOfButtons[4].getText() && arrayOfButtons[4].getText() == arrayOfButtons[5].getText() && arrayOfButtons[3].getText() != ""){
    		changeColor(arrayOfButtons[3],arrayOfButtons[4],arrayOfButtons[5],WIN_HIGHLIGHT_COLOR);	
    	}
    	if (arrayOfButtons[6].getText() == arrayOfButtons[7].getText() && arrayOfButtons[7].getText() == arrayOfButtons[8].getText() && arrayOfButtons[6].getText() != ""){
    		changeColor(arrayOfButtons[6],arrayOfButtons[7],arrayOfButtons[8],WIN_HIGHLIGHT_COLOR);
    	}
    	if (arrayOfButtons[0].getText() == arrayOfButtons[3].getText() && arrayOfButtons[3].getText() == arrayOfButtons[6].getText() && arrayOfButtons[0].getText() != ""){
    		changeColor(arrayOfButtons[0],arrayOfButtons[3],arrayOfButtons[6],WIN_HIGHLIGHT_COLOR);
    	}
    	if (arrayOfButtons[1].getText() == arrayOfButtons[4].getText() && arrayOfButtons[4].getText() == arrayOfButtons[7].getText() && arrayOfButtons[1].getText() != ""){
    		changeColor(arrayOfButtons[1],arrayOfButtons[4],arrayOfButtons[7],WIN_HIGHLIGHT_COLOR);
    	}
    	if (arrayOfButtons[2].getText() == arrayOfButtons[5].getText() && arrayOfButtons[5].getText() == arrayOfButtons[8].getText() && arrayOfButtons[2].getText() != ""){
    		changeColor(arrayOfButtons[2],arrayOfButtons[5],arrayOfButtons[8],WIN_HIGHLIGHT_COLOR);
    	}
    	if (arrayOfButtons[0].getText() == arrayOfButtons[4].getText() && arrayOfButtons[4].getText() == arrayOfButtons[8].getText() && arrayOfButtons[0].getText() != ""){
    		changeColor(arrayOfButtons[0],arrayOfButtons[4],arrayOfButtons[8],WIN_HIGHLIGHT_COLOR);
    	}
    	if (arrayOfButtons[2].getText() == arrayOfButtons[4].getText() && arrayOfButtons[4].getText() == arrayOfButtons[6].getText() && arrayOfButtons[2].getText() != ""){
    		changeColor(arrayOfButtons[2],arrayOfButtons[4],arrayOfButtons[6],WIN_HIGHLIGHT_COLOR);
    	}

    }

    private void changeColor(Button b1, Button b2, Button b3, String color){
    	b1.setStyle("  -fx-text-fill: " + color);
       	b2.setStyle("  -fx-text-fill: " + color);
       	b3.setStyle("  -fx-text-fill: " + color);
       	
        Timeline blinker1 = createBlinker(b1);
        Timeline blinker2 = createBlinker(b2);
        Timeline blinker3 = createBlinker(b3);
        
        SequentialTransition blink1 = new SequentialTransition(
                b1,
                blinker1
        );
        
        blink1.play();
        
        SequentialTransition blink2 = new SequentialTransition(
                b2,
                blinker2
        );
        
        blink2.play();
        
        SequentialTransition blink3 = new SequentialTransition(
                b3,
                blinker3
        );
        
        blink3.play();
    }
    
    @FXML
    private void reset(){
        button1.setText("");
	   	button1.setStyle("  -fx-text-fill: " + "white");
        button2.setText("");
	   	button2.setStyle("  -fx-text-fill: " + "white");
        button3.setText("");
	   	button3.setStyle("  -fx-text-fill: " + "white");
        button4.setText("");
	   	button4.setStyle("  -fx-text-fill: " + "white");
        button5.setText("");
	   	button5.setStyle("  -fx-text-fill: " + "white");
        button6.setText("");
	   	button6.setStyle("  -fx-text-fill: " + "white");
        button7.setText("");
	   	button7.setStyle("  -fx-text-fill: " + "white");
        button8.setText("");
	   	button8.setStyle("  -fx-text-fill: " + "white");
        button9.setText("");
	   	button9.setStyle("  -fx-text-fill: " + "white");
	   	playerNumber.setText("");
        setPlayerName(PLAYERX);
    }
    
    private Timeline createBlinker(Node node) {
        Timeline blink = new Timeline(
                new KeyFrame(
                        Duration.seconds(0),
                        new KeyValue(
                                node.opacityProperty(), 
                                1, 
                                Interpolator.DISCRETE
                        )
                ),
                new KeyFrame(
                        Duration.seconds(0.5),
                        new KeyValue(
                                node.opacityProperty(), 
                                0, 
                                Interpolator.DISCRETE
                        )
                ),
                new KeyFrame(
                        Duration.seconds(1),
                        new KeyValue(
                                node.opacityProperty(), 
                                1, 
                                Interpolator.DISCRETE
                        )
                )
        );
        blink.setCycleCount(5);

        return blink;
    }
	
}
