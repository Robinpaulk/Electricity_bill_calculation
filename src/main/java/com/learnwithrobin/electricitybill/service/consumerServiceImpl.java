package com.learnwithrobin.electricitybill.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnwithrobin.electricitybill.model.Consumer;
import com.learnwithrobin.electricitybill.model.ConsumerPojo;
import com.learnwithrobin.electricitybill.repository.ConsumerRepository;

@Service
public class consumerServiceImpl implements consumerService{

	@Autowired
	private ConsumerRepository consumerRepo;
	
	@Override
	public Consumer save(Consumer consumer) {
		return consumerRepo.save(consumer);
	}

	
	@Override
	public long unitOfConsumption(long consumerId) throws Exception {
		Optional<Consumer> currentConsumer = consumerRepo.findById(consumerId);
		if(!currentConsumer.isPresent()) {
			 throw new Exception("No consumer found");
		}
		Consumer consumer = currentConsumer.get();
		long currentReading = consumer.getCurrentReading();
		long previousRseading = consumer.getPreviousReading();
		long units = currentReading - previousRseading;
		return units;
	}
	
	public long unitOfConsumption(long currentReading, long previousReading) {
		long units = currentReading - previousReading;
		return units;
	}

	@Override
	public long bill(long units) {
		/*
		 * 0 to 100 unit = 10
		 * 100 to 200 = 15
		 * 200- 300 = 20
		 * 300 > = 25
		 * 
		 */
		
		 if (units <= 100) { 
	            return units * 10; 
	        } 
	        else if (units <= 200) { 
	            return (100 * 10) 
	                + (units - 100) 
	                      * 15; 
	        } 
	        else if (units <= 300) { 
	            return (100 * 10) 
	                + (100 * 15) 
	                + (units - 200) 
	                      * 20; 
	        } 
	        else if (units > 300) { 
	            return (100 * 10) 
	                + (100 * 15) 
	                + (100 * 20) 
	                + (units - 300) 
	                      * 25; 
	        } 
	        return 0;  

	}

	@Override
	public Consumer updateNewReading(long consumerId,ConsumerPojo consumer) throws Exception {
		
		Optional<Consumer> existedRecord = consumerRepo.findById(consumerId);
		if(!existedRecord.isPresent()) {
			throw new Exception("No Consumer found");
		}
		
		Consumer oldReading = existedRecord.get();
		Consumer updatedReading = new Consumer();
		updatedReading.setConsumerId(consumerId);
		updatedReading.setName(consumer.getName());
		updatedReading.setCity(consumer.getCity());
		updatedReading.setState(consumer.getState());
		/*
		 * here we are swapping (existed currentReading will move as previousReading 
		 * And newly added reading will be the currentReading
		 */
		updatedReading.setCurrentReading(consumer.getCurrentReading());
		updatedReading.setPreviousReading(oldReading.getCurrentReading());
		return consumerRepo.save(updatedReading);
		
	
	}


	@Override
	public Consumer findConsumerById(long consumerId) throws Exception {
		Optional<Consumer> consumer = consumerRepo.findById(consumerId);
		if(!consumer.isPresent()) {
			throw new Exception();
		}
		Consumer consumer2 = consumer.get();
		return consumer2;
	}

}
