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

//    public static void FileWriter(String line,String time) throws IOException {
//        Path filePath = Paths.get("data.json");
//        FileWriter file = new FileWriter("data.json");
//
//        JSONObject MainObj = new JSONObject();
//
//        if (Files.exists(filePath)) {
//            try {
//                JSONObject APP = new JSONObject();
//                JSONArray APPLICATION = new JSONArray();
//
//                APP.put(line,time);
//                APPLICATION.add(APP);
//                MainObj.put("software", APPLICATION);
//
//                Wroter(MainObj);
//
//                System.out.println(MainObj);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            System.out.println("The file does not exist.");
//        }
//    }

    public static void Wroter(JSONObject APPLICATION) throws IOException {
        FileWriter file = new FileWriter("data.json");
        file.write(APPLICATION.toJSONString());
        file.flush();
        file.close();
    }


    public static JSONObject readJSON(String filename) throws IOException, ParseException {
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

    public static void AddJsonObject(JSONObject jsonObject,String currentApp,String NewValue){
        JSONArray deps = (JSONArray) jsonObject.put(currentApp,NewValue);
    }




    public static void UpdateJsonArray(JSONObject jsonObject,String currentApp,String NewValue) throws IOException{
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

    public static boolean ScanIfAppPresentInFile(JSONObject jsonObject,String currentApp) throws IOException{
        JSONArray deps = (JSONArray) ((JSONObject) jsonObject).get("software");

        for (Object dep : deps) {
            JSONObject d = (JSONObject) dep;
            if(d.containsKey(currentApp)) {
                return true;
            }
        }
        return false;
    }


    public static JSONObject ReturnAppValue(JSONObject jsonObject, String currentApp) throws IOException{
        JSONArray deps = (JSONArray) ((JSONObject) jsonObject).get("software");

        for (Object dep : deps) {
            JSONObject d = (JSONObject) dep;
            if(d.containsKey(currentApp)) {
                return d;
            }
        }
        return null;
    }






}