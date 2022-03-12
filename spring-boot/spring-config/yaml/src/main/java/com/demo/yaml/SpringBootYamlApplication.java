package com.demo.yaml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.yaml.config.GlobalProperties;
import com.demo.yaml.config.WebSiteProperties;

@SpringBootApplication
public class SpringBootYamlApplication implements CommandLineRunner {
	@Autowired
	private WebSiteProperties webProperties;

	@Autowired
	private GlobalProperties globalProperties;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootYamlApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println(globalProperties);
		System.out.println(webProperties);
	}
}
