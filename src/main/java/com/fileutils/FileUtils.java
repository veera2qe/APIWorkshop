package com.fileutils;


import com.apiutils.HTTPMethods;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtils {
    private static Properties properties;
    Logger logger= Logger.getLogger(HTTPMethods.class.getName());
    public JSONObject getJsonObject(String inputData) throws ParseException {
        JSONParser jsonParser=new JSONParser();
        JSONObject object=(JSONObject)jsonParser.parse(inputData);
        return object;
    }

    public String getJsonValue(String inputData,String key) throws ParseException {
        JSONParser jsonParser=new JSONParser();
        JSONObject object=(JSONObject)jsonParser.parse(inputData);
        return object.get(key).toString();
    }

    public JSONArray getJsonArray(String inputData,String key) throws ParseException {
        JSONParser jsonParser=new JSONParser();
        JSONObject object=(JSONObject)jsonParser.parse(inputData);
        JSONArray array= (JSONArray) object.get(key);
        return array;
    }

    public JSONObject getPayload(String fileName){
        logger.log(Level.INFO,"Getting payload for {0}",new Object[]{fileName});
        try {
            FileReader reader = new FileReader(new File("src/main/resources/payloads/" + fileName + ".json"));
            JSONParser jsonParser = new JSONParser();
            JSONObject object = (JSONObject) jsonParser.parse(reader);
            return object;
        }catch (Exception e){
            logger.log(Level.SEVERE,e.getMessage());
            return null;
        }
    }

    public void loadApplicationProperties(){
        logger.log(Level.INFO,"Loding Application Properties file");
        try(FileInputStream fis=new FileInputStream(new File("src/test/resources/application-configurations/application.properties"))){
            properties=new Properties();
            properties.load(fis);
            logger.log(Level.INFO,"Properties file loaded sucessfully");
        }catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.SEVERE,"Error is loading config file Error : {0}",new Object[]{e.getMessage()});
        }
    }

    public String getApplicationProperties(String key){
        return properties.getProperty(key);
    }

}
