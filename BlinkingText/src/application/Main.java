package application;
	
import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("Blinking");
        label.setStyle("-fx-text-fill: red; -fx-padding: 10px;");

        Timeline blinker = createBlinker(label);
        blinker.setOnFinished(event -> label.setText("Fading"));
        FadeTransition fader = createFader(label);

        SequentialTransition blinkThenFade = new SequentialTransition(
                label,
                blinker,
                fader
        );

        stage.setScene(new Scene(new StackPane(label), 100, 50));
        stage.show();

        blinkThenFade.play();
    }

    private Timeline createBlinker(Node node) {
        Timeline blink = new Timeline(
                new KeyFrame(
                        Duration.seconds(0),
                        new KeyValue(
                                node.opacityProperty(), 
                                1, 
                                Interpolator.DISCRETE
                        )
                ),
                new KeyFrame(
                        Duration.seconds(0.5),
                        new KeyValue(
                                node.opacityProperty(), 
                                0, 
                                Interpolator.DISCRETE
                        )
                ),
                new KeyFrame(
                        Duration.seconds(1),
                        new KeyValue(
                                node.opacityProperty(), 
                                1, 
                                Interpolator.DISCRETE
                        )
                )
        );
        blink.setCycleCount(3);

        return blink;
    }

    private FadeTransition createFader(Node node) {
        FadeTransition fade = new FadeTransition(Duration.seconds(2), node);
        fade.setFromValue(1);
        fade.setToValue(0);

        return fade;
    }

    public static void main(String[] args) {
        launch(args);
    }
}  
