package com.demo.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {

//    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String hello(Model model) {

        List<String> data = Arrays.asList("cat", "dog", "lion", "tiger");

        logger.debug("Hello from Logback {}", data);

        model.addAttribute("num", data);

        return "index"; // index.html
    }

}