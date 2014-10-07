package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
	        Parent root = FXMLLoader.load(getClass().getResource("auction_monitor.fxml"));
	        primaryStage.setTitle("Auction Monitor");
	        primaryStage.setScene(new Scene(root, 550, 475));
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
