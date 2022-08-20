package br.com.ijuda.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping
    @ResponseBody
    public String HelloWorld() {
        return "Hello World";
    }

}
