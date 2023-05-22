package com.coding.exercise.bankapp.repository;

import com.coding.exercise.bankapp.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,String>{

    }
