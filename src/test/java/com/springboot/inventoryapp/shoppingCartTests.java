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

import java.util.List;

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

    @Test
    public void testAddMultipleItems(){
        User user = new User(1);
        Product product1 = new Product(4);
        Product product2 = new Product(5);
        Product product3 = new Product(6);

        CartItem cartItem1 = new CartItem(5, product1, user);
        CartItem cartItem2 = new CartItem(3, product2, user);
        CartItem cartItem3 = new CartItem(8, product3, user);

        cartItemRepository.saveAll(List.of(cartItem1, cartItem2, cartItem3));
    }

    @Test
    public void testListItems(){
        List<CartItem> cartItemList = cartItemRepository.findAll();
        cartItemList.forEach(System.out::println);
    }



}
