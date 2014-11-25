package morecalculatorpieces;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Calculator extends Application {
	
	private final double BUTTON_PREF_WIDTH = 800;
	private final double BUTTON_PREF_HEIGHT = 800;
	
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
	private Button buttonPlus;
	private Button buttonMinus;
	private Button buttonMult;
	private Button buttonDiv;
	
	private Button buttonSQRT;
	private Button buttonMOD;
	private Button buttonINV;
	private Button buttonOPP;
	
	private Button buttonBackspace;
	private Button buttonCE;
	private Button buttonC;
	
	private Button buttonMC;
	private Button buttonMR;
	private Button buttonMS;
	private Button buttonMPlus;
		
	
	// Define getter and overloaded setters for the display field
	
	   public String getDisplayValue() {
	        return displayField.getText();
	    }
	
    public void setDisplayValue(String val){
    	String textColor = "  -fx-text-fill: black";
    	displayField.setStyle(textColor);
        displayField.setText(val);
    }
    
    public void setDisplayValue(String val, String color){
    	String textColor = "  -fx-text-fill: " + color;
    	displayField.setStyle(textColor);
        displayField.setText(val);
    }
       

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Calculator");
		
			// Create the menu bar
		MenuBar menuBar = new MenuBar();
		Menu viewMenu = new Menu("View");
		MenuItem simpleCalculatorMenuItem = new MenuItem("Simple");
		viewMenu.getItems().add(simpleCalculatorMenuItem);
		menuBar.getMenus().add(viewMenu);
		
			// Create a GridPane as the root layout node
  	  	GridPane windowContent = new GridPane();
  	  	windowContent.setPadding(new Insets(5));
  	  	windowContent.setHgap(5);
  	  	windowContent.setVgap(5);
  	  	Scene scene = new Scene(windowContent, 500, 250, Color.WHITE);
  	  	
  	  		// Add the menu bar to the window
  	  	windowContent.add(menuBar, 0, 0);
  	  	
  	  		// Create the display field and set the corresponding constraints
  	  	displayField = new TextField();
  	  	GridPane.setColumnSpan(displayField, 6); // this cell is as wide as 6 other ones
  	  	GridPane.setRowSpan(displayField, 1); // this cell has the same height as other cells
  	  	GridPane.setFillHeight(displayField, true);
  	  	GridPane.setFillWidth(displayField, true); // fill all space in the cell
  	  	GridPane.setHalignment(displayField, HPos.CENTER);
  	  	GridPane.setValignment(displayField, VPos.CENTER); // position within the cell
  	  	GridPane.setHgrow(displayField, Priority.ALWAYS);
  	  	GridPane.setVgrow(displayField, Priority.ALWAYS); // grow larger than the preferred size if there is space
  	  	
  	  		// Add the display field to the window
  	  	windowContent.add(displayField, 0, 1);
  
  	  		// Create the buttons
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
  	  	
  	  	buttonPlus = new Button("+");
  	  	buttonMinus = new Button("-");
  	  	buttonMult = new Button("*");
  	  	buttonDiv = new Button("/");
  	  	
  	  	buttonSQRT = new Button("sqrt");
  	  	buttonMOD = new Button("%");
  	  	buttonINV = new Button("1/x");
  	  	buttonOPP = new Button("+/-");
  	
  	  	buttonBackspace = new Button("Backspace");
  	  	buttonCE = new Button("CE");
  	  	buttonC = new Button("C");
  	
  	  	buttonMC = new Button("MC");
  	  	buttonMR = new Button("MR");
  	  	buttonMS = new Button("MS");
  	  	buttonMPlus = new Button("M+");
  	  	
  	  		// Set a large preferred size of the buttons, 
  	  		// so that they fill the whole space
  	  		// in their container
  	  	button0.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
  	  	button1.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
  	  	button2.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
  	  	button3.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
  	  	button4.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	button5.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	button6.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	button7.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	button8.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	button9.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
 	  	buttonPoint.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
  	  	buttonEqual.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
  	  	
  	  	buttonPlus.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	buttonMinus.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	buttonMult.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	buttonDiv.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	
	  	buttonMC.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	buttonMR.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	buttonMS.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	buttonMPlus.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
	  	
	  	buttonSQRT.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
  	  	buttonMOD.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
  	  	buttonINV.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
  	  	buttonOPP.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
  	
  	  	buttonBackspace.setPrefSize(200, 800);
  	  	buttonCE.setPrefSize(200, 800);
  	  	buttonC.setPrefSize(200, 800);
 	  	  	  	  	
  	  		// Add the buttons to the window
	  	windowContent.add(button0,1,6); 
	  	windowContent.add(button1,1,5);
	  	windowContent.add(button2,2,5);
	  	windowContent.add(button3,3,5);
	  	windowContent.add(button4,1,4);
	  	windowContent.add(button5,2,4); 
	  	windowContent.add(button6,3,4);
	  	windowContent.add(button7,1,3);
	  	windowContent.add(button8,2,3);
	  	windowContent.add(button9,3,3);
	  	windowContent.add(buttonPoint,3,6);
	  	windowContent.add(buttonSQRT,5,3);
	  	windowContent.add(buttonMOD,5,4);
	  	windowContent.add(buttonINV,5,5);
	  	windowContent.add(buttonEqual,5,6);
	  	windowContent.add(buttonOPP,2,6);
		  	
	  	GridPane.setRowIndex(buttonPlus, 6);
	  	GridPane.setColumnIndex(buttonPlus, 4);
	  	GridPane.setRowIndex(buttonMinus, 5);
	  	GridPane.setColumnIndex(buttonMinus, 4);
	  	GridPane.setRowIndex(buttonMult, 4);
	  	GridPane.setColumnIndex(buttonMult, 4);
	  	GridPane.setRowIndex(buttonDiv, 3);
	  	GridPane.setColumnIndex(buttonDiv, 4);
	  	windowContent.getChildren().addAll(buttonPlus, buttonMinus, buttonMult, buttonDiv);
	  	
	  		// First column
	  	GridPane.setRowIndex(buttonMC, 3);
	  	GridPane.setColumnIndex(buttonMC, 0);
  	  	buttonMC.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);
  	  	
	  	GridPane.setRowIndex(buttonMR, 4);
	  	GridPane.setColumnIndex(buttonMR, 0);
	  	GridPane.setRowIndex(buttonMS, 5);
	  	GridPane.setColumnIndex(buttonMS, 0);
	  	GridPane.setRowIndex(buttonMPlus, 6);
	  	GridPane.setColumnIndex(buttonMPlus, 0);
	
	  	windowContent.getChildren().addAll(buttonMC, buttonMR, buttonMS, buttonMPlus);
	  	
	  		// First row
	  	GridPane.setHalignment(buttonBackspace, HPos.LEFT);
  	  	GridPane.setColumnSpan(buttonBackspace, 2);
  	  	GridPane.setFillHeight(buttonBackspace, true);
  	  	GridPane.setFillWidth(buttonBackspace, true); // fill all space in the cell
	  	GridPane.setHgrow(buttonBackspace, Priority.ALWAYS);
	  	GridPane.setVgrow(buttonBackspace, Priority.ALWAYS);
  	  	GridPane.setMargin(buttonBackspace, new Insets(2,40,2,2));
	  	windowContent.add(buttonBackspace, 1, 2);
	  	
	  	GridPane.setHalignment(buttonCE, HPos.CENTER);
  	  	GridPane.setColumnSpan(buttonCE, 3);
  	  	GridPane.setMargin(buttonCE, new Insets(2,40,2,40));
	  	windowContent.add(buttonCE, 2, 2);
	  	
	  	GridPane.setHalignment(buttonC, HPos.RIGHT);
  	  	GridPane.setColumnSpan(buttonC, 2);
  	  	GridPane.setMargin(buttonC, new Insets(2,2,2,40));
	  	windowContent.add(buttonC, 4, 2);
		
			// Set action code on buttons
		CalculatorEngine calcEngine = new CalculatorEngine(this);
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
		
		buttonPlus.setOnAction(calcEngine);
		buttonMinus.setOnAction(calcEngine);
		buttonMult.setOnAction(calcEngine);
		buttonDiv.setOnAction(calcEngine);
		
			// Add handler code for menu items
		simpleCalculatorMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {                 
 //               SimpleCalculatorPane simpleCalculatorPane = new SimpleCalculatorPane(primaryStage);
			}
		});
					  
  	  		// Set the scene and display the window
  	  	primaryStage.setScene(scene);
  	  	primaryStage.show();
						
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}


