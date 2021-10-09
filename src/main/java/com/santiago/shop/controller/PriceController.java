package com.santiago.shop.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.santiago.shop.dto.PriceDTO;

public interface PriceController {
	
	List<PriceDTO> getPrices();
	List<PriceDTO> getPriceBydDate(Date date);
	void postPrice(PriceDTO price);
	void putService(@PathVariable Integer id,@RequestBody PriceDTO price);
 
}
