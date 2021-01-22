package com.packt.javapath_redo.ch06demo.api.impl;

import com.packt.javapath_redo.ch06demo.api.Calculator;


public class AnotherCalculatorImpl implements Calculator {
    public int multiplyByTwo(int i){
        System.out.println(AnotherCalculatorImpl.class.getName());
        return i + i;
    }

    public static String addOneAndConvertToString(double d){
        System.out.println(AnotherCalculatorImpl.class.getName());
        return String.format("%.2f", d + 1);
    }
}
