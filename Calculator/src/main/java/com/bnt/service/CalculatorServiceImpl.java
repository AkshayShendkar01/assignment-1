package com.bnt.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public Integer addition(Integer num1, Integer num2) {
        return num1 + num2;
    }

    @Override
    public Integer subtraction(Integer num1, Integer num2) {
        return num1 - num2;
    }

    @Override
    public Integer multiplication(Integer num1, Integer num2)  {

        return num1 * num2;
    }

    @Override
    public double division(Integer num1, Integer num2) throws Exception {
        double ans = 0;
        try {
            ans = Double.valueOf(num1) / Double.valueOf(num2);
        } catch (Exception ex) {
            throw ex;
        }
        return ans;
    }

    @Override
    public Integer square(Integer num1) {
        return num1 * num1;
    }

    @Override
    public Integer squareRoot(Integer num1) {
        return (int) Math.sqrt(num1);
    }

    @Override
    public Integer factorial(Integer num1) {
        int i = 1, fact = 1;
        while (i <= num1) {
            fact = fact * i;
            i++;
        }
        return fact;
    }

    @Override
    public Map minMax(Integer[] nums) throws Exception {
        Map<String, Integer> minMax = new HashMap<>();
        try {
            List<Integer> numList = Arrays.asList(nums);
            Optional<Integer> max = numList.stream().max(Comparator.naturalOrder());
            Optional<Integer> min = numList.stream().min(Comparator.naturalOrder());

            minMax.put("min",min.get());
            minMax.put("max",max.get());

        } catch (Exception ex) {
            throw ex;
        }
        return minMax;
    }


}
