package com.example.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
        .anyRequest().fullyAuthenticated()
        .and()
      .formLogin();
  }

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
      .ldapAuthentication()
        .userDnPatterns("uid={0},ou=people")
        .groupSearchBase("ou=groups")
        .contextSource()
          .url("ldap://localhost:8389/dc=springframework,dc=org")
          .and()
        .passwordCompare()
          .passwordEncoder(new BCryptPasswordEncoder())
          .passwordAttribute("userPassword");
  }

}
	
	//<------------------------AUTHENTICATION PART---------------------------->
//	@Bean
//	protected InMemoryUserDetailsManager configureAuthentication() {
//		
//		UserDetails users = User.builder()
//				.username("gaurav")
//				.password(encoder.encode("gb"))
//				.roles("USER")
//				.build();
//		return new InMemoryUserDetailsManager(users);
//		}
//	
//	@Bean
//	protected InMemoryUserDetailsManager configureAuthentication2() {
//		UserDetails users2 = User.builder()
//				.username("gauravadmin")
//				.password(encoder.encode("gbadmin"))
//				.roles("ADMIN")
//				.build();
//		return new InMemoryUserDetailsManager(users2);
//		}
	
	//<-----------------------AUTHORIZATION PART---------------------------->
//	@Bean
//	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		
//		http.authorizeRequests()
//			.antMatchers("/home/admin").hasRole("ADMIN")
//			.antMatchers("/home/user").hasRole("USER")
//			.antMatchers("/home/welcome").permitAll()
//			.and().formLogin();
//		
//		http.authorizeRequests()
//			.anyRequest().fullyAuthenticated()
//			.and()
//			.formLogin();
//		
//		return http.build();
//	}
	

