package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@EnableJpaAuditing //BaseTimeEntity클래스를... 
@SpringBootApplication
public class Ex05Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex05Application.class, args);
	}

	//@Bean
	 public	CommandLineRunner	demo(CustomerRepository	repository)	{
	 return	(args)	->	{  //람다식으로 테이블에 데이터 추가
	 //	save a few customers
	 repository.save(new Customer("Jack", "010"));
	 repository.save(new Customer("Chloe", "111" ));
	 repository.save(new Customer("Kim", "222" ));
	 repository.save(new Customer("David", "333" ));
	 repository.save(new Customer("Michelle", "444" ));
	 //	fetch	all	customers
	 log.info("Customers	found	with	findAll():");
	 log.info("-------------------------------");
	 for	(Customer	customer	:	repository.findAll())	{
	 log.info(customer.toString());
	 }
	 log.info("");
	 };
  }
}
