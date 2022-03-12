# Spring Boot + Spring data JPA

### pom.xml
Puts spring-boot-starter-data-jpa (Spring data, Hibernate, HikariCP and all databases related dependencies).

```
<!-- jpa, crud repository -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- in-memory database  -->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
</dependency>
```

### HikariCP Connection Pool
Use spring.datasource.hikari.* to override the default settings.

```
spring.datasource.hikari.connectionTimeout=20000
spring.datasource.hikari.maximumPoolSize=5
spring.datasource.hikari.poolName=HikariPoolZZZ
```

**Note:** [Reference](https://confluence.atlassian.com/bamkb/hikaricp-properties-1087518069.html)

HikariCP is solid high-performance JDBC connection pool. A connection pool is a cache of database connections maintained so that the connections can be reused when future requests to the database are required. Connection pools may significantly reduce the overall resource usage. - [You can find out more here](https://zetcode.com/articles/hikaricp/#:~:text=HikariCP%20is%20solid%20high%2Dperformance,reduce%20the%20overall%20resource%20usage.). 


### Unit Test
@DataJpaTest and TestEntityManager to test a Spring data JPA repository.

```

```