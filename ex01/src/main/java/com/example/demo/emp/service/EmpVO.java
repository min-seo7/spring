package com.example.demo.emp.service;

import java.util.Date;

import com.example.demo.common.SearchVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpVO extends SearchVO {
	//마이바티스 별도설정안해서 컬럼명 그대로 [대소문자를 구분안함]
	//카멜케이스로 변경할 경우 대소문자 구분!!!! [마이바티스에서 카멜케이스로 사용할 수 있도록 설정]
	private Long employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private Double salary;
	private Double commissionPct;
	private Long managerId;
	private Long departmentId;
	
	DeptVO deptVO;
}