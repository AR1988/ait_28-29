package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Card;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Andrej Reutow
 * created on 04.08.2023
 */
public class FileService {
    private static final Logger log = LogManager.getLogger(FileService.class);
    private static final String DATA_TIME_FORMAT = "dd-mm-yyyy_HH-mm-ss";
    private static final String FILE_NAME_DELIMITER = "_";
    private static final String GAME_DIR_NAME = "games";


    private FileService() {
        throw new IllegalArgumentException("Utility class");
    }

    public static void printBoardToFile(final Card[][] cardBoard) {
        final File folder = getFolder();

        final String fileName = generateFileName();
        final File file = new File(folder, fileName);

        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            final String boardToString = BoardService.boardToString(cardBoard);
            writer.print(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATA_TIME_FORMAT.replace("_", " "))));
            writer.println();
            writer.print(boardToString);
            log.info("Board printed to file: {}", fileName);
        } catch (IOException e) {
            log.error("Ошибка при создании файла: {}", e.getMessage());
        }
    }

    private static File getFolder() {
        final File folder = new File(GAME_DIR_NAME);
        if (!folder.exists()) {
            try {
                //noinspection ResultOfMethodCallIgnored
                folder.mkdir();
                log.info("Папка с именем '{}' создана по адресу: '{}'", folder.getName(), folder.getAbsoluteFile());
            } catch (SecurityException e) {
                log.error(e.getMessage());
            }
        }
        return folder;
    }

    private static String generateFileName() {
        final String fileNamePrefix = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATA_TIME_FORMAT));
        return fileNamePrefix + FILE_NAME_DELIMITER;
    }
}
