package com.ezen.springdatarest.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class FruitDTO {
	private Integer fid;
	private String fname;
	private Integer price;
	private Integer qty;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date exp_date;
	private Integer location_id;
}
