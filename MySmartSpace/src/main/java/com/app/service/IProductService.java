
package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Product;
import com.app.pojos.ProductCategory;
import com.app.pojos.User;

public interface IProductService { 
	
	// list all products 
	List<Product> getAllProducts();
	
	//get Product by Id
	Optional<Product> getProductById(int productId);
  
  // get product details by Category 
	List<Product> getProductByCategory(ProductCategory productCategory);
  
  // add new product details 
  Product addProductDetails(Product transientPOJO);
  
  //Get product Specifications
  //Specification getProductSpecifications(int productId);
  
  // update existing product details 
 // Product updateProductDetails(int productId, Product detachedPOJO); 
  
  // delete existing product 
  String deleteProduct(int productId);
  
  List<String> getAllCategories();
  
  List<Product> getProductsByServiceId(User serviceProvider);
  
  }
