package io.learningspring.postgre;

import io.learningspring.postgre.entities.Product;
import io.learningspring.postgre.services.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class PostgreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PostgreApplication.class, args);
		ProductService service = context.getBean(ProductService.class);
		List<Product> products = service.getProducts();
		for (Product product : products) {
			System.out.println(product);
		}
	}

}
