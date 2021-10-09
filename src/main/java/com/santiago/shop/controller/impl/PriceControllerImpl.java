package com.santiago.shop.controller.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.santiago.shop.controller.PriceController;
import com.santiago.shop.dao.IPriceDAO;
import com.santiago.shop.dto.PriceDTO;

@RestController
@RequestMapping(value = "/price")
public class PriceControllerImpl implements PriceController {

	@Autowired
	private IPriceDAO priceDAO;
	
	private final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

	@Override
	@GetMapping("/date")
	public List<PriceDTO> getPriceBydDate(@RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") final Date date) {
		return StreamSupport.stream(priceDAO.findAll().spliterator(), false).filter(filterDate(date))
				.collect(Collectors.toList());

	}

	private Predicate<? super PriceDTO> filterDate(Date date) {
		return price -> formatter.format(date).equals(formatter.format(price.getStartDate()));
	}

	@Override
	@PostMapping
	public void postPrice(@RequestBody PriceDTO price) {
		if (Objects.isNull(price))
			throw new NullPointerException();

		priceDAO.save(price);
	}

	@Override
	@PutMapping("/{id}")
	public void putService(@PathVariable Integer id,@RequestBody PriceDTO price) {
		if (Objects.isNull(price))
			throw new NullPointerException();

		priceDAO.save(price);
		
	}

	@Override
	@GetMapping
	public List<PriceDTO> getPrices() {
		return StreamSupport.stream(priceDAO.findAll().spliterator(), false).collect(Collectors.toList());
	}
	
	
	
	

}
