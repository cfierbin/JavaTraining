

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class TicTacToe extends Application implements EventHandler<ActionEvent>{
	
    private static final String PLAYERX = "Player X";
    private static final String PLAYERO = "Player O";
	
    private String playerName = PLAYERX;
    
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Label playerNumber;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("My First Game in JavaFX");
		
			// Create a GridPane as the root layout node
		GridPane window = new GridPane();
		window.setPadding(new Insets(5));
		window.setHgap(5);
		window.setVgap(5);
			// Create a scene and set its CSS stylesheet
		Scene scene = new Scene(window, 410, 450, Color.WHITE);
		scene.getStylesheets()
		.add(getClass().getResource("tictactoestyle.css")
		.toExternalForm());
		
			// Initialize the components
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        button5 = new Button();
        button6 = new Button();
        button7 = new Button();
        button8 = new Button();
        button9 = new Button();
        playerNumber = new Label(playerName);
        
        	// Set button styles
        button1.setId("game-button");
        button2.setId("game-button");
        button3.setId("game-button");
        button4.setId("game-button");
        button5.setId("game-button");
        button6.setId("game-button");
        button7.setId("game-button");
        button8.setId("game-button");
        button9.setId("game-button");
        
        	// Set button size
        button1.setMinSize(130, 130);
        button2.setMinSize(130, 130);
        button3.setMinSize(130, 130);
        button4.setMinSize(130, 130);
        button5.setMinSize(130, 130);
        button6.setMinSize(130, 130);
        button7.setMinSize(130, 130);
        button8.setMinSize(130, 130);
        button9.setMinSize(130, 130);
        
        	// Add the buttons to the window
        window.add(button1, 0, 0);
        window.add(button2, 1, 0);
        window.add(button3, 2, 0);
        window.add(button4, 0, 1);
        window.add(button5, 1, 1);
        window.add(button6, 2, 1);
        window.add(button7, 0, 2);
        window.add(button8, 1, 2);
        window.add(button9, 2, 2);
        
        window.add(playerNumber,0,3);
		
			// Add handler code for buttons
        		// using this EventHandler<ActionEvent> interface
        button1.setOnAction(this);
        
        		// using an anonymous inner class     
        button2.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
            	Button currentButton = (Button) event.getSource();
                if (currentButton.getText() == ""){
                    if (playerName == PLAYERX) {
                        currentButton.setText("X");
                        setPlayerName(PLAYERO);
                    } 
                    else if (playerName == PLAYERO){
                        currentButton.setText("O");
                        setPlayerName(PLAYERX);
                    }
                }
                checkForWinner();
        	}
         });
         
        		// using a lambda expression with code block surrounded by curly braces
        button3.setOnAction((ActionEvent event) -> {
        	Button currentButton = (Button) event.getSource();
            if (currentButton.getText() == ""){
                if (playerName == PLAYERX) {
                    currentButton.setText("X");
                    setPlayerName(PLAYERO);
                } 
                else if (playerName == PLAYERO){
                    currentButton.setText("O");
                    setPlayerName(PLAYERX);
                }
            }
            checkForWinner();
        } );
        
        		// using one-line statement lambda expressions
        button4.setOnAction((ActionEvent event) -> handle(event));
        button5.setOnAction(event -> handle(event));
        button6.setOnAction(event -> handle(event));
        button7.setOnAction(event -> handle(event));
        button8.setOnAction(event -> handle(event));
        button9.setOnAction(event -> handle(event));
        
			// Set the scene and display the window
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
    @Override
	public void handle(ActionEvent event) {
    	Button currentButton = (Button) event.getSource();
        if (currentButton.getText() == ""){
            if (playerName == PLAYERX) {
                currentButton.setText("X");
                setPlayerName(PLAYERO);
            } 
            else if (playerName == PLAYERO){
                currentButton.setText("O");
                setPlayerName(PLAYERX);
            }
        }
        checkForWinner();
    	}
	
    private void setPlayerName(String playerName){
        this.playerName = playerName;
        playerNumber.setText(playerName  + " your turn. ");
    }
	
    private void checkForWinner(){

    	if(findThreeInARow()){
    		String winnerName=(playerName == PLAYERX)?PLAYERO:PLAYERX;
    		
    			// Display winner's name in a new window
    			// Use either MyDialogStage that extends Stage or 
    			// the piece of code commented out below 
    		MyDialogStage dialog = new MyDialogStage("Congratulations!", 
    				winnerName.concat(" won!!! Congratulations!!!"));
    		
    	/*
    		Stage dialog = new Stage();
    		dialog.setTitle("Congratulations!");
    			// dialog window prevents all other windows from receiving events
    		dialog.initModality(Modality.APPLICATION_MODAL);
    			// dialog window has only close icon
    		dialog.initStyle(StageStyle.UTILITY);
    		Label congrats = new Label(winnerName.concat(" won!!! Congratulations!!!"));
    			// congrats.setTextFill(Color.RED);
    		congrats.setStyle("	-fx-text-fill: red; -fx-font-size: 20px;");  		
    		Scene scene = new Scene(new StackPane(congrats),350,100); 		
    		dialog.setScene(scene);
    			// show and stop execution until the user closes the dialog window
    		dialog.showAndWait();
    	*/	
    			// Reset buttons (clear text)
	        reset();  		 
    	}  

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

	public static void main(String[] args) {
		Application.launch(args);

	}

}
