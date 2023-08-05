package org.example;

import org.example.service.BoardService;

import static org.example.Constants.EMPTY_FIELD_SYMBOL;
import static org.example.service.BoardService.*;
import static org.example.service.FileService.printBoardToFile;

public class Game {

    private SelectedCard selectedCardFirst;
    private SelectedCard selectedCardSecond;
    private Card[][] emptyField;
    private Card[][] fieldWithCards;
    private Card[][] boardToShow;

    public void startGame(int boardHigh, int boardLength) {
        this.boardToShow = fillFieldWithCards(boardHigh, boardLength);
        this.fieldWithCards = boardToShow;
        printBoardToFile(this.boardToShow);

        this.boardToShow = fillEmptyField(boardHigh, boardLength);
        this.emptyField = boardToShow;

        printBoard();
    }

    public void openCard(final int cardCount, final SelectedCard selectedCard) {
        this.boardToShow = openField(emptyField,
                fieldWithCards,
                selectedCard.rowIndex(),
                selectedCard.columnIndex());

        final Card card = this.boardToShow[selectedCard.rowIndex()][selectedCard.columnIndex()];
        if (cardCount == 0) {
            this.selectedCardFirst = selectedCard;
            this.selectedCardFirst.setCard(card);
        } else {
            this.selectedCardSecond = selectedCard;
            this.selectedCardSecond.setCard(card);
        }

        printBoard();
    }

    public void printBoard() {
        BoardService.printBoard(this.boardToShow);
    }

    public void clearBoard() {
        validate();
        printBoard();
    }

    public void validate() {
        if (selectedCardFirst.getCard().equals(selectedCardSecond.getCard())) {
            System.out.println("\t есть совпадение");
        } else {
            updateBoard();
            System.out.println("\t нет угадал");
        }
    }

    private void updateBoard() {
        this.boardToShow[this.selectedCardFirst.rowIndex()][this.selectedCardFirst.columnIndex()] = new Card(EMPTY_FIELD_SYMBOL);
        this.boardToShow[this.selectedCardFirst.rowIndex()][this.selectedCardFirst.columnIndex()] = new Card(EMPTY_FIELD_SYMBOL);
    }
}
