package de.ait;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.time.LocalDateTime;

/**
 * @author Andrej Reutow
 * created on 05.08.2023
 */
public class Main {

    private static final int FINISH_IN_H = 8;

    private static final String BREAK_END = "break-end.wav";
    private static final String BREAK_START = "break-start.wav";
    private static final int WORK_DURATION = 25;
    private static final int BREAK_LONG_DURATION = 30;
    private static final int BREAK_SHORT_DURATION = 5;

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
//        now.plusHours(FINISH_IN_H);
        LocalDateTime localDateTime = now.plusMinutes(1);

        int counter = 0;
        while (now.isBefore(localDateTime)) {
            counter++;

            alert(BREAK_END);
            System.out.println("Время работать");
            sleep(WORK_DURATION);

            alert(BREAK_START);
            System.out.println("Пауза старт");
            sleep(counter % 4 == 0 ? BREAK_LONG_DURATION : BREAK_SHORT_DURATION);

            alert(BREAK_END);
            System.out.println("Пауза закончилась");

            now = LocalDateTime.now();
            System.out.println(now);
        }
    }

    private static void sleep(int sleepTimeInMin) {
//        long sleepTimeInMs = sleepTimeInMin * 1000 * 60;
        long sleepTimeInMs = sleepTimeInMin * 100;
        try {
            Thread.sleep(sleepTimeInMs);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void alert(String fileName) {
        try (AudioInputStream player = AudioSystem.getAudioInputStream(Main.class.getResource("/sound/" + fileName))) {
            Clip clip = AudioSystem.getClip();
            clip.open(player);
            clip.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
