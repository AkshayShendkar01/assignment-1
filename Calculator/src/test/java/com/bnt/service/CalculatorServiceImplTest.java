package com.bnt.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceImplTest {

    @InjectMocks
    private CalculatorServiceImpl calculatorService;

    @Test
    void additionTest() {
        Integer answer =30;
        Integer addition = calculatorService.addition(10, 20);
        assertEquals(answer,addition);
    }

    @Test
    void subtractionTest() {
        Integer answer = -10;
        Integer subtraction = calculatorService.subtraction(10, 20);
        assertEquals(answer,subtraction);
    }

    @Test
    void multiplicationTest() throws Exception {
        Integer answer = 200;
        Integer multiplication = calculatorService.multiplication(10, 20);
        assertEquals(answer,multiplication);
    }


    @Test
    void divisionTest() throws Exception {
        Double answer = 0.8;
        Double division = calculatorService.division(12,15);
        assertEquals(answer,division);
    }

    @Test
    void squareTest() {
        Integer answer =25;
        Integer square = calculatorService.square(5);
        assertEquals(answer,square);
    }

    @Test
    void squareRootTest() {
        Integer answer =15;
        Integer squareRoot = calculatorService.squareRoot(225);
        assertEquals(answer,squareRoot);
    }

    @Test
    void factorialTest() {
        Integer answer =120;
        Integer factorial = calculatorService.factorial(5);
        assertEquals(answer,factorial);
    }

    @Test
    void minMaxTest() throws Exception {
        Integer min=-15;
        Integer max= 19;
        Map map = calculatorService.minMax(new Integer[]{10, -5, 7, 15, -7, -6, 16, 19, -15, 9});
        assertEquals(min,map.get("min"));
        assertEquals(max,map.get("max"));
    }
}