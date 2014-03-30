package homework;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyCustomizableGUI extends Application{
	
	private int textOriginX = 20;
	private int textOriginY = 70;
	private int fontSize = 40;
	private String fontName = "SansSerif";
	private Color colorName = Color.DARKGOLDENROD;

	
	public static void main(String[] args){
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage){
		primaryStage.setTitle("Lesson 17. Customizable GUI. Serialization");
		//The first node in the tree is called the root node, and it never has a parent. 
		Group rootNode = new Group();
		Scene scene = new Scene(rootNode, 400, 250, Color.WHITE);
		
		Text text = new Text(textOriginX,textOriginY, "JavaFX is awesome!");
		text.setFont(Font.font(fontName,fontSize));
		text.setFill(colorName);
		
		Button userPreferencesButton = new Button("User Preferences");
		userPreferencesButton.setLayoutX(150);
		userPreferencesButton.setLayoutY(150);
		
		//open a new window when the user presses the button
		userPreferencesButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Stage secondStage = new Stage();
                secondStage.setX(900);
                secondStage.setY(100);
                secondStage.setTitle("Preferences");
            	Group rootNode = new Group();  
                PreferencesScene secondScene = new PreferencesScene(rootNode,280,170);
                secondStage.setScene(secondScene); 
                secondStage.show();
            }
		});
		
		rootNode.getChildren().add(text);
		rootNode.getChildren().add(userPreferencesButton);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
