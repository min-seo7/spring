package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Address;
import com.example.demo.domain.Customer;
import com.example.demo.domain.School;
import com.example.demo.domain.Student;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.SchoolRepository;
import com.example.demo.repository.StudentRepository;

import lombok.extern.log4j.Log4j2;


@Log4j2
//@DataJpaTest //
@SpringBootTest
public class CustomerRepositoryTest {

	@Autowired CustomerRepository  customerRepository;
	@Autowired AddressRepository addressRepository;
	@Autowired SchoolRepository schoolRepository;
	@Autowired StudentRepository studentRepository;
	
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
		Customer customer = new Customer("kim", "010-1234-1234", null);
		customerRepository.save(customer);
		
		//등록 확인위해 전체조회
		customerRepository.findAll().forEach(System.out::println);
	}
	
	//@Test
	public void update() {
       //단건조회
	   Customer customer = customerRepository.findById(1L).get();
				
	   //이름변경
	   //customer.setName("lee");
				
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
	
	//@Test
	public void findByphone() {
		customerRepository.findByphone("1").forEach(System.out::println);
	}
	
	//@Test  //일대일 관계 테스트용: customerTable customer 1명에 주소 id를 FK로 1:1 관계로 갖음.  
	public void 일대일테스트() {
        //given(준비)
		Address	addressEntity = Address.builder().zipcode("04411").address("대구").build();	
		addressRepository.save(addressEntity);
		
		 Customer customerentity = Customer.builder()
					.name("길동")
					.phone("011")
					.address(addressEntity)
					.build();
		            customerRepository.save(customerentity);
		
		 //when(실행)
		 Customer customer =  customerRepository.findById(1L).get();
		 log.info(customer.getName()+":"+customer.getAddress().getZipcode());
		 
		 //then(검증)
		 assertEquals("04411",	customer.getAddress().getZipcode());
		 
	}
	
	@Test
	 void 다대일테스트(){
	     School school	= new School("예담고등학교");
	     Student s1 = new Student("홍길동");
	     Student s2 = new Student("이몽룡");
	     school.addStudent(s1);
	     school.addStudent(s2);
	     //	school	저장	시	students	도	함께	persist	됨	(CascadeType.ALL	덕분에)
	     schoolRepository.save(school);
							
	     studentRepository.findAll().forEach(std	->	{		log.info(std);			});
		}
	
	
}

