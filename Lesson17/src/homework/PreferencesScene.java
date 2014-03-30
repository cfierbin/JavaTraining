//combobox examples at http://docs.oracle.com/javafx/2/ui_controls/combo-box.htm
package homework;

import java.awt.event.ActionEvent;

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
	
	private UserPreferences userPreferences;
	
	private ObservableList<String> colorOptions = 
		    FXCollections.observableArrayList(
		        "RED",
		        "BLUE",
		        "MAGENTA",
		        "DARKGOLDENROD"
		    );
	private ObservableList<String> fontOptions = 
		    FXCollections.observableArrayList(
		            "SansSerif",
		            "Dialog",
		            "Monospaced",
		            "Bold",
		            "Italic"  
		    );
	private ObservableList<String> fontSizeOptions = 
		    FXCollections.observableArrayList(
		            "12",
		            "14",
		            "16",
		            "30",
		            "40"  
		    );
	
	private final ComboBox colorComboBox = new ComboBox(colorOptions);
	private final ComboBox fontComboBox = new ComboBox(fontOptions);
	private final ComboBox fontSizeComboBox = new ComboBox(fontSizeOptions);
    private final Button saveButton = new Button ("Save");
    private final Button cancelButton = new Button ("Cancel");
    
    //layout manager
    private GridPane grid = new GridPane();

	//constructor
    public PreferencesScene(Group root, int x, int y) {
		//call scene constructor to define root node
    	super(root, x, y);
		
		grid.setVgap(10);
        grid.setHgap(25);
        grid.setPadding(new Insets(5, 5, 5, 5));
        colorComboBox.setPrefWidth(150);
        fontComboBox.setPrefWidth(150);
        fontSizeComboBox.setPrefWidth(150);
        grid.add(new Label("Select color: "), 0, 0);
        grid.add(colorComboBox, 1, 0);
        grid.add(new Label("Select font: "), 0, 1);
        grid.add(fontComboBox, 1, 1);
        grid.add(new Label("Select font size: "), 0, 2);
        grid.add(fontSizeComboBox, 1, 2);
        grid.add(cancelButton, 0, 5);
        saveButton.setOnAction(new PreferencesSceneEventHandler(this));
        grid.add(saveButton, 1, 5);        
        root.getChildren().add(grid);
	}

	public UserPreferences getUserPreferences() {
		return userPreferences;
	}

	public void setUserPreferences(UserPreferences userPreferences) {
		this.userPreferences = userPreferences;
	}

	public ComboBox getColorComboBox() {
		return colorComboBox;
	}

	public ComboBox getFontComboBox() {
		return fontComboBox;
	}

	public ComboBox getFontSizeComboBox() {
		return fontSizeComboBox;
	}
	

}

