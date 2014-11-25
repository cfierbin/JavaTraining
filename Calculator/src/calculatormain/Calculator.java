package calculatormain;

import javafx.application.Application;
import javafx.stage.Stage;

public class Calculator extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Calculator");
	
    	// Create the calculator
	SimpleCalculatorPane simpleCalculatorPane = new SimpleCalculatorPane(primaryStage);

	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
