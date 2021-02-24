package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.NewRequest;
import com.app.pojos.Quotation;
import com.app.pojos.User;

public interface IQuotationDao extends JpaRepository<Quotation, Integer> {
	public List<Quotation> findByRequestId(NewRequest request);
	public List<Quotation> findByAcceptanceStatusAndServiceProviderId(int status, User serviceProvider);
	public List<Quotation> findByServiceProviderId(User serviceProvider);
}
