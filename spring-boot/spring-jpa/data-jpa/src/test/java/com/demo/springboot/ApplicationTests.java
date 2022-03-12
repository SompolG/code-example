package com.demo.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.jpa.model.User;
import com.demo.jpa.model.UserRepository;

@SpringBootTest
//@RunWith(SpringRunner.class)
//@ExtendWith(SpringExtension.class)
@DataJpaTest
class ApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository repository;

	@Test
	public void testFindByName() {

		entityManager.persist(new User("Marc", 26));

		List<User> users = repository.findByName("Marc");
		assertEquals(1, users.size());

		assertEquals("Marc", users.get(0).getName());

	}
}
