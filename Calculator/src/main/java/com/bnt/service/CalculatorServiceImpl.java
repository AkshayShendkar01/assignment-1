package com.bnt.service;

import com.bnt.dto.Response;
import com.bnt.entity.CalculatorEntity;
import com.bnt.repository.CalculatorRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class CalculatorServiceImpl implements CalculatorService {
    @Autowired
    private CalculatorRepository calculatorRepository;


    @Override
    public Integer addition(Integer num1, Integer num2) throws Exception {
        Response response = new Response();
        try {
            int addition = num1 + num2;
            return addition;
        } catch (Exception ex) {
            log.error("error in addition():{}", ex.getMessage());
            throw ex;
        }

    }

    @Override
    public Integer subtraction(Integer num1, Integer num2) throws Exception {
        try {
            return num1 - num2;
        } catch (Exception ex) {
            log.error("error in subtraction():{}", ex.getMessage());
            throw ex;
        }
    }

    @Override
    public Integer multiplication(Integer num1, Integer num2) throws Exception {
        try {
            return num1 * num2;
        } catch (Exception ex) {
            log.error("error in multiplication():{}", ex.getMessage());
            throw ex;
        }

    }

    @Override
    public double division(Integer num1, Integer num2) throws Exception {
        double ans = 0;
        try {
            ans = Double.valueOf(num1) / Double.valueOf(num2);
        } catch (Exception ex) {
            log.error("error in division():{}", ex.getMessage());
            throw ex;
        }
        return ans;
    }

    @Override
    public Integer square(Integer num1) throws Exception {
        return num1 * num1;
    }

    @Override
    public Integer squareRoot(Integer num1) throws Exception {
        try {
            return (int) Math.sqrt(num1);
        } catch (Exception ex) {
            log.error("error in squareRoot():{}", ex.getMessage());
            throw ex;
        }
    }

    @Override
    public Integer factorial(Integer num1) throws Exception {
        int i = 1, fact = 1;
        try {
            while (i <= num1) {
                fact = fact * i;
                i++;
            }
        } catch (Exception ex) {
            log.error("error in factorial():{}", ex.getMessage());
            throw ex;
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

            minMax.put("min", min.get());
            minMax.put("max", max.get());

        } catch (Exception ex) {
            log.error("error in minMax():{}", ex.getMessage());
            throw ex;
        }
        return minMax;
    }

    @Override
    @Transactional
    @Cacheable(value = "calculatorCache", key = "#methodName +':'+ #request")
    public void addToDatabase(String request, Response response,String methodName) throws Exception {
        log.info("Start addToDatabase()");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            String responseString = objectMapper.writeValueAsString(response);
            CalculatorEntity calculatorEntity = new CalculatorEntity();
            calculatorEntity.setRequest(request);
            calculatorEntity.setResponse(responseString);
            calculatorRepository.save(calculatorEntity);
        } catch (Exception ex) {
            log.error("error in addToDatabase() :{}", ex.getMessage());
            throw ex;
        } finally {
            log.info("End addToDatabase()");
        }
    }
}
