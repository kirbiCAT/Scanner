package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class File {

    public static void FileWriter(String line,int value) throws IOException {
        Path filePath = Paths.get("data.json");
        JSONArray APPLICATION = new JSONArray();
        if (Files.exists(filePath)) {
            try {
                JSONObject APP = new JSONObject();
                APP.put(line,value);
                APPLICATION.add(APP);
                FileReader();
                Wroter(APPLICATION);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("The file does not exist.");
        }
    }
    public static void Wroter(JSONArray APPLICATION) throws IOException {
        FileWriter file = new FileWriter("data.json");
        file.write(APPLICATION.toJSONString());
        file.flush();
        file.close();
    }
    public static void FileReader() throws FileNotFoundException {
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader("data.json");

    }
}