
package application;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class GridPaneSample extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		final int TWO_COLUMN_SPAN = 2; 
		
		Label userIdLbl = new Label("User ID:");
		TextField userIdTxt = new TextField();
		Label userPwdLbl = new Label("Password:");
		PasswordField userPwdTxt = new PasswordField();

		GridPane gridPane = new GridPane();
		gridPane.setVgap(20);
		gridPane.setPadding(new Insets(10));
		gridPane.setAlignment(Pos.CENTER);
		
		ColumnConstraints column1 = new ColumnConstraints(100,100,Double.MAX_VALUE);
	    column1.setHgrow(Priority.ALWAYS);
	    ColumnConstraints column2 = new ColumnConstraints(100);    
	    gridPane.getColumnConstraints().addAll(column1, column2); // first column gets any extra width
	    
	    // Using static methods for setting node constraints 
		GridPane.setConstraints(userIdLbl, 0, 0);
		GridPane.setConstraints(userIdTxt, 1, 0);
		GridPane.setConstraints(userPwdLbl, 0, 1);
		GridPane.setConstraints(userPwdTxt, 1, 1);

		gridPane.getChildren().addAll(userIdLbl, userIdTxt, userPwdLbl, userPwdTxt);
		
	    
		Button signIn = new Button ("Sign In");

		//GridPane.setHalignment(signIn, HPos.CENTER);
		//GridPane.setHalignment(signIn, HPos.RIGHT);
		
		//GridPane.setColumnSpan(signIn, 2);
		//GridPane.setConstraints(signIn,0,2);
	
		/*signIn.setPrefWidth(1000); // Allow the button to be wide */
        // using instance method for directly adding the node
		gridPane.add(signIn,0,2,TWO_COLUMN_SPAN,1); 
		signIn.setPrefWidth(Double.MAX_VALUE);
	
		Scene scene = new Scene(gridPane,250,150);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
