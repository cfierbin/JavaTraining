package tictactoetryitsolution;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class TicTacToe extends Application implements EventHandler<ActionEvent>{
	
    private static final String PLAYERX = "Player X";
    private static final String PLAYERO = "Player O";
    
    private static final String WIN_HIGHLIGHT_COLOR = "magenta";
    
    //Random object used to generate computer moves
    private final java.util.Random randomInstance = new java.util.Random();
	
    private String playerName = PLAYERX;
    
    private Button[] arrayOfButtons = new Button[9];

    private Label playerNumber;
    private Button playAgainButton;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("My First Game in JavaFX");
		
			// Create a GridPane as the root layout node
		GridPane window = new GridPane();
		window.setPadding(new Insets(5));
		window.setHgap(5);
		window.setVgap(5);
			// Create a scene and set its style
		Scene scene = new Scene(window, 410, 450, Color.WHITE);
		scene.getStylesheets()
		.add(getClass().getResource("tictactoestyle.css")
		.toExternalForm());
		
			// Initialize the components		
        for (int i=0; i<9; i++){
            arrayOfButtons[i] = new Button();
           }

        playerNumber = new Label(playerName);
        
        playAgainButton = new Button("Play Again");
        playAgainButton.setOnAction((event)->reset());
               
        	// Set button styles       
    	for(Button button: arrayOfButtons){
    		button.setId("game-button");
    	}
        
        	// Set button size
    	for(Button button: arrayOfButtons){
    		button.setMinSize(130, 130);
    	}
        
        	// Add the components to the window
    	for (int i=0; i < 9; i++) {
    		window.add(arrayOfButtons[i], i % 3, (int) Math.ceil(i/3) );
    	}
        
        GridPane.setColumnSpan(playerNumber, 2);
        window.add(playerNumber,0,3);
        GridPane.setHalignment(playAgainButton, HPos.RIGHT);
        window.add(playAgainButton, 2, 3);
		
			// Add handler code for buttons
        	// using this EventHandler<ActionEvent> interface

           for(Button button: arrayOfButtons){
            button.setOnAction(this);
           }
        
			// Set the scene and display the window
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
    @Override
    public void handle(ActionEvent event) {

    	Button currentButton = (Button) event.getSource();
    	//if the user clicks an empty cell and the computer hasn't already won, mark that cell with X
    	if ((currentButton.getText() == "")&&(!checkForWinner())){
        	setPlayerName(PLAYERX);
    		//display player X move
    		currentButton.setText("X");
    		//if the current move is not winning and there still are empty cells, let the computer play its turn
    		//checkForWinner() must be evaluated, because the method highlights the winning combination, use & operator
    		if ((!lastEmptyCell())&(!checkForWinner())){
    			setPlayerName(PLAYERO);

    			//generate random move by computer using java.util.Random.nextInt()
    			//if the randomly generated square is occupied, call the method again

    			int computerMove = getComputerMove();

    			//display computer move
    			arrayOfButtons[computerMove].setText("O");
    		}
    		checkForWinner();
    	}
    }
    
    private void setPlayerName(String playerName){
        this.playerName = playerName;
        playerNumber.setText(playerName  + " your turn. ");
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
    	for(Button button:arrayOfButtons){
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
    
    private void reset(){

    	for(Button button: arrayOfButtons){
    		button.setText("");
    	   	button.setStyle("  -fx-text-fill: " + "white");
    	}
    	setPlayerName(PLAYERX);
    }
    
    private void highlightWinningCombination(){
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
    }

	public static void main(String[] args) {
		Application.launch(args);

	}

}
