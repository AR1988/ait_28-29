package org.example;

import java.util.Scanner;

public class MemoGame {

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        Game game = new Game();

        System.out.println("Введите размер поля:");
        System.out.println("Высота");
        int boardHigh = scanner.nextInt();
        System.out.println("Ширина");
        int boardWeight = scanner.nextInt();

        game.startGame(boardHigh, boardWeight);

        int cardCount = 0;
        while (true) {
            final SelectedCard selectedCard = consoleInput(boardHigh, boardWeight);
            game.openCard(cardCount, selectedCard);
            cardCount++;
            System.out.println("открыта карточка " + cardCount + " " + selectedCard);

            if (cardCount == 2) {
                String s = "";

                while (!s.equals("y")) {
                    System.out.println("(y) -> введите y для продолжения");
                    System.out.println("(n) -> введите n для завершения игры");
                    System.out.println("(m) -> введите m что бы открыть карту");
                    s = scanner.nextLine();

                    switch (s) {
                        case "n" -> {
                            System.out.println("game over");
                            return;
                        }
                        case "m" -> game.printBoard();
                        case "y" -> System.out.println("Ок, давайте продолжим!");
                        default -> {
                            System.out.println("Разве есть такой вариант?");
                            System.out.println("Попробуй еще раз!");
                        }
                    }
                }

                cardCount = 0;
                System.out.println("_".repeat(25));
                game.clearBoard();
            }
        }
    }

    private static SelectedCard consoleInput(int maxRow, int maxColumn) {
        int rowIndex, columnIndex;
        while (true) {
            System.out.println("Введите номер строки от 1 до " + maxRow);
            String row = scanner.nextLine();
            try {
                rowIndex = Integer.parseInt(row);
                if (rowIndex > maxRow) {
                    System.out.println("введите число от 1 до" + maxRow);
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите число");
                continue;
            }

            System.out.println("Введите номер колонки от 1 до " + maxColumn);
            String column = scanner.nextLine();
            try {
                columnIndex = Integer.parseInt(column);
                if (columnIndex > maxColumn) {
                    System.out.println("введите число от 1 до" + maxColumn);
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите число");
                continue;
            }
            break;
        }

        return new SelectedCard(--rowIndex, --columnIndex);
    }


}
