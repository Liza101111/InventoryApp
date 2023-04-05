package com.springboot.inventoryapp;

import com.springboot.inventoryapp.entity.CartItem;
import com.springboot.inventoryapp.entity.Product;
import com.springboot.inventoryapp.entity.User;
import com.springboot.inventoryapp.repository.CartItemRepository;
import com.springboot.inventoryapp.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class shoppingCartTests {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testAddItem(){
        Product product= entityManager.find(Product.class, 4);
        User user = entityManager.find(User.class, 6);

        CartItem cartItem = new CartItem(1, product, user);
        cartItemRepository.save(cartItem);
    }

    @Test
    public void testAddItemByIds(){
        Product product = new Product(5);
        User user = new User(7);
        CartItem cartItem = new CartItem(2, product, user);
        cartItemRepository.save(cartItem);
    }

}
