package com.demo.price.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.price.entity.Price;
import com.demo.price.service.PriceService;

@RestController
@RequestMapping("/price")
public class PriceController {
	
	@Autowired
	PriceService priceService;

	@GetMapping("/{pid}")
	public ResponseEntity<Price> findprice(@PathVariable int pid)  {
		

		return new ResponseEntity<>(priceService.findprice(pid), HttpStatus.OK);
	}

}
