import java.util.ArrayList;
import java.util.Scanner;

final public class UI {
    private static Scanner console = new Scanner(System.in);

    public static void welcomeMessage() {
        System.out.println("Доброго времени суток и добро пожаловать в Реверси!");
    }

    public static int gameModeChoice() {
        System.out.print("Выберите режим игры:\n" +
                "0 — игра с лёгким ботом\n" +
                "1 — игра против реального игрока\n" +
                "2 — покинуть игру");
        String input = console.nextLine();
        if (input.equals("0") || input.equals("1") || input.equals("2")) {
            return Integer.parseInt(input);
        }
        else {
            return gameModeChoice();
        }
    }

    public static int[] inputCoordinates() {
        System.out.println("Введите координаты хода в формате xy");
        try {
            String input = console.nextLine();
            if (input.length() != 2) {
                throw new Exception();
            }
            int coordinates = Integer.parseInt(input);
            int yCoordinate = coordinates % 10;
            int xCoordinate = coordinates / 10 % 10;
            if (yCoordinate > 8 || yCoordinate < 1 || xCoordinate > 8 || xCoordinate < 1) {
                throw new Exception();
            }
            return new int[]{xCoordinate, yCoordinate};
        } catch (Exception exception) {
            System.out.println("Координаты введены неправильно :(");
        }
        return inputCoordinates();
    }

    public static void showDesk(char[][] desk) {
        System.out.print("  ");
        for (int i = 1; i < 9; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(desk[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void moveMessage(char tipType) {
        System.out.println("Ходит игрок c фишками типа \"" + tipType + "\"");
    }

    public static void gameFinishMessage(int[] gameScore) {
        System.out.println("Ходы закончились! Игра окончена!\n" +
                "Финальный счёт: \"X\": " + gameScore[0] + ", \"O\": " + gameScore[1] + "\n" +
                "Победил \"" + (gameScore[0] > gameScore[1] ? "X" : "O") + "\" !");
    }

    public static void moveChangeMessage(char tipType) {
        System.out.println("Игрок не может сделать ход.\n" +
                "Ход переходит к сопернику c фишками типа \"" + tipType + "\".");
    }
    public static void botMoveAlert() {
        System.out.println("Бот делает шаг!");
    }

    public static void bestResultMessage(int result) {
        System.out.println("Лучший результат — " + result + " !" );
    }
}
