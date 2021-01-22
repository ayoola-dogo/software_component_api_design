package com.packt.javapath_redo.ch06demo.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.packt.javapath_redo.ch06demo.api.impl.CalculatorFactory;
import com.packt.javapath_redo.ch06demo.Utils;
import com.packt.javapath_redo.ch06demo.api.Calculator.WhichImpl;


@DisplayName("API Calculator tests")
public class CalculatorTest {
    @Test
    @DisplayName("Happy multiplyByTwo()")
    void multiplyByTwo() {
        String whichImpl = Utils.getStringValueFromConfig(Calculator.CONF_NAME, Calculator.CONF_WHICH_IMPL);
        System.out.println(Calculator.CONF_WHICH_IMPL + "=" + whichImpl);
        Calculator calculator = CalculatorFactory.create();
        int i = 2;
        int result = calculator.multiplyByTwo(i);
        assertEquals(4, result);
    }


    @Test
    @DisplayName("Happy addOneAndConvertToString()")
    void addOneAndConvertToString(){
        double d = 2.12345678;
        String mString = "3.12345678";
        String aString = "3.12";
        String s = Calculator.addOneAndConvertToString(d);
//        String whichImpl = Utils.getStringValueFromConfig(Calculator.CONF_NAME, Calculator.CONF_WHICH_IMPL);
        WhichImpl whichImpl = Utils.getWhichImplValueFromConfig(Calculator.CONF_NAME, Calculator.CONF_WHICH_IMPL);
        if(whichImpl.equals(Calculator.WhichImpl.multiplies)){
            assertEquals(mString, s);
        } else {
            assertNotEquals(mString, s);
        }
        if(whichImpl.equals(Calculator.WhichImpl.adds)){
            assertEquals(aString, s);
        } else {
            assertNotEquals(aString, s);
        }
    }
}
