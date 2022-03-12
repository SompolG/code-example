package com.demo.yaml.config;


import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.demo.yaml.config.model.Page;
import com.demo.yaml.config.model.Server;

import lombok.Data;

@Component
@ConfigurationProperties("website")
@Data
public class WebSiteProperties {
	private List<Page> pages = new ArrayList<>();
    private List<Server> servers = new ArrayList<>();

}
