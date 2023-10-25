package com.bnt.controller;

import com.bnt.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CalculatorController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;


    @Test
    void getAdditionTest() throws Exception {
        Integer answer = 27;
        Integer num1 = 12;
        Integer num2 = 15;
        String jsonFormat = "{\"answer\":%d,\"detail\":\"%d+%d=%d\"}";
        String jsonResponse = String.format(jsonFormat, answer, num1, num2, answer);

        when(calculatorService.addition(num1, num2)).thenReturn(answer);

        mockMvc.perform(get("/calculatorapi/v1/addition")
                        .param("number1", String.valueOf(num1))
                        .param("number2", String.valueOf(num2))
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(content().json(jsonResponse));


    }

    @Test
    void getSubtractionTest() throws Exception {
        Integer answer = 20;
        Integer num1 = 30;
        Integer num2 = 10;
        String jsonFormat = "{\"answer\":%d,\"detail\":\"%d-%d=%d\"}";
        String jsonResponse = String.format(jsonFormat, answer, num1, num2, answer);

        when(calculatorService.subtraction(num1, num2)).thenReturn(answer);

        mockMvc.perform(get("/calculatorapi/v1/subtraction")
                        .param("number1", String.valueOf(num1))
                        .param("number2", String.valueOf(num2))
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(content().json(jsonResponse));

    }

    @Test
    void getMultiplicationTest() throws Exception {
        Integer answer = 200;
        Integer num1 = 20;
        Integer num2 = 10;
        String jsonFormat = "{\"answer\":%d,\"detail\":\"%d*%d=%d\"}";
        String jsonResponse = String.format(jsonFormat, answer, num1, num2, answer);

        when(calculatorService.multiplication(num1, num2)).thenReturn(answer);

        mockMvc.perform(get("/calculatorapi/v1/multiplication")
                        .param("number1", String.valueOf(num1))
                        .param("number2", String.valueOf(num2))
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(content().json(jsonResponse));

    }

    @Test
    void getDivisionTest() throws Exception {
        Double answer = 0.8;
        Integer num1 = 12;
        Integer num2 = 15;
        String jsonFormat = "{\"answer\":0.8,\"detail\":\"12/15=0.8\"}";

        when(calculatorService.division(num1, num2)).thenReturn(answer);

        mockMvc.perform(get("/calculatorapi/v1/division")
                        .param("number1", String.valueOf(num1))
                        .param("number2", String.valueOf(num2))
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(content().json(jsonFormat));

    }

    @Test
    void getSquareTest() throws Exception {
        Integer answer = 25;
        Integer num1 = 5;
        String jsonFormat = "{\"answer\":%d,\"detail\":\"square of %d=%d\"}";
        String jsonResponse = String.format(jsonFormat, answer, num1, answer);

        when(calculatorService.square(num1)).thenReturn(answer);

        mockMvc.perform(get("/calculatorapi/v1/square/" + num1))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponse));

    }


    @Test
    void getSquareRootTest() throws Exception {
        Integer answer = 15;
        Integer num1 = 225;
        String jsonFormat = "{\"answer\":%d,\"detail\":\"square root of%d=%d\"}";
        String jsonResponse = String.format(jsonFormat, answer, num1, answer);

        when(calculatorService.squareRoot(num1)).thenReturn(answer);

        mockMvc.perform(get("/calculatorapi/v1/squareroot/" + num1))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponse));

    }

    @Test
    void getFactorialTest() throws Exception {
        Integer answer = 120;
        Integer num1 = 5;
        String jsonFormat = "{\"answer\":%d,\"detail\":\"factorial of%d!=%d\"}";
        String jsonResponse = String.format(jsonFormat, answer, num1, answer);

        when(calculatorService.factorial(num1)).thenReturn(answer);

        mockMvc.perform(get("/calculatorapi/v1/factorial/" + num1))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponse));

    }

    @Test
    void getMinMaxTest() throws Exception {

        Map<String, Integer> minMax = new HashMap<>();
        minMax.put("min", -15);
        minMax.put("max", 19);
        Integer min = -15;
        Integer max = 19;
        Integer[] input = new Integer[]{10, -5, 7, 15, -7, -6, 16, 19, -15, 9};
        String jsonFormat = "{ \"min\":%d, \"max\":%d }";
        String jsonResponse = String.format(jsonFormat,min,max);

        when(calculatorService.minMax(input)).thenReturn(minMax);

        mockMvc.perform(post("/calculatorapi/v1/min-max")
                .contentType(MediaType.APPLICATION_JSON)
                        .content(" { \"numbers\" : [10,-5,7,15,-7,-6,16,19,-15,9] }"))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponse));
    }
}