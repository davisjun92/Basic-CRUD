package com.projectalpha.quickstart;

import com.projectalpha.quickstart.Repository.ProductRepository;
import com.projectalpha.quickstart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuickstartApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(QuickstartApplication.class, args);
	}

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		Product product1 = new Product("code1", "category1", "brand1", "type1", "description1", "name1");
		productRepository.save(product1);

		Product product2 = new Product("code2", "category2", "brand2", "type2", "description2", "name2");
		productRepository.save(product2);

		Product product3 = new Product("code3", "category3", "brand3", "type3", "description3", "name3");
		productRepository.save(product3);

		Product product4 = new Product("code4", "category4", "brand4", "type4", "description4", "name4");
		productRepository.save(product4);

		Product product5 = new Product("code5", "category5", "brand5", "type5", "description5", "name5");
		productRepository.save(product5);

		Product product6 = new Product("code6", "category6", "brand6", "type6", "description6", "name6");
		productRepository.save(product6);

		Product product7 = new Product("code7", "category7", "brand7", "type7", "description7", "name7");
		productRepository.save(product7);

		Product product8 = new Product("code8", "category8", "brand8", "type8", "description8", "name8");
		productRepository.save(product8);

		Product product9 = new Product("code9", "category9", "brand9", "type9", "description9", "name9");
		productRepository.save(product9);

		Product product10 = new Product("code10", "category10", "brand10", "type10", "description10", "name10");
		productRepository.save(product10);

		Product product11 = new Product("code11", "category11", "brand11", "type11", "description11", "name11");
		productRepository.save(product11);

		Product product12 = new Product("code12", "category12", "brand12", "type12", "description12", "name12");
		productRepository.save(product12);
	}
}
