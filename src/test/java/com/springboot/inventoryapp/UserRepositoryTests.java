package com.springboot.inventoryapp;

import com.springboot.inventoryapp.entity.Role;
import com.springboot.inventoryapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateRoles(){
        Role role1 = new Role("Administrator");
        Role role2 = new Role("Editor");
        Role role3 = new Role("Visitor");

        entityManager.persist(role1);
        entityManager.persist(role2);
        entityManager.persist(role3);

    }
}
