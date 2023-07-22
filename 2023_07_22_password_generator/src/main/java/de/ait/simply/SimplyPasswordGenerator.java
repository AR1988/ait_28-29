package de.ait.simply;

import java.util.Random;

/**
 * @author Andrej Reutow
 * created on 22.07.2023
 */
public class SimplyPasswordGenerator {

    private static final int PASS_LENGTH = 20;

    public static void main(String[] args) {

        final String password = generatePassword(PASS_LENGTH);

        System.out.println(password);
    }

    private static String generatePassword(final int length) {
        final Random random = new Random();

        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < length; i++) {
            buffer.append(getRandomSymbol(random));
        }

        return buffer.toString();
    }

    private static char getRandomSymbol(Random random) {
        final int min = 32;
        final int max = 125;
        return (char) (random.nextInt(max - min) + min);
    }
}
