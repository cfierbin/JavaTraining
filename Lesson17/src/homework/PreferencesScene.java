package homework;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PreferencesScene extends Scene {
	
	ObservableList<String> options = 
		    FXCollections.observableArrayList(
		        "Option 1",
		        "Option 2",
		        "Option 3"
		    );
	
	final ComboBox colorComboBox = new ComboBox(options);
	final ComboBox fontComboBox = new ComboBox();
	final ComboBox fontSizeComboBox = new ComboBox();
    final Button saveButton = new Button ("Save");
    final Button cancelButton = new Button ("Cancel");
    
    GridPane grid = new GridPane();

	//constructor
    public PreferencesScene(Group root, int x, int y) {
		
    	super(root, x, y);
		
		fontComboBox.getItems().addAll(
	            "SansSerif",
	            "Dialog",
	            "Monospaced",
	            "Bold",
	            "Italic"  
	        );
		
		grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("Select color: "), 0, 0);
        grid.add(colorComboBox, 1, 0);
        grid.add(new Label("Select font: "), 0, 1);
        grid.add(fontComboBox, 1, 1);
        grid.add(new Label("Select font size: "), 0, 2);
        grid.add(fontSizeComboBox, 1, 2);
        grid.add(saveButton, 0, 5);
        grid.add(cancelButton, 1, 5);        
        root.getChildren().add(grid);
	}
	

}

