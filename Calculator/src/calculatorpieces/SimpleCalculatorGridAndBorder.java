package calculatorpieces;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SimpleCalculatorGridAndBorder extends Application {
	
	// Declare all calculator's components.
	private TextField displayField;
	private Button button0;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Button button7;
	private Button button8;
	private Button button9;
	private Button buttonPoint;
	private Button buttonEqual;
	
    public void setDisplayValue(String val){
        displayField.setText(val);
    }

    public String getDisplayValue() {
        return displayField.getText();
    }
    

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Calculator");
		
			// Create BorderPane as the root layout node
  	  	BorderPane windowContent = new BorderPane();
  	  	Scene scene = new Scene(windowContent, 380, 150, Color.WHITE);
  	  	
  	  		// Create the display field and place it at the Top area of the window
  	  	displayField = new TextField();
  	  	windowContent.setTop(displayField);
  
  	  		// Create the components
    	button0 = new Button("0");
  	  	button1 = new Button("1");
  	  	button2  =new Button("2");
  	  	button3 = new Button("3");
  	  	button4 = new Button("4");
  	  	button5 = new Button("5");
  	  	button6 = new Button("6");
  	  	button7 = new Button("7");
  	  	button8 = new Button("8");
  	  	button9 = new Button("9");
  	  	buttonPoint = new Button(".");
  	  	buttonEqual = new Button("=");
  	  	
  	  		// Set a large preferred size of the buttons, so that they fill the whole space
  	  		//in their container (GridPane)
  	  	button0.setPrefSize(800, 800);
  	  	button1.setPrefSize(800, 800);
  	  	button2.setPrefSize(800, 800);
  	  	button3.setPrefSize(800, 800);
  	  	button4.setPrefSize(800, 800);
	  	button5.setPrefSize(800, 800);
	  	button6.setPrefSize(800, 800);
	  	button7.setPrefSize(800, 800);
	  	button8.setPrefSize(800, 800);
	  	button9.setPrefSize(800, 800);
 	  	buttonPoint.setPrefSize(800, 800);
  	  	buttonEqual.setPrefSize(800, 800);
  	  	
  	  	
  	  		// Create a GridPane node to hold 12 buttons – 
  	  		//10 numeric ones, period, and the equal sign
  	  	
  	  	GridPane gridPane = new GridPane();
  	  	
  	  		// Add buttons to the gridPane
  	  	gridPane.add(button0,0,0); 
		gridPane.add(button1,1,0);
		gridPane.add(button2,2,0);
		gridPane.add(button3,0,1);
		gridPane.add(button4,1,1);
  	  	gridPane.add(button5,2,1); 
		gridPane.add(button6,0,2);
		gridPane.add(button7,1,2);
		gridPane.add(button8,2,2);
		gridPane.add(button9,0,3);
		gridPane.add(buttonPoint,1,3);
		gridPane.add(buttonEqual,2,3);
		
			// Set action code on buttons
		SimpleCalculatorEngine calcEngine = new SimpleCalculatorEngine(this);
		button0.setOnAction(calcEngine);
		button1.setOnAction(calcEngine);
		button2.setOnAction(calcEngine);
		button3.setOnAction(calcEngine);
		button4.setOnAction(calcEngine);
		button5.setOnAction(calcEngine);
		button6.setOnAction(calcEngine);
		button7.setOnAction(calcEngine);
		button8.setOnAction(calcEngine);
		button9.setOnAction(calcEngine);
		buttonPoint.setOnAction(calcEngine);
		buttonEqual.setOnAction(calcEngine);
				
			// Place the gridPane with buttons at the Center of the window(BorderPane)
		windowContent.setCenter(gridPane);
  	  
  	  		// Set the scene and display the window
  	  	primaryStage.setScene(scene);
  	  	primaryStage.show();
						
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
