# Spring Boot SLF4j Logback

### LOG Files
Replace the **application.properties** file with the one from **src/main/resources/bak**.
* application.properties
* application.yml
* logbak.xml
* logbak-spring.xml


### application.properties
Configure the logging in application.properties

```
logging.level.org.springframework=ERROR
logging.level.com.demo=DEBUG
logging.file.name=logs/app-properties.log

logging.pattern.console=%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n
logging.pattern.file=%d %p %c{1.} [%t] %m%n
```

### application.yml
Compare to YML format

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

### logback.xml
we need more logging features like file rolling or SMTP In Spring Boot, we still allow to configure logback via the standard logback.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<configuration>

    <property name="HOME_LOG" value="logs/app-logback.log"/>

    <appender name="FILE-ROLLING" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${HOME_LOG}</file>

        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <fileNamePattern>logs/archived/app.%d{yyyy-MM-dd}.%i.log</fileNamePattern>
            <!-- each archived file, size max 10MB -->
            <maxFileSize>10MB</maxFileSize>
            <!-- total size of all archive files, if total size > 20GB, 
        it will delete old archived file -->
            <totalSizeCap>20GB</totalSizeCap>
            <!-- 60 days to keep -->
            <maxHistory>60</maxHistory>
        </rollingPolicy>

        <encoder>
            <pattern>%d %p %c{1.} [%t] %m%n</pattern>
        </encoder>
    </appender>

    <logger name="com.demo" level="debug" additivity="false">
        <appender-ref ref="FILE-ROLLING"/>
    </logger>

    <root level="error">
        <appender-ref ref="FILE-ROLLING"/>
    </root>

</configuration>
```

### logback-spring.xml
Spring Boot logging by Profile, we can create a logback-spring.xml in the root of the classpath.

```
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <include resource="org/springframework/boot/logging/logback/defaults.xml" />

    <springProfile name="default">
        <include resource="org/springframework/boot/logging/logback/console-appender.xml"/>

        <root level="INFO">
            <appender-ref ref="CONSOLE"/>
        </root>
    </springProfile>

    <springProfile name="prod">

        <appender name="FILE-ROLLING" class="ch.qos.logback.core.rolling.RollingFileAppender">
            <file>app-logback-spring.log</file>

            <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
                <fileNamePattern>logs/archived/app.%d{yyyy-MM-dd}.%i.log</fileNamePattern>
                <!-- each archived file, size max 10MB -->
                <maxFileSize>10MB</maxFileSize>
                <!-- total size of all archive files, if total size > 20GB, it will delete old archived file -->
                <totalSizeCap>20GB</totalSizeCap>
                <!-- 60 days to keep -->
                <maxHistory>60</maxHistory>
            </rollingPolicy>

            <encoder>
                <pattern>%d %p %c{1.} [%t] %m%n</pattern>
            </encoder>
        </appender>

        <logger name="org.springframework" level="INFO"/>
        <logger name="com.demo" level="DEBUG"/>
        <root level="ERROR">
            <appender-ref ref="FILE-ROLLING"/>
        </root>
    </springProfile>

</configuration>
```

**application.properties**

Define a spring.profiles.active property to set the current active profile.

```
spring.profiles.active=prod
```


### Hello Logback
A simple Spring MVC web application, logs something.

```
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String hello(Model model) {

        List<String> data = Arrays.asList("cat", "dog", "lion", "tiger");

        logger.debug("Hello from Logback {}", data);

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



