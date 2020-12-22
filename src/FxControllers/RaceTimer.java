package FxControllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RaceTimer {

    int timeCount;
    int raceTime;
    int countDownTime;

    public RaceTimer(int countTime, int countDownTime) {
        this.timeCount = countTime;
        this.raceTime = countTime;
        this.countDownTime = countDownTime;
    }

    public void runRaceTimer(Label timeLabel, Button startBtn) {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            timeLabel.setText("Race will end in: "
                    + timeCount);
            if (timeCount == 0) {
                System.out.println("veikia");
                displayEndGamePopup();
            }
            timeCount--;
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(raceTime + 1);
        clock.play();
    }

    public void displayEndGamePopup() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("End of Race");
        window.setMinWidth(250);
        String message = "The end";
        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Okay");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

}
