package com.capgemini.sprint1.Sprint1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capgemini.sprint1.Sprint1.exceptions.ProductNotFoundException;
import com.capgemini.sprint1.Sprint1.services.ProductService;

@DisplayName("Product Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class ProductServiceTest {

	@Autowired
	ProductService productService;

	@Test
	@DisplayName("get assigned engineers")
	public void getEngineersTest() throws ProductNotFoundException {
		productService.getEngineersByProductId(21);

	}

	@Test
	@DisplayName("get Product complaints")
	public void getProductComplaintsTest() throws ProductNotFoundException {
		productService.getProductComplaints(21);

	}

	@Test
	@DisplayName("get all Product")
	public void getProductsTest() {
		productService.getProducts();

	}

	
	@Test
	@DisplayName("Remove Product")
	public void removeProductTest() throws ProductNotFoundException {
		productService.removeProduct(28);
	}
	
	
	@Test
	@DisplayName("Invalid get assigned engineers")
	public void InvalidGetEngineersTest() {
		Assertions.assertThrows(ProductNotFoundException.class, () -> {
			productService.getEngineersByProductId(100000);
		});
	}

	@Test
	@DisplayName("Invalid get Product complaints")
	public void InvalidGetProductComplaintsTest() {
		Assertions.assertThrows(ProductNotFoundException.class, () -> {
			productService.getProductComplaints(100000);
		});
	}

	@Test
	@DisplayName("Invalid Test Invalid model number while remove product")
	public void invalidRemoveTest() {

		Assertions.assertThrows(ProductNotFoundException.class, () -> {
			productService.removeProduct(100000);
		});

	}

}
