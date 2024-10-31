import java.util.Set;
import java.util.TreeSet;

public class Game {

    private int quantityError = 0;
    private final Gallows gallows;
    private final Word word;
    private StatusGame status;

    private final Set<Character> charactersEntered = new TreeSet<>();

    public Game () {
        this.gallows = new Gallows();
        this.word = new Word();
        this.status = StatusGame.GAME_MENU;
    }

    public boolean checkingLetter (char ch) {

        char[] letters = word.getLetters();

        for (char letter: letters) {
            if (letter == ch) {
                word.openingLetters(ch);
                return true;
            }
        }

        increaseErrors();
        gallows.changeCondition();

        return false;
    }

    public StatusGame status() {
        return status;
    }

    public boolean checkWin() {
        return word.getQuantityLetters() == word.getQuantityOpenLetters();
    }

    public void setStatus(StatusGame status) {
        if (status == null) throw new NullPointerException("Статус игры не может быть отрицательным!");
        this.status = status;
    }

    public int getQuantityError() {
        return quantityError;
    }

    private void increaseErrors() {
        this.quantityError++;

        if (quantityError == 6) {
            word.setWordFinish();
        }
    }

    public String outputWord() {
        return word.stateWord();
    }

    public String outputGallows() {
        return gallows.conditionGallows();
    }

    public Set<Character> getCharactersEntered() {
        return charactersEntered;
    }

}
