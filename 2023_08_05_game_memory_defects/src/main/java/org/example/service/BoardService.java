package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Card;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.example.Constants.*;

/**
 * @author Andrej Reutow
 * created on 04.08.2023
 */
public class BoardService {
    private static final Logger log = LogManager.getLogger(BoardService.class);

    public static Card[][] fillFieldWithCards(int boardHigh, int boardLength) {
        int maxPossibleCards = Card.icons.length;

        Card[][] cards = new Card[boardHigh][boardLength];
        int maxCard = (cards[0].length * cards.length) / 2;

        if (maxCard > maxPossibleCards) {
            log.error("Упс, у нас нет столько карточек для заполнения поля. Максимальное количество карточек {}", maxPossibleCards);
        }

        final Set<Card> cardList = new HashSet<>(maxCard);
        while (cardList.size() != maxCard) {
            cardList.add(new Card());
        }

        for (Card card : cardList) {
            placeSymbol(cards, card);
            placeSymbol(cards, card);
        }

        return cards;
    }

    public static Card[][] fillEmptyField(int boardHigh, int boardLength) {
        final Card[][] emptyField = new Card[boardHigh][boardLength];
        for (int i = 0; i < emptyField.length; i++) {
            for (int j = 0; j < emptyField[i].length; j++) {
                emptyField[i][j] = new Card(EMPTY_FIELD_SYMBOL);
            }
        }

        return emptyField;
    }

    public static Card[][] openField(Card[][] emptyField, Card[][] cards, int row, int column) {
        final Card[][] arrayCopy = Arrays.copyOf(emptyField, emptyField.length);
        arrayCopy[row][column] = cards[row][column];
        return arrayCopy;
    }

    public static void printBoard(Card[][] cardBoard) {
        String boardToString = boardToString(cardBoard);
        System.out.println(boardToString);
    }

    private static void placeSymbol(Card[][] cards, Card card) {
        final Random random = new Random();
        while (true) {
            int row = random.nextInt(cards.length);
            int column = random.nextInt(cards[0].length);

            final Card cartAtPostion = cards[row][column];
            if (cartAtPostion == null) {
                cards[row][column] = card;
                return;
            }
        }
    }

    public static String boardToString(final Card[][] cardBoard) {

        final StringBuilder buffer = new StringBuilder();

        buffer.append(MEMORY_GAME_HEADER)
                .append(System.lineSeparator());

        int row = cardBoard.length;
        int column = cardBoard[0].length;

        for (int i = 1; i <= column; i++) {
            buffer.append(String.format("%" + CELL_WIDTH + "s|", i));
        }

        buffer.append(System.lineSeparator());

        for (int i = 0; i < row; i++) {
            buffer.append(String.format("%" + CELL_WIDTH + "d|", i + 1));
            for (int j = 0; j < column; j++) {
                buffer.append(String.format("%" + CELL_WIDTH + "s|", cardBoard[i][j]));
            }
            buffer.append(System.lineSeparator());
        }
        buffer.append(MEMORY_GAME_FOOTER);

        return buffer.toString();
    }
}
