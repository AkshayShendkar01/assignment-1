package com.bnt.controller;

import com.bnt.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("greetapi/v1/")
public class WelcomeController {

    @Autowired
    private HelloService helloService;

    @GetMapping("hello")
    public ResponseEntity<String> helloWorld() {
        String message = "{ Hello World!! }";
            return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping(path = "hello",params = "name")
    public ResponseEntity<String> sayHello(@RequestParam String name) {
        String message = "{ Please enter valid name. Name should not be null or empty. }";
        if (null != name && !name.trim().equals("")) {
            message = helloService.getHelloMessage(name);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }
}
