package com.example.demo;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContext;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.GetMapping;
        
//import com.example.demo.dao.UserRepository;
//import com.example.demo.entities.User;

//import com.example.demo.dao.UserRepository;
//import com.example.demo.entities.User;
  
@SpringBootApplication
public class DemoStaticApplication  {
//	 @GetMapping("/user")
//	    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
//	        return Collections.singletonMap("name", principal.getAttribute("name"));
//	    }

	public static void main(String[] args) {
		
		SpringApplication.run(DemoStaticApplication.class, args);
		
	}
//	 @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	    	// @formatter:off
//	        
//		 
//		 http
//	            .authorizeRequests(a -> a
//	                .antMatchers("/", "/error","/signup","/css/**", "/webjars/**").permitAll()
//	                .anyRequest().authenticated()
//	            )
//	            .exceptionHandling(e -> e
//	                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//	            );
//	            http.oauth2Login()
//	            .loginPage("/login")
//	            .successHandler(new AuthenticationSuccessHandler() {
//	         
//	                @Override
//	                public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//	                        Authentication authentication) throws IOException, ServletException {
//	         
//	                    response.sendRedirect("/hotel");
//	                }
//	            });

//	            
//	        // @formatter:on
//	    }
}
