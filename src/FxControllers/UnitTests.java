package FxControllers;

import Game.TypeRaceSentence;

import static org.junit.jupiter.api.Assertions.*;

class UnitTests {

    @org.junit.jupiter.api.Test
    void resetBarTest() {
        ProgressBarController testBar = new ProgressBarController();

        testBar.setProgressBarFull();

        testBar.resetProgressBar();

        assertEquals(false, testBar.isProgressBarFull());
    }

    @org.junit.jupiter.api.Test
    void isProgressBarFullTest() {
        ProgressBarController testBar = new ProgressBarController();

        testBar.setProgressBarFull();

        assertEquals(true, testBar.isProgressBarFull());
    }

    @org.junit.jupiter.api.Test
    void getSentenceTest() {
        TypeRaceSentence testSentence = new TypeRaceSentence();

        assertNotNull(testSentence.getSentence());
    }
}