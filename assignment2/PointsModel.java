package ca.georgiancollege.comp1011.assignment2;
import java.util.HashMap;

public class PointsModel
{
    private String newWord;
    private HashMap<Character, Integer> reserveLetter = new HashMap<Character, Integer>();
    private String previousWords = "Previous Words: ";
    private int totalPoints;
    private String warning;


    public PointsModel() {

        reserveLetter.put('E', 12);
        reserveLetter.put('A', 9);
        reserveLetter.put('R', 6);
        reserveLetter.put('O', 8);
        reserveLetter.put('I', 8);
        reserveLetter.put('T', 6);
        reserveLetter.put('S', 4);
        reserveLetter.put('N', 6);
        reserveLetter.put('L', 4);
        reserveLetter.put('D', 4);
        reserveLetter.put('U', 4);
        reserveLetter.put('G', 3);
        reserveLetter.put('P', 2);
        reserveLetter.put('M', 2);
        reserveLetter.put('B', 2);
        reserveLetter.put('H', 2);
        reserveLetter.put('C', 2);
        reserveLetter.put('W', 2);
        reserveLetter.put('Y', 2);
        reserveLetter.put('F', 2);
        reserveLetter.put('V', 2);
        reserveLetter.put('K', 1);
        reserveLetter.put('X', 1);
        reserveLetter.put('Z', 1);
        reserveLetter.put('J', 1);
        reserveLetter.put('Q', 1);
    }

    public HashMap<Character, Integer> getReserveLetter() {
        return reserveLetter;
    }

    public boolean setNewWord(String newWord) {
        if(isValidWord(newWord)) {
            this.newWord = newWord;
            setPreviousWords();
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isValidWord(String newWord){

        boolean isValid = true;

        if (newWord.toCharArray().length>8 ||
                newWord.toCharArray().length <= 1 ||
                reserveEnough(newWord) == false ||
                isValidVowel(newWord) == false ||
                ifDuplicate(newWord) == false) {
            isValid = false;
        }

        if (newWord.toCharArray().length>8) {
            warning = "Word is too long";
        }else if (newWord.toCharArray().length == 1) {
            warning = "Word is too short";
        } else if (newWord.toCharArray().length <= 0) {
            warning = "Word is blank";
        } else if (reserveEnough(newWord) == false) {
            warning = "Word contains letter that is no longer available “in bag”";
        } else if (isValidVowel(newWord) == false) {
            warning = "Word does not have vowel";
        }else if (ifDuplicate(newWord) == false) {
            warning = "You already typed this word";
        }

        if(isValid == true){
            char arr[] = newWord.toCharArray();
            int num = 0;
            for (char letter: arr) {
                if (reserveLetter.containsKey(letter)) {
                    num = reserveLetter.get(letter);
                    reserveLetter.put(letter, num-1);
                    System.out.println("Character " + letter + " got " + (num - 1) + " number left.");
                }
            }
            return true;
        }
        else{
            return false;
        }

    }

    private boolean ifDuplicate(String newWord){

        boolean isValid = true;

        for (String pWord: previousWords.split("[:, ]")){
            if (newWord.equals(pWord)){
                isValid = false;
            }
        }

        return isValid;
    }

    private boolean isValidVowel(String newWord){

        boolean isValid = false;

        for(char letter: newWord.toCharArray()){
            if (letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U' || letter == 'Y'){
                isValid = true;
            }
        }

        return isValid;
    }

    private boolean reserveEnough(String newWord) {

        boolean isEnough = true;

        HashMap<Character, Integer> rLetter = new HashMap<Character, Integer>();
        rLetter.putAll(reserveLetter);

        char arr[] = newWord.toCharArray();
        int num = 0;

        for (char letter: arr) {
            if (rLetter.containsKey(letter)){
                num = rLetter.get(letter);

                if (num - 1 < 0) {
                    isEnough = false;
                }
                else {
                    rLetter.put(letter, num-1);
                }
            }
        }

        return isEnough;
    }

    public String getPreviousWords() {
        return previousWords;
    }

    public void setPreviousWords() {

        if (this.previousWords != "Previous Words: "){
            this.previousWords += ", ";
        }

        char arr[] = newWord.toCharArray();
        for (char letter: arr) {
            if (reserveLetter.containsKey(letter)){
                this.previousWords += letter;
            }
        }
    }

    public int setTotalPoints(String newWord) {

        HashMap<Character, Integer> pointOfEachLetter = new HashMap<Character, Integer>();
        pointOfEachLetter.put('A', 1);
        pointOfEachLetter.put('B', 3);
        pointOfEachLetter.put('C', 3);
        pointOfEachLetter.put('D', 2);
        pointOfEachLetter.put('E', 1);
        pointOfEachLetter.put('F', 4);
        pointOfEachLetter.put('G', 2);
        pointOfEachLetter.put('H', 4);
        pointOfEachLetter.put('I', 1);
        pointOfEachLetter.put('J', 8);
        pointOfEachLetter.put('K', 5);
        pointOfEachLetter.put('L', 1);
        pointOfEachLetter.put('M', 3);
        pointOfEachLetter.put('N', 1);
        pointOfEachLetter.put('O', 1);
        pointOfEachLetter.put('P', 3);
        pointOfEachLetter.put('Q', 10);
        pointOfEachLetter.put('R', 1);
        pointOfEachLetter.put('S', 1);
        pointOfEachLetter.put('T', 1);
        pointOfEachLetter.put('U', 1);
        pointOfEachLetter.put('V', 4);
        pointOfEachLetter.put('W', 4);
        pointOfEachLetter.put('X', 8);
        pointOfEachLetter.put('Y', 4);
        pointOfEachLetter.put('Z', 10);


        char arr[] = newWord.toCharArray();
        for (char letter: arr) {
            if (pointOfEachLetter.containsKey(letter)){
                totalPoints += pointOfEachLetter.get(letter);
            }
        }

        return totalPoints;
    }

    public String getMessage() {
        return warning;
    }

}

