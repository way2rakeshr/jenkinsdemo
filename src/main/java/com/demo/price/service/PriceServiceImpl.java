package com.demo.price.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.price.entity.Price;
import com.demo.price.exception.ProductPrice;
import com.demo.price.repository.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService {
	@Autowired
	PriceRepository priceRepository;

	@Override
	public Price findprice(int pid)   {
			Optional<Price> findById = priceRepository.findById(pid);
		if(findById.isPresent())
		 return findById.get();
		else {
			throw new ProductPrice("price list not found");
		}
	}

}
