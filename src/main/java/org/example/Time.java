package org.example;

import java.time.Duration;
import java.time.Instant;

public class Time {

    public static void minutes(){
        Instant start = Instant.now();
        // time passes
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
    }

    public void StartTimer(){

    }
    public static void UpdateTime(String ThreadAppName){
        //get current app time
        //open file
        //set new time

    }
}
