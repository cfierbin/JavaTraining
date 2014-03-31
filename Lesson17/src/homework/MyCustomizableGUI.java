package homework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyCustomizableGUI extends Application{
	
	private int textOriginX = 20;
	private int textOriginY = 70;
	private int fontSize = 40;
	private String fontName = "SansSerif";
	private Color colorName = Color.DARKGOLDENROD;
	
	private Text text;

	
	public static void main(String[] args){
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage){
		primaryStage.setTitle("Lesson 17. Customizable GUI. Serialization");
		//The first node in the tree is called the root node, and it never has a parent. 
		Group rootNode = new Group();
		Scene scene = new Scene(rootNode, 400, 250, Color.WHITE);
		
		//deserialize preferences.ser and apply the properties saved there
		UserPreferences userPreferences = new UserPreferences();
		FileInputStream fIn = null;	
		ObjectInputStream oIn = null;
		try{
			fIn = new FileInputStream("preferences.ser");
			oIn = new ObjectInputStream(fIn);
		
			userPreferences = (UserPreferences)oIn.readObject();
		} 
		catch (ClassNotFoundException cnf){
			cnf.printStackTrace();
		} 
		catch (IOException e){e.printStackTrace();}
	
		text = new Text(textOriginX,textOriginY, "JavaFX is awesome!");
		/*
		text.setFont(Font.font(fontName,fontSize));
		text.setFill(colorName);
		*/
		
		text.setFont(Font.font(userPreferences.getFontName(),userPreferences.getFontSize()));
		try{
			text.setFill((Paint)(Class.forName("javafx.scene.paint.Color").getField(userPreferences.getColor())).get(null));
		}
		catch (Exception e){
			e.printStackTrace();
		}
		Button userPreferencesButton = new Button("User Preferences");
		userPreferencesButton.setLayoutX(150);
		userPreferencesButton.setLayoutY(150);
		
		//open a new window when the user presses the button
		final Stage secondStage = new Stage();
        secondStage.setX(900);
        secondStage.setY(100);
        secondStage.setTitle("Preferences");
    	Group secondRootNode = new Group();  
        PreferencesScene secondScene = new PreferencesScene(secondRootNode,280,170,this);
        secondStage.setScene(secondScene); 
		userPreferencesButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {             
                secondStage.show();
            }
		});
		
		rootNode.getChildren().add(text);
		rootNode.getChildren().add(userPreferencesButton);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

}
