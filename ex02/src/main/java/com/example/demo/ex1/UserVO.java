package com.example.demo.ex1;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Schema(description = "회원정보")  //설명
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
	@Schema(description = "회원이름")  
	//@JsonProperty("userName") -> Json에서는 키가 userName으로 [JsonProperty는 받을때]..
	String name; 
	
	@Schema(description = "나이") 
	//@JsonIgnore  
	int age;  
	
	@Schema(description = "가입일자") 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM") //json으로 보낼때
	private Date wdate; //날짜도 알아서 받아오고, 포맷지정도 가능함(시간도 가능함.)
	
	@Schema(description = "관심분야") 
	List<String> hobby; //뷰에서 동일한 이름의 파라미터를 여러게 넘겨주면 list나 배열로 받을 수 있음.
}
