package com.ingsoftw.v01.natour_webservices;

import com.ingsoftw.v01.natour_webservices.utils.JWTAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableSwagger2
@Configuration
public class NatourWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(NatourWebservicesApplication.class, args);
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ingsoftw.v01.natour_webservices")).build();
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
				/*	.antMatchers(HttpMethod.POST, "/auth/login").permitAll()
					.antMatchers(HttpMethod.POST, "/auth/registrazione").permitAll()
					.antMatchers(HttpMethod.GET, "/swagger-ui.html").permitAll()
					.antMatchers(HttpMethod.GET, "/swagger-resources/**").permitAll()
					.antMatchers(HttpMethod.GET, "/v2/**").permitAll()
					.antMatchers(HttpMethod.GET, "/webjars/**").permitAll()*/
					.antMatchers(HttpMethod.GET, "/**").permitAll()
					.antMatchers(HttpMethod.POST, "/**").permitAll()
					.antMatchers(HttpMethod.DELETE, "/**").permitAll()
					.anyRequest().authenticated();
		}
	}
}

