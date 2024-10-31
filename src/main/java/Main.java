
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в игру виселица!");
        Game game = new Game();

        int enter = -1;
        while (enter != 2) {

            if (game.status() == StatusGame.GAME_MENU) {

                System.out.println("""
                        1. Начать новую игру
                        2. Выйти
                        """);

                System.out.print("Ввод: ");
                enter = Integer.parseInt(scanner.next());

                if (enter != 1 && enter != 2) {
                    System.out.println("Некорректный ввод! Повторите попытку!\n");
                    continue;
                }

                if (enter == 2) break;

                System.out.println();
            }

            if (enter == 1 && game.status() != StatusGame.GAMEPLAY) {

                System.out.println("НАЧНЕМ!\n");
                game.setStatus(StatusGame.GAMEPLAY);
            }

            System.out.println("Состояние виселицы: ");
            System.out.println(game.outputGallows());

            System.out.println("Загаданное слово: " + game.outputWord());
            System.out.println("Количество ошибок: " + game.getQuantityError() + "\n");

            System.out.print("Введите букву: ");
            char letter = scanner.next().charAt(0);

            if (!Character.UnicodeBlock.of(letter).equals(Character.UnicodeBlock.CYRILLIC)) {
                System.out.println("Только символы кириллицы!\n");
                continue;
            }

            if(!game.getCharactersEntered().add(letter)) {
                System.out.println("Этот символ уже был!");
                continue;
            }

            if (game.checkingLetter(letter)) {
                System.out.println("Есть такая буква!\n");

                if (game.checkWin()) {
                    System.out.println("Вы победили!\n");
                    System.out.println("Отгаданное слово: " + game.outputWord());
                    game = new Game();
                }

            } else {
                game.outputGallows();
                System.out.println("ТАКОЙ БУКВЫ НЕТ!\n");
            }

            if (game.getQuantityError() == 6) {
                System.out.println(game.outputGallows());
                System.out.println("ВЫ ПРОИГРАЛИ!\n");
                System.out.println("Это было слово: " + game.outputWord());
                game = new Game();
            }

        }
    }
}
