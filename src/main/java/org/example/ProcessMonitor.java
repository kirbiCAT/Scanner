package org.example;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import static org.example.File.FileReader;
import static org.example.File.Wroter;

public class ProcessMonitor {
    //if app is still open
    static void Checker() throws InterruptedException {
        if(isProcessOpen()!=null){
            isProcessOpen();
            //Scan apps open first app--> open json.file check if app exist else add app + actual time else increase time

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
            JSONArray APPLICATION = new JSONArray();
            FileWriter file = new FileWriter("data.json");
            while ((line = reader.readLine()) != null) {
                    if(line.contains(".exe")){
                        line = line.substring(0, line.indexOf(" "));
                        JSONObject obj = new JSONObject();
                        JSONObject APP = new JSONObject();
                        APP.put(line,value);
                        APPLICATION.add(APP);
                        obj.put("software", APPLICATION);
                        Wroter(obj);
                        System.out.println(obj);
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
