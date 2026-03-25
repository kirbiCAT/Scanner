package org.example;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.example.File.FileReader;
import static org.example.File.Wroter;


public class ProcessMonitor {
    //if app is still open
    static void Checker() throws InterruptedException {
        if(isProcessOpen()!=null){
            isProcessOpen();
            Thread.sleep(1000);
        }else{
            Thread.sleep(1000);
            System.out.println("KO");
        }
    }
     public static String isProcessOpen() throws InterruptedException {
        try {
            Process process = Runtime.getRuntime().exec("tasklist");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            int value =0;
            String processName = "Discord.exe";
            JSONArray APPLICATION = new JSONArray();
            while ((line = reader.readLine()) != null) {
                    if(line.contains(".exe")){
                        System.out.println(line);
                        JSONObject APP = new JSONObject();
                        APP.put(line,value);
                        APPLICATION.add(APP);
                        FileReader();
                        Wroter(APPLICATION);
                        Thread.sleep(1000);
                        value +=1;
                    }
        }
        return null;
    } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
