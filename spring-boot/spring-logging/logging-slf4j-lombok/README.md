# Spring Boot SLF4j Lombok

### Dependency
Add lombok in pom.xml

```
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
</dependency>
```

### application.yml
Configure the logging in application.yml

```
logging:
  pattern:
    console: "%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"
    file: "%d %p %c{1.} [%t] %m%n"
  level:
    org.springframework: ERROR
    com.demo: DEBUG
  file: 
    name: logs/app-yaml.log
```

### Hello Logback
A simple Spring MVC web application, logs something.

```
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
```

### Demo
Start Spring Boot

```
http://localhost:8080
```



