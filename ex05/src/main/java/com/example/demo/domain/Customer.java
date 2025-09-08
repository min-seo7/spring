package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;


@Getter
@Entity //@Entity붙은 클래스를 찾아서 테이블이 자동으로 생성됨. 
public class Customer {
  
    //생성자
	public Customer() {};
	
	
	public Customer(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
  
	@Builder
	public Customer(String name, String phone, Address address) {  //생성자 지정해서 만들때, 기본생성자도
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
  
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
  

   @Column(length = 20, nullable = false)
   private String name;
   
   @Column(length = 20, nullable = false, unique = true)
   private String phone;     
   
   @OneToOne   //1대1관계
   @JoinColumn(name ="address_id")
   Address address;
   
}