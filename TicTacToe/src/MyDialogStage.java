import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MyDialogStage extends Stage {
	
	public MyDialogStage (String title, String labelText){
		super();
		setTitle(title);
		
			// dialog window prevents all other windows from receiving events
		initModality(Modality.APPLICATION_MODAL);
		
			// dialog window has only close icon
		initStyle(StageStyle.UTILITY);	
		
		Label congrats = new Label(labelText);
		// congrats.setTextFill(Color.RED);
		congrats.setStyle("	-fx-text-fill: red; -fx-font-size: 20px;");
		
		Scene scene = new Scene(new StackPane(congrats), 350, 100);
		setScene(scene);
			// show and stop execution until the user closes the dialog window
		showAndWait();
	}
	
}
