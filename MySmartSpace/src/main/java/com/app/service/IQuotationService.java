package com.app.service;

import java.util.List;

import com.app.pojos.NewRequest;
import com.app.pojos.Quotation;
import com.app.pojos.User;

public interface IQuotationService {
	public List<Quotation> getAllQuotationsByRequestId(NewRequest request);
	public Quotation insertQuotation(Quotation newQuotation);
	public Quotation rejectQuotation(int quotationId);
	public Quotation AcceptQuotation(int quotationId);
	public List<Quotation> getAllQuotationsByServiceProviderId(User serviceProvider);
}
