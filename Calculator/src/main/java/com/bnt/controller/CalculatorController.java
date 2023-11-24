package com.bnt.controller;

import com.bnt.dto.Request;
import com.bnt.dto.Response;
import com.bnt.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("calculatorapi/v1/")
@Slf4j
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("addition")
    public ResponseEntity<Response> getAddition(@RequestParam(name = "number1") Integer num1, @RequestParam(name = "number2") Integer num2) {
        log.info("Start getAddition()");
        Response response = new Response();
        try {
            Integer add = calculatorService.addition(num1, num2);
            String details = num1 + "+" + num2 + "=" + add;
            response.setAnswer(add);
            response.setDetail(details);
        } catch (Exception e) {
            log.error("error in getAddition() :{}", e.getMessage());
            response.setDetail(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } finally {
            try {
                String request = num1+","+num2;
                calculatorService.addToDatabase(request, response,"addition");
            } catch (Exception ex) {
                log.error("error in getAddition :: addToDatabase :{}", ex);
                response.setAnswer(null);
                response.setDetail(ex.getMessage());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            log.info("getAddition() :: Request : number1 :{}, number2 :{} :: Response :{}", num1, num2, response);
            log.info("End getAddition()");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("subtraction")
    public ResponseEntity<Response> getSubtraction(@RequestParam(name = "number1") Integer num1, @RequestParam(name = "number2") Integer num2) {
        log.info("Start getSubtraction()");
        Response response = new Response();
        try {
            Integer sub = calculatorService.subtraction(num1, num2);
            String details = num1 + "-" + num2 + "=" + sub;
            response.setAnswer(sub);
            response.setDetail(details);
        } catch (Exception e) {
            log.error("error in getSubtraction() :{}", e.getMessage());
            response.setDetail(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } finally {
            try {
                String request = num1+","+num2;
                calculatorService.addToDatabase(request, response,"subtraction");
            } catch (Exception ex) {
                log.error("error in getSubtraction :: addToDatabase :{}", ex);
                response.setAnswer(null);
                response.setDetail(ex.getMessage());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            log.info("getSubtraction() :: Request : number1 :{}, number2 :{} :: Response :{}", num1, num2, response);
            log.info("End getSubtraction()");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("multiplication")
    public ResponseEntity<Response> getMultiplication(@RequestParam(name = "number1") Integer num1, @RequestParam(name = "number2") Integer num2) {
        log.info("Start getMultiplication()");
        Integer mul = null;
        Response response = new Response();
        try {
            mul = calculatorService.multiplication(num1, num2);
            String details = num1 + "*" + num2 + "=" + mul;
            response.setAnswer(mul);
            response.setDetail(details);
        } catch (Exception e) {
            log.error("error in getMultiplication() :{}", e.getMessage());
            response.setDetail(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } finally {
            try {
                String request = num1+","+num2;
                calculatorService.addToDatabase(request, response,"multiplication");
            } catch (Exception ex) {
                log.error("error in getMultiplication :: addToDatabase :{}", ex);
                response.setAnswer(null);
                response.setDetail(ex.getMessage());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            log.info("getMultiplication() :: Request : number1 :{}, number2 :{} :: Response :{}", num1, num2, response);
            log.info("End getMultiplication()");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("division")
    public ResponseEntity<Response> getDivision(@RequestParam(name = "number1") Integer num1, @RequestParam(name = "number2") Integer num2) {
        log.info("Start getDivision()");
        Double div = null;
        Response response = new Response();
        try {
            div = calculatorService.division(num1, num2);
            String details = num1 + "/" + num2 + "=" + div;
            response.setAnswer(div);
            response.setDetail(details);
        } catch (Exception ex) {
            log.error("error in getDivision() :{}", ex.getMessage());
            response.setDetail(ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } finally {
            try {
                String request = num1+","+num2;
                calculatorService.addToDatabase(request, response,"division");
            } catch (Exception ex) {
                log.error("error in getDivision :: addToDatabase :{}", ex);
                response.setAnswer(null);
                response.setDetail(ex.getMessage());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            log.info("getDivision() :: Request : number1 :{}, number2 :{} :: Response :{}", num1, num2, response);
            log.info("End getDivision()");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("square/{num}")
    public ResponseEntity<Response> getSquare(@PathVariable(name = "num") Integer num1) {
        log.info("Start getSquare()");
        Response response = new Response();
        try {
            Integer square = calculatorService.square(num1);
            String details = "square of " + num1 + "=" + square;
            response.setAnswer(square);
            response.setDetail(details);
        } catch (Exception ex) {
            log.error("error in getSquare() :{}", ex.getMessage());
            response.setDetail(ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } finally {
            try {
                String request = "num =" + num1 ;
                calculatorService.addToDatabase(request, response,"square");
            } catch (Exception ex) {
                log.error("error in getSquare :: addToDatabase :{}", ex);
                response.setAnswer(null);
                response.setDetail(ex.getMessage());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            log.info("getSquare() :: Request : num :{} :: Response :{}", num1, response);
            log.info("End getSquare()");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("squareroot/{num}")
    public ResponseEntity<Response> getSquareRoot(@PathVariable(name = "num") Integer num1) {
        log.info("Start getSquareRoot()");
        Response response = new Response();
        try {
            Integer squareRoot = calculatorService.squareRoot(num1);
            String details = "square root of" + num1 + "=" + squareRoot;
            response.setAnswer(squareRoot);
            response.setDetail(details);
        } catch (Exception ex) {
            log.error("error in getSquareRoot() :{}", ex.getMessage());
            response.setDetail(ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } finally {
            try {
                String request = "num =" + num1 ;
                calculatorService.addToDatabase(request, response,"squareRoot");
            } catch (Exception ex) {
                log.error("error in getSquareRoot :: addToDatabase :{}", ex.getMessage());
                response.setAnswer(null);
                response.setDetail(ex.getMessage());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            log.info("getSquareRoot() :: Request : num :{} :: Response :{}", num1, response);
            log.info("End getSquareRoot()");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("factorial/{num}")
    public ResponseEntity<Response> getFactorial(@PathVariable(name = "num") Integer num1) {
        log.info("Start getFactorial()");
        Response response = new Response();
        try {
            Integer factorial = calculatorService.factorial(num1);
            String details = "factorial of" + num1 + "!=" + factorial;
            response.setAnswer(factorial);
            response.setDetail(details);
        } catch (Exception ex) {
            log.error("error in getFactorial() :{}", ex.getMessage());
            response.setDetail(ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } finally {
            try {
                String request = "num =" + num1 ;
                calculatorService.addToDatabase(request, response,"factorial");
            } catch (Exception ex) {
                log.error("error in getFactorial :: addToDatabase :{}", ex.getMessage());
                response.setAnswer(null);
                response.setDetail(ex.getMessage());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            log.info("getFactorial() :: Request : num :{} :: Response :{}", num1, response);
            log.info("End getFactorial()");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("min-max")
    public ResponseEntity<Response> getMinMax(@RequestBody Request request) {
        log.info("Start getMinMax()");
        Response response = new Response();
        try {
            Map minMax = calculatorService.minMax(request.getNumbers());
            response.setMax((Integer) minMax.get("max"));
            response.setMin((Integer) minMax.get("min"));
        } catch (Exception ex) {
            log.error("error in getMinMax() :{}", ex.getMessage());
            response.setDetail(ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } finally {
            try {
                calculatorService.addToDatabase(request.toString(), response,"minMax");
            } catch (Exception ex) {
                log.error("error in getMinMax :: addToDatabase :{}", ex.getMessage());
                response.setAnswer(null);
                response.setDetail(ex.getMessage());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            log.info("getMinMax() :: Request :{} :: Response :{}", request, response);
            log.info("End getMinMax()");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
