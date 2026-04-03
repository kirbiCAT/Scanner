package org.example;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class Time {

    public static String CurrentTime() throws InterruptedException {

        Instant start = Instant.now();
        Thread.sleep(1000);
        Instant end = Instant.now();
        Duration currentTimeElapsed = Duration.between(start, end);
        return String.valueOf(currentTimeElapsed);
    }


    public static void UpdateTime(String ThreadAppName,String newValue) throws IOException, ParseException {
        File.UpdateJsonArray(File.readJSON("data.json"),ThreadAppName,newValue);

    }
}
