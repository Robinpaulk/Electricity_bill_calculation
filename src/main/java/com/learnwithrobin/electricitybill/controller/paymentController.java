package com.learnwithrobin.electricitybill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnwithrobin.electricitybill.model.Consumer;
import com.learnwithrobin.electricitybill.model.ConsumerPojo;
import com.learnwithrobin.electricitybill.repository.ConsumerRepository;
import com.learnwithrobin.electricitybill.service.consumerService;

@RestController
@RequestMapping("/api")
public class paymentController {
	
	@Autowired
	private consumerService consumerService;
	
	private ConsumerPojo consumerPojo;
	
	private ConsumerRepository repo;
	
	//save a consumer
	@PostMapping("/add")
	public Consumer save(@RequestBody Consumer consumer) {
		System.out.println(consumer.getCity());
		return consumerService.save(consumer);
	}
	
	@PutMapping("/new/{id}")
	public Consumer updateReading(@PathVariable("id") long consumerId,@RequestBody ConsumerPojo consumer) throws Exception {
		System.out.println(consumer.getName());
		return consumerService.updateNewReading(consumerId,consumer);
	}
	
	//Api for find units of a particular consumer
	@GetMapping("/unitsOfConsumption/{id}")
	public Long unitsOfConsumption(@PathVariable("id") long consumerId) throws Exception {
		return consumerService.unitOfConsumption(consumerId);
	}
	//Calculate Total amount to pay
	@GetMapping("/bill/{id}")
	public Long totalBill(@PathVariable("id") long consumerId) throws Exception {
		long units = consumerService.unitOfConsumption(consumerId);
		System.out.println(units);
		return consumerService.bill(units);
		
	}
	
	
}
