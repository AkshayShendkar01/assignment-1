package com.bnt.service;

import com.bnt.dto.Response;

import java.util.Map;

public interface CalculatorService {

    public Integer addition(Integer num1, Integer num2)throws Exception;

    public Integer subtraction(Integer num1, Integer num2)throws Exception;

    public Integer multiplication(Integer num1, Integer num2)throws Exception ;

    public double division(Integer num1, Integer num2) throws Exception;

    public Integer square(Integer num1)throws Exception;

    public Integer squareRoot(Integer num1)throws Exception;

    public Integer factorial(Integer num1)throws Exception;

    public Map minMax(Integer[] nums) throws Exception;

    public void addToDatabase(String request, Response response,String methodName) throws Exception;

}
