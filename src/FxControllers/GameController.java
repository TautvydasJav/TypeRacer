package FxControllers;

import Game.TypeRaceSentence;
import Game.TypeRacer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ResourceBundle;


public class GameController implements Initializable {
    @FXML
    public TextField typingField;
    @FXML
    public Button startBtn;
    @FXML
    public Button exitBtn;
    @FXML
    public Label timeLabel;
    @FXML
    public Label pointsLabel;
    @FXML
    public ProgressBar progressBar;
    @FXML
    public TextFlow sentenceText;

    Text redText = new Text();
    Text greenText = new Text();

    TypeRacer typeRacer = new TypeRacer();
    TypeRaceSentence sentence = new TypeRaceSentence();
    RaceTimer raceTimer = new RaceTimer(typeRacer.getGameTime(), typeRacer.getCountDownTime());

    ProgressBarController progressBarController = new ProgressBarController();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createLabelBorders();
        setTextStyle();
    }

    public void initKeyListener() {
        typingField.setOnKeyPressed(ke -> {
            if(typeRacer.isGameRunning() && ke.getText().equals(" "))
                matchWords();
        });
    }

    public void matchWords(){
        if(sentence.checkIfWordsMatch(typingField.getText().trim())){
            updateRace();
            if(progressBarController.isProgressBarFull()){
                resetRace();
            }
        }
    }

    public void updateRace(){
        sentence.deleteFirstWordFromSentence();
        typeRacer.incrementAllPoints();
        typeRacer.incrementCurrentSentencePoints();
        typingField.setText("");
        sentence.updateSentenceProgress();
        updateScreen();
    }

    public void resetRace(){
        progressBarController.resetProgressBar();
        progressBar.progressProperty().setValue(0.0);
        typeRacer.resetSentencePoints();
        sentence.setNewSentence();
        sentence.resetSentence();
        updateScreen();
    }

    public void startRace(){
        typeRacer = new TypeRacer();
        typeRacer.resetSentencePoints();
        sentence.setNewSentence();
        sentence.resetSentence();
        raceTimer.runRaceTimer(timeLabel, startBtn);

        initKeyListener();
        updateScreen();
    }

    public void updateScreen() {
        progressBarController.setProgressBarState(typeRacer.getCurrentSentencePoints(), sentence.getSentenceLength());
        progressBar.progressProperty().setValue(progressBarController.getProgressBarState());
        pointsLabel.setText("Points: " + typeRacer.getAllPoints());

        greenText.setText(sentence.getFinishedWords());
        redText.setText(sentence.getNotFinishedWords());
        sentenceText.getChildren().clear();
        sentenceText.getChildren().addAll(greenText, redText);
    }

    public void createLabelBorders() {
        sentenceText.setStyle("-fx-border-color: white;");
        timeLabel.setStyle("-fx-border-color: white;");
        pointsLabel.setStyle("-fx-border-color: white;");
    }

    private void setTextStyle() {
        redText.setFill(javafx.scene.paint.Color.RED);
        redText.setStyle("-fx-font: 20 arial;");
        greenText.setFill(javafx.scene.paint.Color.GREEN);
        greenText.setStyle("-fx-font: 20 arial;");
    }

    public void exitGame() {
        System.exit(0);
    }
}

