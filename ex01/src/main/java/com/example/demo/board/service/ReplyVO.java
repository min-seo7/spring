package com.example.demo.board.service;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.common.SearchVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Mapper
public class ReplyVO extends SearchVO{
	private Long rno;
	private Long bno;
	private String reply;
	private String replyer;
	private Date replyDate;
	private Date updateDate; 
}