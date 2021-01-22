package com.packt.javapath_redo.ch06demo;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import com.packt.javapath_redo.ch06demo.api.Calculator.WhichImpl;
import com.packt.javapath_redo.ch06demo.api.Calculator;


public class Utils {
    private static JSONObject config = null;

    public static String getStringValueFromConfig(String configFileName, String key) {
        if(config == null){
            ClassLoader classloader = Utils.class.getClassLoader();

            try{
                URI uri = new URI(classloader.getResource(configFileName).toString());
                File file = new File(uri.getPath());
                FileReader fr = new FileReader(file);
                JSONParser parser = new JSONParser();
                config = (JSONObject) parser.parse(fr);
            } catch (ParseException | IOException | URISyntaxException | NullPointerException err){
                err.printStackTrace();
                return err.getMessage() + "Problem reading config file.";
            }
        }
        return config.get(key) == null ? "unknown" : (String)config.get(key);
    }

    public static WhichImpl getWhichImplValueFromConfig(String configName, String key) {
        String whichImpl = getStringValueFromConfig(configName, key);
            try{
                return WhichImpl.valueOf(whichImpl);
//                return Enum.valueOf(WhichImpl.class, whichImpl);
            } catch (IllegalArgumentException ex) {
                throw new RuntimeException("Houston, we have a problem. " +
                        "Unknown key " + Calculator.CONF_WHICH_IMPL +
                        " value " + whichImpl + " is in config.");
            }
    }
}
