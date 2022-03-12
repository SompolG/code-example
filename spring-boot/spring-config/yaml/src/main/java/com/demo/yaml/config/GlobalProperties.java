package com.demo.yaml.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties // no prefix, root level.
@Data
public class GlobalProperties {
	private String port;
	private String email;
    private int threadPool;
 
}
