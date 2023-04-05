package com.springboot.inventoryapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128, nullable = false, unique = true)
    private String name;

    private float price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductDetails> details = new ArrayList<>();

    public Product(Integer id){
        this.id = id;
    }

    public void addDetail(String name, String value){
        this.details.add(new ProductDetails(name, value, this));
    }

    public void setDetail(Integer id, String name, String value){
        this.details.add(new ProductDetails(id,name,value,this));
    }

    @Override
    public String toString() {
        return name ;
    }
}
