package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        LocalDateTime newYear = LocalDateTime.of(LocalDateTime.now().getYear() + 1, 1, 1, 0, 0, 0);
        Duration duration;

        for (LocalDateTime now = LocalDateTime.now(); now != newYear; now = LocalDateTime.now()) {
            duration = Duration.between(now, newYear);
            long days = duration.toDays();
            long hours = duration.toHours() % 24;
            long minutes = duration.toMinutes() % 60;
            long seconds = duration.toSeconds() % 60;

            System.out.printf("Days: %d %02d:%02d:%02d%n", days, hours, minutes, seconds);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
        }
    }
}