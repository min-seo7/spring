package com.example.demo.yedam.service;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentVO extends BookVO{
	private Long rentNo;
	private Long rentPrice;
	private Date rentDate;
	private String rentStatus;	
}
