package com.example.demo.board.service;

import java.util.Date;

import com.example.demo.common.SearchVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder  //롬복 어노테이션, VO, DTO, Entity에 사용. 
@NoArgsConstructor
@AllArgsConstructor
public class ReplyVO extends SearchVO{
	private Long rno;
	private Long bno;
	private String reply;
	private String replyer;
	private Date replyDate;
	private Date updateDate; 
}