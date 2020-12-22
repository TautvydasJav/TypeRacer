package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TypeRacer {

    int allPoints = 0;
    double currentSentencePoints = 0;
    int gameTime = 60;
    int countDownTime = 3;
    boolean isGameRunning = true;

    public int getAllPoints() {
        return allPoints;
    }
    public double getCurrentSentencePoints() {
        return currentSentencePoints;
    }
    public int getGameTime() {
        return gameTime;
    }
    public int getCountDownTime() {
        return countDownTime;
    }
    public int getWpm() {
        return (int) (allPoints / (gameTime/60.0));
    }
    public boolean isGameRunning() {
        return isGameRunning;
    }
    public void incrementAllPoints() {
        allPoints++;
    }
    public void incrementCurrentSentencePoints() {
        currentSentencePoints++;
    }
    public void setCurrentSentencePoints(double length) {
        this.currentSentencePoints = length;
    }
    public void setGameRunning(boolean gameRunning) {
        isGameRunning = gameRunning;
    }
    public void resetSentencePoints() {
        setCurrentSentencePoints(0.0);
    }
}
