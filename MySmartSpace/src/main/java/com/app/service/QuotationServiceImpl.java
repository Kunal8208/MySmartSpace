package com.app.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.INewRequestDao;
import com.app.dao.IQuotationDao;
import com.app.pojos.NewRequest;
import com.app.pojos.Quotation;
import com.app.pojos.User;

@Service
@Transactional
public class QuotationServiceImpl implements IQuotationService {

	@Autowired
	IQuotationDao dao;
	
	@Autowired
	INewRequestDao reqDao;
	
	@Override
	public List<Quotation> getAllQuotationsByRequestId(NewRequest request) {
		return dao.findByRequestId(request);
	}

	@Override
	public Quotation insertQuotation(Quotation newQuotation) {
		return dao.save(newQuotation);
	}

	@Override
	public Quotation rejectQuotation(int quotationId) {
		Optional<Quotation> quotationDetails=dao.findById(quotationId);
		if(quotationDetails.isPresent()) {
			Quotation quotation = quotationDetails.get();
			quotation.setAcceptanceStatus(2);
			dao.save(quotation);
			
			//get all requests for corresponding quotation
			NewRequest request=quotation.getRequestId();
			List<Quotation> list=dao.findByRequestId(request);

			for (Quotation quot : list) {
				//if any of the quotations is still new, then dont update the request status
				if(quot.getAcceptanceStatus()!=2) {
					return quotation;
				}
			}
			
			//all quotations are rejected. So, set request as invalid
			request.setIsValid(false);
			return quotation;
		}
		return null;
	}

	@Override
	public Quotation AcceptQuotation(int quotationId) {
		Optional<Quotation> quotationDetails=dao.findById(quotationId);
		if(quotationDetails.isPresent()) {
			Quotation quotation = quotationDetails.get();
			quotation.setAcceptanceStatus(1);
			NewRequest request=quotation.getRequestId();
			request.setIsValid(false);
			reqDao.save(request);
			dao.save(quotation);
			
			//make all other quotations for this request as REJECTED
			List<Quotation> list=dao.findByRequestId(request);
			for (Quotation quot : list) {
				if(quot.getQuotationId() != quotationId) {
					quot.setAcceptanceStatus(2);
					dao.save(quot);
				}
			}
			return quotation;
		}
		return null;
	}

	@Override
	public List<Quotation> getAllQuotationsByServiceProviderId(User serviceProvider) {
		return dao.findByServiceProviderId(serviceProvider);
	}

}
