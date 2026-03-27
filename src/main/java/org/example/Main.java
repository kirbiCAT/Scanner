package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {

            public static void main (String[]args) throws InterruptedException, IOException, ParseException {

//                Thread thread = new Thread(new MyRunnable("nice"));
//                thread.start();


                try {
                    JSONObject o = File.readJSON("data.json","");
                    //System.out.println(o.get("active"));
                } catch (Exception e) {
                    System.out.println("Something went wrong!");
                }
//                while(true){
//                    ProcessMonitor.Checker();
//                }
            }
        }
        