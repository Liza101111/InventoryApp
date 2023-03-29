package com.springboot.inventoryapp;

import com.springboot.inventoryapp.entity.Category;
import com.springboot.inventoryapp.repository.CategoryRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class CategoryRepositoryTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testCreateCategory() {
        Category savedCategory = categoryRepository.save(new Category("Electronics"));

        Assertions.assertThat(savedCategory.getId()).isGreaterThan(0);
    }


}
