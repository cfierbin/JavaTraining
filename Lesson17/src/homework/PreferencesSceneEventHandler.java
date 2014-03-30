package homework;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PreferencesSceneEventHandler implements EventHandler<ActionEvent>{
	
	private PreferencesScene parent;
	
	private FileOutputStream fOut = null;
	private ObjectOutputStream oOut = null;
	
	private static final String preferencesFileName = "preferences.ser";

	//constructor saves reference to parent scene
	public PreferencesSceneEventHandler(PreferencesScene parent){
		this.parent = parent;
	}

	@Override
	public void handle(ActionEvent event) {
		//Serialize the instance of user preferences into preferences.ser
		
		//print selected preferences, just for checking
		System.out.println(parent.getColorComboBox().getValue());
		System.out.println(parent.getFontComboBox().getValue());
		System.out.println(parent.getFontSizeComboBox().getValue());
		
		 try{		 
			 fOut = new FileOutputStream(preferencesFileName);
			 oOut = new ObjectOutputStream(fOut);
			 oOut.writeObject(parent.getUserPreferences()); // serialization
			 } 
		 
		 catch (IOException exception){
			 System.out.println(exception.getMessage());
		 }
			 
		
	}

}
