package com.packt.javapath_redo.ch06demo.api;

import com.packt.javapath_redo.ch06demo.api.impl.CalculatorFactory;

public interface Calculator {
    int multiplyByTwo(int i);

    //createInstance static method of the interface
    static Calculator createInstance() {
        return CalculatorFactory.create();
    }

    static String addOneAndConvertToString(double d){
        return CalculatorFactory.addOneAndConvertToString(d);
    }

    String CONF_NAME = "calculator.conf";   //file name
    String CONF_WHICH_IMPL = "which.impl";  //key in the .conf file
    enum WhichImpl {
        multiplies, // use multiplication operation
                    // and returns addOneAndConvertToString()
                    // result without formatting
        adds // use addition operation
             // and returns addOneAndConvertToString()
             // result with two decimals only
    }
}
