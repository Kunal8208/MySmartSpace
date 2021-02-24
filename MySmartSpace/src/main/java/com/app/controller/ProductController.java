package com.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Product;
import com.app.pojos.ProductCategory;
import com.app.pojos.User;
import com.app.service.IProductService;
import com.app.service.IUserService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private IProductService service;
	
	@Autowired
	private IUserService userService;

	public ProductController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// RESTful end point or API end point or API provider
	@GetMapping
	public ResponseEntity<?> listAllProducts() {
		System.out.println("in list all products");
		// invoke service layer's method : controller --> service impl (p) --->JPA
		// repo's impl class(SC)
		List<Product> products = service.getAllProducts();
		if (products.isEmpty())
			// empty product list : set sts code : HTTP 204 (no contents)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// in case of non empty list : OK, send the list
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
/*
	// get prduct details by its name : supplied by clnt using path var
	@GetMapping("/{productName}")
	public ResponseEntity<?> getProductDetails(@PathVariable String productName) {
		System.out.println("in get prod details " + productName);
		// invoke service method
		Optional<Product> productDetails = service.getProductDetails(productName);
		// valid name : HTTP 200 , marshalled product details
		if (productDetails.isPresent())
			return new ResponseEntity<>(productDetails.get(), HttpStatus.OK);
		// in case of invalid name : HTTP 404
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
*/
	
	@GetMapping("/{productId}")
	public ResponseEntity<?> getProductDetails(@PathVariable int productId){
		System.out.println("Product ID: "+productId);
		Optional<Product> productDetails=service.getProductById(productId);
		if(productDetails.isPresent())
			return new ResponseEntity<>(productDetails.get(), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/category/{productCategory}")
	public ResponseEntity<?> getProductsByCategory(@PathVariable ProductCategory productCategory){
		List<Product> productDetails=service.getProductByCategory(productCategory);

		return new ResponseEntity<>(productDetails, HttpStatus.OK);
	}
	
	// req handling method to create a new product : post
	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody Product p) {
		System.out.println("in add product " + p);
		try {
			Product savedProduct = service.addProductDetails(p);
			return new ResponseEntity<>(savedProduct, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	// req handling method to update existing product
	@PutMapping("/{productId}")
	public ResponseEntity<?> updateProductDetails(@PathVariable int productId, @RequestBody Product p) {
		System.out.println("in update " + productId + " " + p);
		try {
			Product updatedDetails = service.updateProductDetails(productId, p);
			return new ResponseEntity<>(updatedDetails, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
*/
	
	// req handling method to delete existing product
	@DeleteMapping("/{pid}")
	public String deleteProduct(@PathVariable int pid) {
		System.out.println("in del product " + pid);
		System.out.println("ID received: "+pid);
		return service.deleteProduct(pid);
	}
	
	@GetMapping("/category")
	public ResponseEntity<?> getAllProductCategories(){
		List<String> list=new ArrayList<String>();
		list=service.getAllCategories();
		System.out.println(list);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/serviceprovider/{serviceProviderId}")
	public ResponseEntity<?> getProductsByServiceProviderId(@PathVariable int serviceProviderId){
		User serviceProvider=userService.getUserById(serviceProviderId).get();
		List<Product> list=service.getProductsByServiceId(serviceProvider);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
}
