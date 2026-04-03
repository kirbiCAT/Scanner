package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {

            public static void main (String[]args) throws InterruptedException, IOException, ParseException {

                //Time.UpdateTime("smss.exe", String.valueOf(2));
//                File.UpdateJsonArray(File.readJSON("data.json"),"smss.exe",String.valueOf(2));
                while(true){
                    ProcessMonitor.Checker();
                }
//            }

                //System.out.println(Time.CurrentTime());
                //Time.UpdateTime("smss.exe","69");
        }}
        