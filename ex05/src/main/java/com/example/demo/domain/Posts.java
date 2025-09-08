package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

//@setter posts에 필드값을 변경하면 DB에 반영됨. 
@Getter
@Entity
public class Posts extends BaseTimeEntity {

	@Id//필수
	@GeneratedValue(strategy = GenerationType.AUTO)  //시퀀스 만들도록 
	private Long id;  
	
	@Column(name = "post_title", length = 100, nullable = false) //컬험을 설정해줌. [테이블_컬럼명, 컬럼크기, null가능여부설정 해줌 ]
	private String title;
	private String content;
	
	//@Transient //엔티티 클래스의 변수들 중에 테이블의 칼럼과 매핑에서 제외해야 하는 경우 사용 => 객체에 임시로 어떤 값을 보관할때 사용. (DB저장xxx)
	private String author;
	
	public Posts() {};
	
//	@CreatedDate   //데이터 등록시 날짜자동입력
//	@Temporal(TemporalType.TIMESTAMP)  //날짜 타입을 매핑할 때 사용
//	private Date wdate;
//	
//	@LastModifiedDate
//	@Temporal(TemporalType.TIMESTAMP)  //날짜 타입을 매핑할 때 사용
//	private Date update;
//	                                     ==================> 날짜입력을 BaseTimeEntity로 class분리해서 상속처리함.(다른테이블도 날짜컬럼공통사용 별도분리)
//		
	
	@Builder
	public Posts(String title, String content, String author) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	//업데이트 메서드
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
	
}
