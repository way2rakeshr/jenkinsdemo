package com.demo.price.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.price.entity.Price;
import com.demo.price.exception.ProductPrice;
import com.demo.price.repository.PriceRepository;
@SpringBootTest
public class PriceServiceImplTest {
	@Mock
	PriceRepository priceRepository;
	@InjectMocks
	PriceServiceImpl priceServiceImpl;

	Price price = new Price();
	
	@BeforeEach
	public void init() {
	
	}

	@Test
	public void findpriceTest() {
		price.setId(1);
		price.setPriceValue((double) 100);
		Mockito.when(priceRepository.findById(1)).thenReturn(Optional.of(price));
		Price findprice = priceServiceImpl.findprice(1);
		assertEquals(1,findprice.getId());

	}
	@Test
	public void findPriceNegative() {
		try {
		Mockito.when(priceRepository.findById(2)).thenReturn(Optional.of(price));
		Price findprice = priceServiceImpl.findprice(1);
		}catch(ProductPrice pe) {
			 assertEquals("price list not found", pe.getMessage());
		}
	}
}
