package homework;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PreferencesSceneEventHandler implements EventHandler<ActionEvent>{
	
	private PreferencesScene parent;
	
	//constructor
	public PreferencesSceneEventHandler(PreferencesScene parent){
		this.parent = parent;
	}

	@Override
	public void handle(ActionEvent e) {
		//Serialize the instance of user preferences into preferences.ser
		System.out.println(parent.getColorComboBox().getValue());
		System.out.println(parent.getFontComboBox().getValue());
		System.out.println(parent.getFontSizeComboBox().getValue());
	}

}
