package org.example;

import java.util.Objects;

public final class SelectedCard {
    private final int rowIndex;
    private final int columnIndex;
    private Card card;

    public SelectedCard(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public int rowIndex() {
        return rowIndex;
    }

    public int columnIndex() {
        return columnIndex;
    }

    public Card card() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (SelectedCard) obj;
        return this.rowIndex == that.rowIndex &&
                this.columnIndex == that.columnIndex &&
                Objects.equals(this.card, that.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowIndex, columnIndex, card);
    }

    @Override
    public String toString() {
        return "SelectedCard[" +
                "rowIndex=" + rowIndex + ", " +
                "columnIndex=" + columnIndex + ", " +
                "card=" + card + ']';
    }


}
