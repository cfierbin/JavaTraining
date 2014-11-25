package calculatorpieces;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SimpleCalculator extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("My First Calculator");
		
			// Create a container
		FlowPane flowPane = new FlowPane();
		
			// Create a scene
		Scene windowContent = new Scene(flowPane, 400, 100, Color.WHITE);
		
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
		flowPane.getChildren().add(label1); 
		flowPane.getChildren().add(field1);
		flowPane.getChildren().add(label2);
		flowPane.getChildren().add(field2);
		flowPane.getChildren().add(label3);
		flowPane.getChildren().add(result);
		flowPane.getChildren().add(go);
		
			// Set the scene and display the window
		primaryStage.setScene(windowContent);
		primaryStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
