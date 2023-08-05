package org.example;

import java.util.Objects;
import java.util.Random;

public class Card {

    public static char[] icons = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ!$%&/()".toCharArray();

    private final char symbol;

    public Card() {
        this.symbol = icons[new Random().nextInt(icons.length - 1)];
    }

    public Card(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return symbol == card.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }
}
