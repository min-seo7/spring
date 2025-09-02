package com.example.demo.ex1;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
	@JsonProperty("userName")
	String name;
	
	@JsonIgnore  
	int age;  
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM") //json으로 보낼때
	private Date wdate; //날짜도 알아서 받아오고, 포맷지정도 가능함(시간도 가능함.)
	
	List<String> hobby; //뷰에서 동일한 이름의 파라미터를 여러게 넘겨주면 list나 배열로 받을 수 있음.
}
