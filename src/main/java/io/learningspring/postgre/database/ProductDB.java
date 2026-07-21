package io.learningspring.postgre.database;

import io.learningspring.postgre.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductDB extends JpaRepository<Product, Integer> {

}
