package com.bnt.service;

import java.util.Map;

public interface CalculatorService {

    public Integer addition(Integer num1, Integer num2);

    public Integer subtraction(Integer num1, Integer num2);

    public Integer multiplication(Integer num1, Integer num2) ;

    public double division(Integer num1, Integer num2) throws Exception;

    public Integer square(Integer num1);

    public Integer squareRoot(Integer num1);

    public Integer factorial(Integer num1);

    public Map minMax(Integer[] nums) throws Exception;

}
