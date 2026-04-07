package org.example;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
//import static org.example.File.FileReader;


public class ProcessMonitor {
static Boolean Checker() throws InterruptedException {
            OpenProcess();
            return true;
    }
    public static Thread getThreadByName(String name) {
        return Thread.getAllStackTraces()
                .keySet()
                .stream()
                .filter(thread -> thread.getName().equals(name))
                .findFirst()
                .orElse(null); // Return null if thread not found
    }
// {"software":[{"smss.exe":0},{"csrss.exe":1},{"wininit.exe":2}]}
     public static String OpenProcess() throws InterruptedException {
        try {
            Process process = Runtime.getRuntime().exec("tasklist");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                    if(line.contains(".exe")){
                        //Thread.sleep(1000);
                        line = line.substring(0, line.indexOf(" "));

                        if(!File.ScanIfAppPresentInFile(File.readJSON("data.json"), line)){
                            //System.out.println("Not found");
                            JSONObject jsonObject = File.readJSON("data.json");
                            JSONObject org = (JSONObject) jsonObject;
                            JSONArray deps = (JSONArray) org.get("software");

                            JSONObject APP = new JSONObject();
                            APP.put(line,"0");
                            deps.add(APP);
                            File.Wroter(jsonObject);


                        }else{
                            //System.out.println("Exist");
                        }
                        //check if app is register and MonitorThread running
                        Thread CurrentThread = getThreadByName(line);
                        if(CurrentThread==null){
                            Thread Newthread = new Thread(new MyRunnable(line));
                            Newthread.start();


                        }


                    }

        }
            //Checker();
        return null;

    } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
     }
}
