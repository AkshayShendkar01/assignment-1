package com.bnt.controller;

import com.bnt.service.HelloService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WelcomeController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class WelcomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloService helloService;



    @Test
    void helloWorld() throws Exception {
        String response ="{ Hello World!! }";
        mockMvc.perform(get("/greetapi/v1/hello")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(response));
    }

    @Test
    void sayHello() throws Exception {

        String response ="{ Hello Akshay!! }";
        when(helloService.getHelloMessage(any())).thenReturn(response);
        mockMvc.perform(get("/greetapi/v1/hello")
                        .param("name","Akshay")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(response));
    }

    @Test
    void sayHelloBlankTest() throws Exception {

        String response ="{ Please enter valid name. Name should not be null or empty. }";
        mockMvc.perform(get("/greetapi/v1/hello")
                        .param("name","")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(response));
    }
}