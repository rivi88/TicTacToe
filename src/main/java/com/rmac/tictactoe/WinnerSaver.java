package com.rmac.tictactoe;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinnerSaver {
    List<String> scores = new ArrayList<>();

    public static void main(String[] args) {
        var ws = new WinnerSaver();
        ws.readScore();
        ws.savesScore(new Player("dd",  'X'));
    }

    public String readScore() {
        Path path = getPath();
        List<String> fileLines;
        try (Stream<String> stream = Files.lines(path)){
            fileLines = stream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        scores.addAll(fileLines);
        return scores.toString(); // todo format listy wyników
    }
//    ofLocalizedDateTime(dateStyle,timeStyle)	Formatter with date and time styles from the locale	'3 Jun 2008 11:05'

    public void savesScore(PlayerInterface player) {
        Path path = getPath();
        var df =  DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(new Locale("PL", "pl"));
        String s = df.format(LocalDateTime.now());
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            scores.add(0, player.getName() + " - " + s); // todo format daty
            if (scores.size() >  20) {
                scores.remove(19);
            }

            String collect = String.join("\n", scores);
            writer.write(collect);
        } catch (IOException e) {
            System.out.println("wystąpił błąd: " + e);
        }
    }

    private Path getPath() {
//        ClassLoader classLoader = WinnerSaver.class.getClassLoader();
//        File file = new File(classLoader.getResource("Scores.txt").getFile());
       return Paths.get("Scores.txt");
    }

}
