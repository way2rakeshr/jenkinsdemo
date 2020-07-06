package com.demo.price.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.demo.price.entity.Price;
import com.demo.price.service.PriceService;
@SpringBootTest
public class PriceControllerTest {

	
	@Mock
	PriceService priceService;
	@InjectMocks
	PriceController priceController;
	Price price=new Price();
	
	@BeforeEach
	public void init() {
		price.setId(1);
		price.setPriceValue((double) 100);
	}
	@Test
	public void testFindprice() {
		
		Mockito.when(priceService.findprice(1)).thenReturn(price);
		ResponseEntity<Price> findprice = priceController.findprice(1);
		assertEquals(findprice.getBody(), price);
		
		
	}
	
}
