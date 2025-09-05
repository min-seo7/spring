package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;

@DataJpaTest ///SpringTest도 가능. but DataJapTest는 자동 DB rollback
public class CustomerRepositoryTest {

	@Autowired  CustomerRepository  customerRepository;
	
	//@Test
	public void list() {
        List<Customer>	list = customerRepository.findAll();
        
        list.forEach(System.out::println);
               
	}
	
	//@Test
	public void get() {
		Customer customer = customerRepository.findById(1L).get();
		System.out.println(customer);
	}
	
	//@Test
	public void delete() {   // 삭제방법 2가지: 1)단건조회 후 삭제. 2)where조건에 id지정 
		//단건조회
		Customer customer = customerRepository.findById(1L).get();
		//삭제
		customerRepository.delete(customer);
	}
	
	//@Test
	public void insert() {
		//등록
		Customer customer = new Customer("kim", "010-1234-1234");
		customerRepository.save(customer);
		
		//등록 확인위해 전체조회
		customerRepository.findAll().forEach(System.out::println);
	}
	
	//@Test
	public void update() {
       //단건조회
	   Customer customer = customerRepository.findById(1L).get();
				
	   //이름변경
	   customer.setName("lee");
				
	   //save
	   customerRepository.save(customer);
				
	   //결과 출력
	   System.out.println(customer);
	   customerRepository.findAll().forEach(System.out::println);
	}
	
	//@Test
	public void findName() {
		customerRepository.findByNameLike("%Ki%").forEach(System.out::println);
	}
	
	@Test
	public void findByphone() {
		customerRepository.findByphone("1").forEach(System.out::println);
	}
	
	
}

