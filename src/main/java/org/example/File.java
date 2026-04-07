package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class File {

    public static synchronized void Wroter(JSONObject APPLICATION) throws IOException {
        FileWriter file = new FileWriter("data.json");
        file.write(APPLICATION.toJSONString());
        file.flush();
        file.close();
    }


    public static synchronized JSONObject readJSON(String filename) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Reader reader;

        try {
            reader = new FileReader(filename);
        } catch (Exception e) {
            System.out.println("failed reading file");
            throw e;
        }

        Object jsonObj = parser.parse(reader);
        JSONObject jsonObject = (JSONObject) jsonObj;
        reader.close();
        return jsonObject;
    }

    //UpdateJsonArray(readJSON("data.json"));



    public static synchronized void UpdateJsonArray(JSONObject jsonObject,String currentApp,String NewValue) throws IOException{
        JSONArray deps = (JSONArray) ((JSONObject) jsonObject).get("software");
        System.out.println("running");
        for (Object dep : deps) {
            JSONObject d = (JSONObject) dep;
            if(d.containsKey(currentApp)) {
                d.put(currentApp,NewValue);
            }
        }
        Wroter(jsonObject);
    }

    public static synchronized boolean ScanIfAppPresentInFile(JSONObject jsonObject,String currentApp) throws IOException{
        JSONArray deps = (JSONArray) ((JSONObject) jsonObject).get("software");

        for (Object dep : deps) {
            JSONObject d = (JSONObject) dep;
            if(d.containsKey(currentApp)) {
                return true;
            }
        }
        return false;
    }


    public static Object ReturnAppValue(JSONObject jsonObject, String currentApp) throws IOException{
        JSONArray deps = (JSONArray) ((JSONObject) jsonObject).get("software");
        for (Object dep : deps) {
            JSONObject d = (JSONObject) dep;
            if(d.containsKey(currentApp)) {

                return d.get(currentApp);
            }
        }
        return null;
    }






}