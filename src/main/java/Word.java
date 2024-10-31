
import java.util.Random;

public class Word {

    private final String value;
    private final int quantityLetters;
    private char[] openLetters;
    private final char[] letters;
    private int quantityOpenLetters;

    public Word() {
        this.value = initializingWord();
        this.quantityLetters = value.length();
        this.openLetters = new char[quantityLetters];
        this.letters = value.toCharArray();
    }

    private String initializingWord() {
        Random ran = new Random();
        int number = ran.nextInt(Dictionary.getQuantityWords());

        return Dictionary.getWord(number);
    }

    public void openingLetters(char ch) {

        for (int i = 0; i < quantityLetters; i++) {
            if (ch == letters[i]) {
                quantityOpenLetters++;
                openLetters[i] = ch;
            }
        }
    }

    public int getQuantityLetters() {
        return quantityLetters;
    }

    public int getQuantityOpenLetters() {
        return quantityOpenLetters;
    }

    public char[] getLetters() {
        return letters;
    }

    public void setWordFinish() {
        openLetters = letters;
    }

    public String stateWord() {
        StringBuilder str = new StringBuilder("|");

        for (char letter: openLetters) {
            if (letter == 0) letter = '*';
            str.append(letter).append("|");
        }

        return str.toString();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("|");

        for (char letter: letters) {
            if (letter == 0) letter = '*';
            str.append(letter).append("|");
        }

        return str.toString();
    }
}
