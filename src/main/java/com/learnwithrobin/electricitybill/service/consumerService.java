package com.learnwithrobin.electricitybill.service;

import com.learnwithrobin.electricitybill.model.Consumer;
import com.learnwithrobin.electricitybill.model.ConsumerPojo;

public interface consumerService {
	
	Consumer save(Consumer consumer);
	
	Consumer findConsumerById(long consumerId) throws Exception;
	
	
	
	long unitOfConsumption(long consumerId) throws Exception;
	
	long bill(long units);

	Consumer updateNewReading(long consumerId,ConsumerPojo consumer) throws Exception;
}
