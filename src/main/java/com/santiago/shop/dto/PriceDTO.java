package com.santiago.shop.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity(name = "PRICE")
public class PriceDTO {

	@Id
	@Column(name = "BRAND_ID")
	private Integer brandId;
	
	@Column(name = "START_DATE")
	@JsonFormat(pattern = "dd.MM.yyyy")
	private Date startDate;
	
	@Column(name = "END_DATE")
	@JsonFormat(pattern = "dd.MM.yyyy")
	private Date endDate;
	
	@Column(name = "PRICE_LIST")
	private Float priceList;
	
	@Column(name = "PRODUCT_ID")
	private Integer productId;
	
	@Column(name = "PRIORITY")
	private Integer priority;
	
	@Column(name = "PRICE")
	private Float price;
	
	@Column(name = "CURR")
	private String curr;

}
