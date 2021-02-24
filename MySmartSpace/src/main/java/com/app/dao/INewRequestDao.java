package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.NewRequest;
import com.app.pojos.Product;
import com.app.pojos.ProductCategory;
import com.app.pojos.User;

public interface INewRequestDao extends JpaRepository<NewRequest, Integer> {
	public List<NewRequest> findByUserId(User userId);
	public NewRequest findByRequestId(int requestId);
	public List<NewRequest> findByIsValid(boolean flag);
}
