package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean  //비밀번호 BCrypt로 암호화 class 등록
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

	@Bean   //class CustomLoginSuccessHandler을 빈등록 
	public AuthenticationSuccessHandler authenticationSuccessHandler() { 
		return new CustomLoginSuccessHandler();
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home").permitAll() //permitAll 모두 허용. 
				.requestMatchers("/admin").hasRole("ADMIN")
				.anyRequest().authenticated() //모든 요청은 인증된 사용자만 접근 가능함. [권한(Role)" 확인이 아니라, 로그인(인증, Authentication)이 되었는지만 확인] 
				//==>authenticated() → 로그인만 되어 있으면 됨. cf)hasRole("ADMIN") → 로그인도 되어 있고, "ADMIN" 권한을 가진 사용자만 접근 가능.
			)
			.formLogin((form) -> form     //->는 람다식 표현방법
				.loginPage("/login").permitAll()  
				.successHandler(authenticationSuccessHandler())  //로그인이 성공하면 어드민 페이지로 이동. 
			)
		    .logout((logout) -> logout.permitAll());
		//http.csrf(csrf -> csrf.disable());//csrf 사용안하는 걸로 세팅. (디폴트는 토큰사용이라, 미사용시 문장추가.)
		
		
		http.exceptionHandling(ex -> ex.accessDeniedHandler(deniedHandler())); 
		
		return http.build();
	}

	
	@Bean
	public AccessDeniedHandler deniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	//@Bean
//	public UserDetailsService userDetailsService() {  //별도 DB작업없이 로그인 가능하도록
//		
//		//권한: user 
//		UserDetails user =
//			 User.withDefaultPasswordEncoder()
//				.username("u01")
//				.password("1234")
//				.roles("USER")
//				.build();
//		
//		//권한: admin
//		UserDetails admin =
//				 User.withDefaultPasswordEncoder()
//					.username("a01")
//					.password("1234")
//					.roles("ADMIN", "HR") //여러 권한도 지정가능.
//					.build();
//		
//		return new InMemoryUserDetailsManager(user, admin);
//	}

}