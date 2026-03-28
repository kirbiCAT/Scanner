package org.example;

import org.json.simple.JSONObject;

public class MyRunnable implements Runnable{
    private final String ThreadAppName;

    public MyRunnable(String threadAppName) {
        ThreadAppName = threadAppName;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(ThreadAppName);
        try {
            JSONObject o = File.readJSON("data.json");
            if(ProcessMonitor.Checker()){

            }else{

            }
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }

    }

}
