package com.bnt.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class HelloServiceImplTest {

    @InjectMocks
    private HelloServiceImpl helloService;

    @Test
    void getHelloMessage() {
        assertEquals("Hello Akshay!!",helloService.getHelloMessage("Akshay"));
    }
}