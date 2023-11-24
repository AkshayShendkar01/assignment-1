package com.bnt.service;

import com.bnt.dto.Response;
import com.bnt.entity.CalculatorEntity;
import com.bnt.repository.CalculatorRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceImplTest {

    @InjectMocks
    private CalculatorServiceImpl calculatorService;

    @Mock
    private CalculatorRepository calculatorRepository;

    @Test
    void additionTest() throws Exception {
        Integer answer =30;
        Integer addition = calculatorService.addition(10, 20);
        assertEquals(answer,addition);
    }

    @Test
    void subtractionTest() throws Exception {
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
    void squareTest() throws Exception {
        Integer answer =25;
        Integer square = calculatorService.square(5);
        assertEquals(answer,square);
    }

    @Test
    void squareRootTest() throws Exception {
        Integer answer =15;
        Integer squareRoot = calculatorService.squareRoot(225);
        assertEquals(answer,squareRoot);
    }

    @Test
    void factorialTest() throws Exception {
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

    @Test
    @Transactional
    void addToDatabaseTest() throws JsonProcessingException {
        String request = 10+","+20;
        String details = 10 + "+" + 20 + "=" + 30;

        Response response =new Response();
        response.setAnswer(30);
        response.setDetail(details);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String responseString = objectMapper.writeValueAsString(response);

        CalculatorEntity calculatorEntity = new CalculatorEntity();
        calculatorEntity.setId(10);
        calculatorEntity.setRequest(request);
        calculatorEntity.setResponse(responseString);
        calculatorEntity.setCreatedOn(LocalDateTime.now());

        when(calculatorRepository.save(any(CalculatorEntity.class))).thenReturn(calculatorEntity);
        CalculatorEntity result = calculatorRepository.save(calculatorEntity);
        assertNotNull(result);
        assertEquals(request,result.getRequest());
    }
}