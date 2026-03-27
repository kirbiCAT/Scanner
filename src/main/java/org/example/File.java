package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class File {

    public static void FileWriter(String line,int value) throws IOException {
        Path filePath = Paths.get("data.json");
        //JSONObject obj = new JSONObject();
        //JSONArray APPLICATION = new JSONArray();
        if (Files.exists(filePath)) {
            try {
                JSONObject APP = new JSONObject();
                APP.put(line,value);
                //APPLICATION.add(APP);
                //obj.put("software", APPLICATION);
                Wroter(APP);
                System.out.println(APP);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("The file does not exist.");
        }
    }
    public static void Wroter(JSONObject APPLICATION) throws IOException {
        FileWriter file = new FileWriter("data.json");
        file.write(APPLICATION.toJSONString());
        file.flush();
        file.close();
    }
    private static JSONObject getObjectFromDocument(JSONObject doc, String key) {
        if(doc.containsKey(key)) {
            Object simpleObject = doc.get(key);
            if(simpleObject instanceof JSONObject) {
                return (JSONObject)simpleObject;
            }
        }
        return null;
    }
    public static JSONObject readJSON(String filename,String time) throws IOException, ParseException {
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
        JSONObject org = (JSONObject) jsonObject;
        JSONArray deps = (JSONArray) org.get("software");

        for (Object dep : deps) {
            JSONObject d = (JSONObject) dep;
            if(d.containsKey("csrss.exe")) {
                System.out.println(d.get("csrss.exe"));
                d.put("csrss.exe",time);
            }
        }
        Wroter(jsonObject);
        reader.close();
        return jsonObject;
    }
}