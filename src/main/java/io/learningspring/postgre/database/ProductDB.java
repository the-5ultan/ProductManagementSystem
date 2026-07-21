package org.example.database;

import org.example.entities.Product;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {
    Connection  connection = null;

    public ProductDB() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/springmvc","postgres","sultan@msb123");
                    System.out.println("Connected to database successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void saveProduct(Product p) {
        String query = "insert into product(name, type, place, warranty) values (?,?,?,?);";
        try {
            PreparedStatement prepared = connection.prepareStatement(query);
            prepared.setString(1, p.getName());
            prepared.setString(2, p.getType());
            prepared.setString(3, p.getPlace());
            prepared.setInt(4, p.getWarranty());
            prepared.execute();
            System.out.println("Inserted product successfully");
        } catch (SQLException e) {
            System.out.println("Error while inserting product " + p.getName());
            throw new RuntimeException(e);
        }
    }

    public List<Product> getProducts(){
        String query = "select name, type, place, warranty from product;";
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement prepared = connection.prepareStatement(query);
            ResultSet rs = prepared.executeQuery();
            while(rs.next()){
                Product p = new Product();
                p.setName(rs.getString("name"));
                p.setType(rs.getString("type"));
                p.setPlace(rs.getString("place"));
                p.setWarranty(rs.getInt("warranty"));
                products.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error while getting the products \n"+e.getMessage());
            throw new RuntimeException(e);
        }

        return products;
    }

}
