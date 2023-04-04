package com.springboot.inventoryapp;

import com.springboot.inventoryapp.entity.Role;
import com.springboot.inventoryapp.entity.User;
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

    @Test
    public void testCreateNewUserWithOneRole(){
        Role role1 = entityManager.find(Role.class, 1);
        User user = new User("liza@gmail.com", "123456");
        user.addRole(role1);

        userRepository.save(user);
    }

    @Test
    public void testCreateNewUserWithTwoRoles(){
        Role role2 = entityManager.find(Role.class, 2);
        Role role3 = entityManager.find(Role.class, 3);
        User user = new User("janno@gmail.com", "67890");
        user.addRole(role2);
        user.addRole(role3);

        userRepository.save(user);
    }

    @Test
    public void testAssignRoleToExistingUser(){
        User user = userRepository.findById(1).get();
        Role role = entityManager.find(Role.class, 2);
        user.addRole(role);
    }

    @Test
    public void testRemoveRoleFromExistingUser(){
        User user = userRepository.findById(1).get();
        Role role = new Role(2);
        user.removeRole(role);

    }

}
