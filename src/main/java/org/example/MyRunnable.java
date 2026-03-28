package org.example;

import org.json.simple.JSONObject;

public class MyRunnable implements Runnable{
    private static String ThreadAppName;

    public MyRunnable(String ThreadAppName){
        MyRunnable.ThreadAppName = ThreadAppName;
    }
//    public static String GetName(String ThreadAppName){
//        ThreadAppName=Thread.currentThread().getName();
//        return ThreadAppName;
//    }

    @Override
    public void run() {
        Thread.currentThread().setName(ThreadAppName);
        try {
            JSONObject o = File.readJSON("data.json");
            if(ProcessMonitor.Checker()){

            }
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }

    }
    public void StartTimer(){

    }
    public static void UpdateTime(String ThreadAppName){
        //get current app time
        //open file
        //set new time

    }
}
