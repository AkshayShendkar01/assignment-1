package com.bnt.controller;

import com.bnt.dto.Request;
import com.bnt.dto.Response;
import com.bnt.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("calculatorapi/v1/")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("addition")
     public ResponseEntity<Response> getAddition(@RequestParam(name = "number1") Integer num1, @RequestParam(name = "number2") Integer num2){
        Integer add = calculatorService.addition(num1, num2);
        String details = num1+"+"+num2+"="+add;
        Response response =new Response();
        response.setAnswer(add);
        response.setDetail(details);
        return new ResponseEntity<>(response, HttpStatus.OK);
     }

    @GetMapping("subtraction")
    public ResponseEntity<Response> getSubtraction(@RequestParam(name = "number1") Integer num1, @RequestParam(name = "number2") Integer num2){
        Integer sub = calculatorService.subtraction(num1, num2);
        String details = num1+"-"+num2+"="+sub;
        Response response =new Response();
        response.setAnswer(sub);
        response.setDetail(details);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("multiplication")
    public ResponseEntity<Response> getMultiplication(@RequestParam(name = "number1") Integer num1, @RequestParam(name = "number2") Integer num2){
        Integer mul = null;
        Response response =new Response();
            mul = calculatorService.multiplication(num1, num2);
            String details = num1+"*"+num2+"="+mul;
            response.setAnswer(mul);
            response.setDetail(details);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("division")
    public ResponseEntity<Response> getDivision(@RequestParam(name = "number1") Integer num1, @RequestParam(name = "number2") Integer num2){
        Double div = null;
        Response response =new Response();
        try {
            div = calculatorService.division(num1, num2);
            String details = num1+"/"+num2+"="+div;
            response.setAnswer(div);
            response.setDetail(details);
        } catch (Exception ex) {
            response.setDetail(ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("square/{num}")
    public ResponseEntity<Response> getSquare(@PathVariable(name = "num") Integer num1){
        Integer square = calculatorService.square(num1);
        String details = "square of "+num1+"="+square;
        Response response =new Response();
        response.setAnswer(square);
        response.setDetail(details);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("squareroot/{num}")
    public ResponseEntity<Response> getSquareRoot(@PathVariable(name = "num") Integer num1){
        Integer squareRoot = calculatorService.squareRoot(num1);
        String details = "square root of"+num1+"="+squareRoot;
        Response response =new Response();
        response.setAnswer(squareRoot);
        response.setDetail(details);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("factorial/{num}")
    public ResponseEntity<Response> getFactorial(@PathVariable(name = "num") Integer num1){
        Integer factorial = calculatorService.factorial(num1);
        String details = "factorial of"+num1+"!="+factorial;
        Response response =new Response();
        response.setAnswer(factorial);
        response.setDetail(details);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("min-max")
    public ResponseEntity<Response> getMinMax(@RequestBody Request request){
        Response response =new Response();
        try {
            Map minMax = calculatorService.minMax(request.getNumbers());
            response.setMax((Integer) minMax.get("max"));
            response.setMin((Integer) minMax.get("min"));
        } catch (Exception ex) {
            response.setDetail(ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
