package com.packt.javapath_redo.ch06demo.api.impl;

import com.packt.javapath_redo.ch06demo.api.Calculator;
import com.packt.javapath_redo.ch06demo.api.impl.AnotherCalculatorImpl;
import com.packt.javapath_redo.ch06demo.api.Calculator.WhichImpl;
import com.packt.javapath_redo.ch06demo.Utils;


public class CalculatorFactory {
    public static Calculator create() {
//       String whichImpl = Utils.getStringValueFromConfig(Calculator.CONF_NAME, Calculator.CONF_WHICH_IMPL);
//       if(whichImpl.equals(Calculator.WhichImpl.multiplies.name())){
//           return new CalculatorImpl();
//       } else if (whichImpl.equals(Calculator.WhichImpl.adds.name())){
//           return new AnotherCalculatorImpl();
//       } else {
//           throw new RuntimeException("Houston, we have a problem. " + "Unknown key " + Calculator.CONF_WHICH_IMPL + " value " + whichImpl +
//                   " is in config.");
        WhichImpl whichImpl = Utils.getWhichImplValueFromConfig(Calculator.CONF_NAME, Calculator.CONF_WHICH_IMPL);
        switch(whichImpl){
            case multiplies:
                return new CalculatorImpl();
            case adds:
                return new AnotherCalculatorImpl();
            default:
                throw new RuntimeException("Houston, we have another " +
                        "problem. We do not have implementation for the key " +
                        Calculator.CONF_WHICH_IMPL + " value " + whichImpl);
       }
    }

    public static String addOneAndConvertToString(double d){
        WhichImpl whichImpl = Utils.getWhichImplValueFromConfig(Calculator.CONF_NAME, Calculator.CONF_WHICH_IMPL);
        switch(whichImpl){
            case multiplies:
                return CalculatorImpl.addOneAndConvertToString(d);
            case adds:
                return AnotherCalculatorImpl.addOneAndConvertToString(d);
            default:
                throw new RuntimeException("Houston, we have another " +
                        "problem. We do not have implementation for the key " +
                        Calculator.CONF_WHICH_IMPL + " value " + whichImpl);
        }
    }
}
