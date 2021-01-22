package com.packt.javapath_redo.ch06demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.packt.javapath_redo.ch06demo.Utils;
import com.packt.javapath_redo.ch06demo.api.Calculator.WhichImpl;


@DisplayName("Utils tests")
public class UtilsTest {
    @Test
    @DisplayName("Test reading value from config file by key")
    void getStringValueFromConfig() {
        String fileName = "utilstest.conf";
        String value = Utils.getStringValueFromConfig(fileName, "unknown");
        assertEquals("unknown", value);

        value = Utils.getStringValueFromConfig(fileName, "2");
        assertEquals("adds", value);
    }

    @Test
    @DisplayName("Test matching config value to enum WhichImpl")
    void getWhichImplValueFromConfig(){
        String confifFileName = "utilstest.conf";
        for(int i = 1; i <= WhichImpl.values().length; i++){
            String key = String.valueOf(i);
            WhichImpl whichImpl = Utils.getWhichImplValueFromConfig(confifFileName, key);
            System.out.println(key + "=" + whichImpl);
        }
        try{
            WhichImpl whichImpl = Utils.getWhichImplValueFromConfig(confifFileName, "unknown");
            fail("Should not get here! whichImpl = " + whichImpl);
        } catch (RuntimeException ex) {
            assertEquals("Houston, we have a problem. " +
                            "Unknown key which.impl value unknown is in config.",
                    ex.getMessage());
        }
        try{
            WhichImpl whichImpl = Utils.getWhichImplValueFromConfig(confifFileName, "some value");
            fail("Should not get here! whichImpl = " + whichImpl);
        } catch (RuntimeException ex) {
            assertEquals("Houston, we have a problem. " +
                            "Unknown key which.impl value unknown is in config.",
                    ex.getMessage());
        }
    }
}
