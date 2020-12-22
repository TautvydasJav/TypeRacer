package FxControllers;

public class ProgressBarController {

    private double progressBarState = 0;

    public boolean isProgressBarFull(){
        if(progressBarState >= 1.0)
            return true;
        else
            return false;
    }

    public void resetProgressBar(){
            progressBarState = 0.0;
    }

    public void setProgressBarFull(){
        progressBarState = 1.0;
    }

    public double getProgressBarState() {
        return progressBarState;
    }

    public void setProgressBarState(double points, int length) {
        this.progressBarState = points/length;
    }
}
