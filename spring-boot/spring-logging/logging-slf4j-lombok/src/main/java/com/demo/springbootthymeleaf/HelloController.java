package com.demo.springbootthymeleaf;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HelloController {

    @GetMapping("/")
    public String hello(Model model) {

    	List<String> data = Arrays.asList("cat", "dog", "lion", "tiger");

        log.debug("Hi from Logback {}", data);

        model.addAttribute("num", data);

        return "index"; // index.html
    }

}