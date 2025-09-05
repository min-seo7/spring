package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Customer;

@Repository   //Jpa는 Repositor, mybatis는 Mapper
public interface CustomerRepository extends JpaRepository<Customer, Long>{ 
		//JpaRepository 상속으로 인해 별도 추가xxx  상속되는거에 기본 쿼리문있음.
	
	//사용자정의 쿼리만들기 1
	List<Customer> findByNameLike(String name);  //리포지토리 메서드 추가!   => src/test/java에서 test해봄
	
	//쿼리만들기 2
	 @Query("select u from Customer u where u.phone like '%1%' order by name desc")  //대소문자 구분함. 
	 List<Customer> findByphone(String phone);
	
}
