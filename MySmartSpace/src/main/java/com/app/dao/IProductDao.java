
package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Product;
import com.app.pojos.ProductCategory;
import com.app.pojos.User;

public interface IProductDao extends JpaRepository<Product, Integer> {

	public List<Product> findByCategory(ProductCategory ProductCategory);
	public List<Product> findByServiceProviderId(User serviceProvider);
}


