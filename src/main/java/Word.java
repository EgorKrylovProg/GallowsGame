
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

    public int getQuantityLetters() {
        return this.quantityLetters;
    }

    public boolean openingLetters(char letter) {
        boolean flag = false;

        for (int i = 0; i < value.length(); i++) {
            if (letters[i] == letter) {
                flag = true;
                quantityOpenLetters++;

                openLetters[i] = letter;
            }
        }
        return flag;
    }

    public String getStateWord() {
        StringBuilder str = new StringBuilder("|");

        for (char letter: openLetters) {
            if (letter == 0) letter = '*';
            str.append(letter).append("|");
        }

        return str.toString();
    }

    public boolean checkOpeningLetters() {
        return quantityLetters  == quantityOpenLetters;
    }

    public String getValue() {
        return value;
    }
}
