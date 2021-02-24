package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.NewRequest;
import com.app.pojos.User;

public interface INewRequestService {
	NewRequest addNewRequest(NewRequest newRequest);
	List<NewRequest> getAllRequests();
	List<NewRequest> getRequestsByUserId(User userId);
	Optional<NewRequest> getRequestById(int requestId);
	List<NewRequest> getNewRequestsForServiceProvider(User serviceProvider);
}
