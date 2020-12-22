package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class Sentence{

    private final String[] allWords = new String[]{"word", "car", "boy", "gorilla", "in", "developed", "ran",
            "but", "played", "saw", "then", "did", "and", "officer"};
    private String sentence;
    private final int sentenceLength = 10;

    public String getSentence(){
        Random rand = new Random();
        sentence = new String();
        int wordsCount = allWords.length;
        for(int i = 0; i < sentenceLength; i++){
            sentence += allWords[rand.nextInt(wordsCount)] + " ";
        }
        return sentence;
    };

    public int getSentenceLength(){
        return sentenceLength;
    };

    public abstract void resetSentence();

    public abstract void updateSentenceProgress();

    public abstract boolean checkIfWordsMatch(String wordToCheck);

    public abstract void deleteFirstWordFromSentence();

}
