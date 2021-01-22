package com.packt.javapath_redo.ch06demo.api.impl;

import com.packt.javapath_redo.ch06demo.api.Calculator;

public class CalculatorImpl implements Calculator {

    public int multiplyByTwo(int i){
        System.out.println(CalculatorImpl.class.getName());
        return i * 2;
    }

    public static String addOneAndConvertToString(double d){
        System.out.println(CalculatorImpl.class.getName());
        return Double.toString(d + 1);
    }
}
