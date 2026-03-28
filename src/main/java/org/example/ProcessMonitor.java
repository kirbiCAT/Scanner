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

    static Boolean Checker() throws InterruptedException {
        if(isProcessOpen()!=null){
            isProcessOpen();
            return true;
        }else{
            System.out.println("KO");
        }
        return false;

    }

    public static Thread getThreadByName(String name) {
        return Thread.getAllStackTraces()
                .keySet()
                .stream()
                .filter(thread -> thread.getName().equals(name))
                .findFirst()
                .orElse(null); // Return null if thread not found
    }

     public static String isProcessOpen() throws InterruptedException {
        try {
            Process process = Runtime.getRuntime().exec("tasklist");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            String value ="Null";
            while ((line = reader.readLine()) != null) {
                    if(line.contains(".exe")){
                        line = line.substring(0, line.indexOf(" "));

                        if(File.ScanIfAppPresent(File.readJSON("data.json"),line)){
                            //get app threadTimer
                            Thread thread = getThreadByName(line);
                            //thread.UpdateTime



                            //MyRunnable.UpdateTime(line);
                            //call current "line" tread update tim

                        }else{
                            File.FileWriter(line,value);
                            //start new thread for monitoring
                            Thread thread = new Thread(new MyRunnable("nice"));
                            thread.start();
                        }

                    }
        }
        return null;
    } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
     }
}
