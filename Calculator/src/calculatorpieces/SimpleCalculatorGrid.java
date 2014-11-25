package calculatorpieces;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SimpleCalculatorGrid extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("My First Calculator");
		
			// Create a container
		GridPane gridPane = new GridPane();
		
			// Create a scene
		Scene windowContent = new Scene(gridPane, 400, 100, Color.WHITE);
		
		  	// Instantiate controls
		Label label1 = new Label("Number 1:");
		TextField field1 = new TextField();
		Label label2 = new Label("Number 2:");
		TextField field2 = new TextField();
		Label label3 = new Label("Sum:");
		TextField result = new TextField();
		Button go = new Button("Add");
		
		/*	// Set action code on button using a lambda expression
		 go.setOnMouseClicked(e -> {
			 double number1 = Double.parseDouble(field1.getText());
			 double number2 = Double.parseDouble(field2.getText());
			 double sum = number1 + number2;
			 result.setText(String.valueOf(sum));
			 });
		*/
		 
			// Set action code on button using an anonymous inner class
		 go.setOnAction(new EventHandler<ActionEvent> (){
			 @Override
			 public void handle(ActionEvent e) {
				 double number1 = Double.parseDouble(field1.getText());
				 double number2 = Double.parseDouble(field2.getText());
				 double sum = number1 + number2;
				 result.setText(String.valueOf(sum));
			 }
			 });
		
			// Add controls to the container
		gridPane.add(label1,0,0); 
		gridPane.add(field1,1,0);
		gridPane.add(label2,0,1);
		gridPane.add(field2,1,1);
		gridPane.add(label3,0,2);
		gridPane.add(result,1,2);
		gridPane.add(go,0,3);
		
			// Set the scene and display the window
		primaryStage.setScene(windowContent);
		primaryStage.show();

	}
	
	public static void main(String[] args) {
		Application.launch(args);

	}

}
