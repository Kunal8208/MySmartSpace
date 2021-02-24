package com.app.service;

import java.util.ArrayList;
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
public class NewRequestServiceImpl implements INewRequestService {

	@Autowired
	INewRequestDao dao;
	
	@Autowired
	IQuotationDao quotationDao;	
	
	@Override
	public NewRequest addNewRequest(NewRequest newRequest) {
		return dao.save(newRequest);
	}

	@Override
	public List<NewRequest> getAllRequests() {
		return dao.findAll();
	}

	@Override
	public List<NewRequest> getRequestsByUserId(User userId) {
		return dao.findByUserId(userId);
	}

	@Override
	public Optional<NewRequest> getRequestById(int requestId) {
		return dao.findById(requestId);
	}

	@Override
	public List<NewRequest> getNewRequestsForServiceProvider(User serviceProvider) {
		
		List<NewRequest> newRequestsForParticularServiceProvider=new ArrayList<NewRequest>();
		
		List<NewRequest> allNewRequests=dao.findByIsValid(true);
		
		for (NewRequest newRequest : allNewRequests) {
			List<Quotation> allQuotationsForNewRequest=quotationDao.findByRequestId(newRequest);
			boolean isPresent=false;
			for (Quotation quotation : allQuotationsForNewRequest) {
				if(quotation.getServiceProviderId().equals(serviceProvider)) {
					isPresent=true;
					break;
				}
			}
			if(!isPresent) {
				newRequestsForParticularServiceProvider.add(newRequest);
			}
		}
		return newRequestsForParticularServiceProvider;
	}

	
	
	
}
