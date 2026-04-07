package org.example;

import org.json.simple.JSONObject;

import java.time.Duration;
import java.time.Instant;

import static org.example.ProcessMonitor.*;

public class MyRunnable implements Runnable{
    private final String ThreadAppName;

    public MyRunnable(String threadAppName) {
        ThreadAppName = threadAppName;
    }
//IF RUNNING = APP OPEN + APP REGISTERED
    @Override
    public void run() {
        Thread.currentThread().setName(ThreadAppName);
        System.out.println(ThreadAppName);
            try {

                Thread.sleep(1000);
                //System.out.println("thread");
                String AppValue = String.valueOf(File.ReturnAppValue(File.readJSON("data.json"),ThreadAppName));
                Float AppValue2 = Float.valueOf(AppValue);
                Float NewTime = Time.CurrentTime() + AppValue2;
                Time.UpdateTime(ThreadAppName, String.valueOf(NewTime));



            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }


    }

}
