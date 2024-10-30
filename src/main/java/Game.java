public class Game {

    private int quantityError = 0;
    private final Gallows gallows;
    private final Word word;
    private StatusGame status;

    public Game () {
        this.gallows = new Gallows();
        this.word = new Word();
        this.status = StatusGame.GAME_MENU;
    }

    public StatusGame status() {
        return status;
    }

    public boolean checkWin() {
        return word.checkOpeningLetters();
    }

    public void setStatus(StatusGame status) {
        this.status = status;
    }

    public Gallows getGallows() {
        return gallows;
    }

    public Word getWord() {
        return word;
    }

    public int getQuantityError() {
        return quantityError;
    }

    public void increaseErrors() {
        this.quantityError++;
    }
}
