package org.example;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

public class Time {

    public static String removeLastCharOptional(String s) {
        return Optional.ofNullable(s)
                .filter(str -> str.length() != 0)
                .map(str -> str.substring(0, str.length() - 1))
                .orElse(s);
    }



    public static Float CurrentTime() throws InterruptedException {

        Instant start = Instant.now();
        Thread.sleep(1000);
        Instant end = Instant.now();
        Duration currentTimeElapsed = Duration.between(start, end);
        String TOTAL =String.valueOf(currentTimeElapsed);
        String CLEAN =TOTAL.substring(2);
        CLEAN =removeLastCharOptional(CLEAN);
        Float  NOW2 = Float.valueOf(CLEAN);
        return NOW2;
    }


    public static synchronized void UpdateTime(String ThreadAppName,String newValue) throws IOException, ParseException {
        System.out.println("UPDATING TIME");
        File.UpdateJsonArray(File.readJSON("data.json"),ThreadAppName, String.valueOf(newValue));

    }
}
