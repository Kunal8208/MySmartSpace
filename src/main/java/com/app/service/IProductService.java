
package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Product;

public interface IProductService { 
	
	// list all products 
	List<Product> getAllProducts();
	
	//get Product by Id
	Optional<Product> getProductById(int productId);
  
  // get product details by name 
 // Optional<Product> getProductDetails(String pName);
  
  // add new product details 
  Product addProductDetails(Product transientPOJO);
  
  //Get product Specifications
  //Specification getProductSpecifications(int productId);
  
  // update existing product details 
 // Product updateProductDetails(int productId, Product detachedPOJO); 
  
  // delete existing product 
  String deleteProduct(int productId);
  
  }
