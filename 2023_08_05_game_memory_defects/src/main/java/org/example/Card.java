package org.example;

import java.util.Random;

public class Card {

    public static char[] icons = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

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
}
