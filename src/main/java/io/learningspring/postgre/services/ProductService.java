package io.learningspring.postgre.services;

import io.learningspring.postgre.database.ProductDB;
//import io.learningspring.postgre.database.ProductDB_JDBC;
import io.learningspring.postgre.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
public class ProductService {

    @Autowired
    ProductDB db;
    //List<Product> products = db.findAll();

    public List<Product> getProducts() {
        return db.findAll();
    }

    public void addProduct(Product product){
        db.save(product);
    }

    public void removeProduct(Product product){
        db.delete(product);
    }

    public List<Product> expiredWarranty(){
        List<Product> expiredWarranty = new ArrayList<>();
        int currYear = Calendar.getInstance().get(Calendar.YEAR);
        List<Product> products = db.findAll();
        //List<Product> products = db.getProducts();
        for(Product product: products){
            if(product.getWarranty() < currYear){
                expiredWarranty.add(product);
            }
        }
        return expiredWarranty;
    }


    public List<Product> searchTheText(String searchText){
        List<Product> products = db.findAll();
        List<Product> lp = new ArrayList<>();
        for(Product p: products){
            if(p.getName().toLowerCase().contains(searchText.toLowerCase()) || p.getType().toLowerCase().contains(searchText.toLowerCase()) || p.getPlace().toLowerCase().contains(searchText.toLowerCase())){
                lp.add(p);
            }
        }
        return lp;
    }
}
