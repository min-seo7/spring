package com.example.demo.emp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.emp.mapper.EmpMapper;
import com.example.demo.emp.service.EmpService;
import com.example.demo.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service  //@Component의 하위클래스가 @service
public class EmpServiceImpl implements EmpService{ //서비스 구현

	final EmpMapper empMapper;  //매퍼 injection - 권장: @RequiredArgsConstructor 방식
	
	@Override
	public Long selectCount(EmpVO empVO) {
		return empMapper.selectCount(empVO);
	}

	@Override
	public List<EmpVO> selectEmp(EmpVO empVO) {
		return empMapper.selectEmp(empVO);
	}

	@Override
	public EmpVO selectEmpById(Long employeeId) {
		return empMapper.selectEmpById(employeeId);
	}

	@Override
	public int insertEmp(EmpVO empVO) {
		return empMapper.insertEmp(empVO);
	}  

}
