package reusablecalculatorcomponents;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TestReusableCalculatorComponent extends Application {
	
	private SimpleCalculatorPane simpleCalculatorPane = new SimpleCalculatorPane();
	private StandardCalculatorPane standardCalculatorPane = new StandardCalculatorPane();
	private FancyCalculatorPane fancyCalculatorPane = new FancyCalculatorPane();

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Calculator");
		// Window is not maximizable
		//primaryStage.setResizable(false);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		//primaryStage.initModality(Modality.NONE);
		// Set the application icon
	    primaryStage.getIcons().add(new Image("file:resources/images/calculatoryellow.png"));
		
		// Create the menu bar
		MenuBar menuBar = new MenuBar();
		Menu viewMenu = new Menu("View");
		RadioMenuItem simpleCalculatorMenuItem = new RadioMenuItem("Simple");
		RadioMenuItem standardCalculatorMenuItem = new RadioMenuItem("Standard");
		RadioMenuItem fancyCalculatorMenuItem = new RadioMenuItem("Fancy");
			// Set fancy calculator as default view
		fancyCalculatorMenuItem.setSelected(true);
		viewMenu.getItems().addAll(simpleCalculatorMenuItem, 
				standardCalculatorMenuItem,
				fancyCalculatorMenuItem);

		menuBar.getMenus().add(viewMenu);
		
		// Create a GridPane as the root layout node
		GridPane window = new GridPane();
		Scene scene = new Scene(window, 500, 350, Color.GREY);
		scene.getStylesheets()
		.add(getClass().getResource("calculator.css")
		.toExternalForm());
		
		// Set style for menu
		/*
		menuBar.setStyle("-fx-font-family: \"Helvetica\";"
				+ "-fx-font-size: 18px; -fx-background-color: grey; -fx-text-fill: white;");
		viewMenu.setStyle("-fx-font-family: \"Helvetica\";"
				+ "-fx-font-size: 18px; "
				+ "-fx-background-color: grey;");
		*/
				
		
		// Add the menu bar to the window
		window.add(menuBar, 0, 0);
		
		// At the beginning add to the window a fancy calculator pane

		window.add(fancyCalculatorPane, 0, 1);
		
		// Set the scene and display the window
		primaryStage.setScene(scene);
		primaryStage.show();

		// Handler code for menu items
		standardCalculatorMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				// if selected, add
				if (standardCalculatorMenuItem.isSelected() && 
					(window.getChildren().contains(simpleCalculatorPane))){
					simpleCalculatorMenuItem.setSelected(false);
					window.getChildren().remove(simpleCalculatorPane);
					window.add(standardCalculatorPane, 0, 1);
				}
				if (standardCalculatorMenuItem.isSelected() && 
						(window.getChildren().contains(fancyCalculatorPane))){
						fancyCalculatorMenuItem.setSelected(false);
						window.getChildren().remove(fancyCalculatorPane);
						window.add(standardCalculatorPane, 0, 1);
					}
				// if unselected, remove
				if (!standardCalculatorMenuItem.isSelected()){
					if (window.getChildren().contains(standardCalculatorPane)){
						window.getChildren().remove(standardCalculatorPane);
					}
					window.add(simpleCalculatorPane, 0, 1);
					simpleCalculatorMenuItem.setSelected(true);
				}
			}
		});
		
		simpleCalculatorMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				// if selected, add
				if (simpleCalculatorMenuItem.isSelected() && 
					(window.getChildren().contains(standardCalculatorPane))){
					standardCalculatorMenuItem.setSelected(false);
					window.getChildren().remove(standardCalculatorPane);
					window.add(simpleCalculatorPane, 0, 1);
				}
				if (simpleCalculatorMenuItem.isSelected() && 
						(window.getChildren().contains(fancyCalculatorPane))){
						fancyCalculatorMenuItem.setSelected(false);
						window.getChildren().remove(fancyCalculatorPane);
						window.add(simpleCalculatorPane, 0, 1);
					}
				// if unselected, remove
				if (!simpleCalculatorMenuItem.isSelected()){
					if (window.getChildren().contains(simpleCalculatorPane)){
						window.getChildren().remove(simpleCalculatorPane);
					}
					window.add(standardCalculatorPane, 0, 1);
					standardCalculatorMenuItem.setSelected(true);
				}
			}
		});
		
		//Handler code for fancyCalculatorMenuItem, using lambda expression
		
		fancyCalculatorMenuItem.setOnAction(t -> {
			// if selected, add
			if (fancyCalculatorMenuItem.isSelected() && 
				(window.getChildren().contains(standardCalculatorPane))){
				standardCalculatorMenuItem.setSelected(false);
				window.getChildren().remove(standardCalculatorPane);
				window.add(fancyCalculatorPane, 0, 1);
			}
			if (fancyCalculatorMenuItem.isSelected() && 
					(window.getChildren().contains(simpleCalculatorPane))){
					simpleCalculatorMenuItem.setSelected(false);
					window.getChildren().remove(simpleCalculatorPane);
					window.add(fancyCalculatorPane, 0, 1);
				}
			// if unselected, remove
			if (!fancyCalculatorMenuItem.isSelected()){
				if (window.getChildren().contains(fancyCalculatorPane)){
					window.getChildren().remove(fancyCalculatorPane);
				}
				window.add(standardCalculatorPane, 0, 1);
				standardCalculatorMenuItem.setSelected(true);
			}	
		});	

	}

	public static void main(String[] args) {
        launch(args);
	}

}
