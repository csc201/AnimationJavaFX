import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by tkanchanawanchai6403 on 8/2/2016.
 */
public class BounceBallSlider extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        double speed=0;
        BallPane ballPane = new BallPane();
        Slider slSpeed = new Slider(-10,10,speed);
        slSpeed.setShowTickMarks(true);
        slSpeed.setShowTickLabels(true);
        slSpeed.valueProperty().addListener(ov->{
            ballPane.adjustSpeed(slSpeed.getValue());
        });
       // ballPane.rateProperty().bind(slSpeed.valueProperty());
        // Increase and decrease animation
        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setBottom(slSpeed);

        Scene scene = new Scene(pane,500,500);
        scene.setOnKeyPressed(e -> {
            System.out.println(e.getCode());
            if (e.getCode() == KeyCode.UP) {
                ballPane.increaseSpeed();
            }
            else if (e.getCode() == KeyCode.DOWN) {
                ballPane.decreaseSpeed();
            }
        });
        primaryStage.setTitle("Bouce Ball!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
