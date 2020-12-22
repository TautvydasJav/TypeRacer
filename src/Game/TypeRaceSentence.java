package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TypeRaceSentence extends Sentence {

    private String sentence = new String();
    private List<String> listOfWordsInSentence = new ArrayList<>();
    private String finishedWords;
    private String notFinishedWords;
    private int finishedWordsPosition = 0;

    public void setNewSentence(){
        sentence = getSentence();
        putSentenceToList();
    }
    public void putSentenceToList(){
               String[] wordsSeparated = sentence.split("\\s+");
        for(int i = 0; i < wordsSeparated.length; i++){
            listOfWordsInSentence.add(wordsSeparated[i]);
        }
    }

    public void resetSentence(){
        finishedWords = "";
        notFinishedWords = sentence;
    }

    public void updateSentenceProgress(){
        String newWord;
        finishedWordsPosition = notFinishedWords.indexOf(" ");

        newWord = notFinishedWords.substring(0,finishedWordsPosition+1);
        finishedWords += newWord;

        int length = notFinishedWords.length();
        notFinishedWords = notFinishedWords.substring(finishedWordsPosition+1, length);
    }

    public boolean checkIfWordsMatch(String wordToCheck){
        return wordToCheck.equals(listOfWordsInSentence.get(0));
    }

    public void deleteFirstWordFromSentence(){
        listOfWordsInSentence.remove(0);
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public List<String> getSentenceWords() {
        return listOfWordsInSentence;
    }

    public void setSentenceWords(List<String> sentenceWords) {
        this.listOfWordsInSentence = sentenceWords;
    }

    public String getFinishedWords() {
        return finishedWords;
    }

    public void setFinishedWords(String finishedWords) {
        this.finishedWords = finishedWords;
    }

    public String getNotFinishedWords() {
        return notFinishedWords;
    }

    public void setNotFinishedWords(String notFinishedWords) {
        this.notFinishedWords = notFinishedWords;
    }
}
