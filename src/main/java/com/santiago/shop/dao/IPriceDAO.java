package com.santiago.shop.dao;

import org.springframework.data.repository.CrudRepository;

import com.santiago.shop.dto.PriceDTO;

public interface IPriceDAO extends CrudRepository<PriceDTO, Integer> {

}
