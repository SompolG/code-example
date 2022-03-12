package com.demo.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.jpa.model.User;
import com.demo.jpa.model.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
    private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	public void run(String... args) {
		log.info("StartApplication...");

		repository.save(new User("Alex", 23));
		repository.save(new User("Mike", 35));
		repository.save(new User("John", 26));
		repository.save(new User("Marc", 26));

		System.out.println("\nfindAll()");
		repository.findAll().forEach(x -> System.out.println(x));

		System.out.println("\nfindById(1L)");
		repository.findById(1l).ifPresent(x -> System.out.println(x));

		System.out.println("\nfindByName('Mike')");
		repository.findByName("Mike").forEach(x -> System.out.println(x));
		
		System.out.println("\nfindByAge(26)");
		repository.findByAge(26).forEach(x -> System.out.println(x));
		
		System.out.println("\nfindByNameAndAge('Marc', 28)");
		repository.findByNameAndAge("Marc", 28).forEach(x -> System.out.println(x));

		
		System.out.println("\nsave(2L) // Update");
		repository.findById(2l).ifPresent(x -> {
			x.setAge(18);
			repository.save(x);	
			System.out.println("it's done.");
		});
		
		System.out.println("\nfindById(2L)");
		repository.findById(2l).ifPresent(x -> System.out.println(x));

		
		System.out.println("\ndeleteById(3L)");
		repository.deleteById(3L);
		System.out.println("it's done.");
		
		System.out.println("\nfindAll()");
		repository.findAll().forEach(x -> System.out.println(x));

	}

}
