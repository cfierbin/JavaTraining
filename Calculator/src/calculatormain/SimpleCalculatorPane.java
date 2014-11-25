package calculatormain;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SimpleCalculatorPane extends CalculatorPane{
	
	public SimpleCalculatorPane(Stage primaryStage){
		super();
		
			// Create the menu bar
	MenuBar menuBar = new MenuBar();
	Menu viewMenu = new Menu("View");
	RadioMenuItem simpleCalculatorMenuItem = new RadioMenuItem("Simple");
	simpleCalculatorMenuItem.setSelected(true);
	MenuItem standardCalculatorMenuItem = new MenuItem("Standard");
	viewMenu.getItems().addAll(simpleCalculatorMenuItem, standardCalculatorMenuItem);
	menuBar.getMenus().add(viewMenu);
	
		// Handler code for menu items
	standardCalculatorMenuItem.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent t) {                 
			               StandardCalculatorPane simpleCalculatorPane = new StandardCalculatorPane(primaryStage);
		}
	});
	
			// Create a GridPane as the root layout node
	GridPane window = new GridPane();
	window.setPadding(new Insets(5));
	window.setHgap(5);
	window.setVgap(5);
	Scene scene = new Scene(window, 500, 250, Color.WHITE);
	  	
	  		// Add the menu bar to the window
	window.add(menuBar, 0, 0);
		
			// Create a BorderPane for the calculator
	BorderPane windowContent = new BorderPane();
	  	
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
	  	
	buttonPlus = new Button("+");
	buttonMinus = new Button("-");
	buttonMult = new Button("*");
	buttonDiv = new Button("/");
	  	
	  		// Set a large preferred size of the buttons, so that they fill the whole space
	  		//in their container
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
	  	
	buttonPlus.setPrefSize(80, 800);
	buttonMinus.setPrefSize(80, 800);
	buttonMult.setPrefSize(80, 800);
	buttonDiv.setPrefSize(80, 800);
	  	  	
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
	
		// Create a VBox and add Plus, Minus, Mult, Div buttons to it
	VBox operations = new VBox();
	operations.getChildren().add(buttonPlus);
	operations.getChildren().add(buttonMinus);
	operations.getChildren().add(buttonMult);
	operations.getChildren().add(buttonDiv);
	
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
			
		// Place the gridPane with buttons at the Center of the window(BorderPane)
	windowContent.setCenter(gridPane);
	
		// Place the VBox with operation buttons (Plus, Minus, Div, Mult) 
		//at the Right area of the border pane
	windowContent.setRight(operations);
	
	window.add(windowContent, 0, 1);
	  
	  	// Set the scene and display the window
	primaryStage.setScene(scene);
	primaryStage.show();
		
	}

}

