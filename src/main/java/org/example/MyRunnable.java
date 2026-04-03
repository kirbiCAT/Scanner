package org.example;

import org.json.simple.JSONObject;

import java.time.Duration;
import java.time.Instant;

public class MyRunnable implements Runnable{
    private final String ThreadAppName;

    public MyRunnable(String threadAppName) {
        ThreadAppName = threadAppName;
    }
//IF RUNNING = APP OPEN + APP REGISTERED
    @Override
    public void run() {
        Thread.currentThread().setName(ThreadAppName);
        try {
                while(ProcessMonitor.Checker()){
                    Thread.sleep(1000);
                    System.out.println("thread");
                    Time.UpdateTime(ThreadAppName,"69");
                };


        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }

    }

}
