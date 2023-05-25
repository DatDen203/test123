package com.example.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class security extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username,password, enabled from users where username=?")
				.authoritiesByUsernameQuery(
						"Select username, concat('ROLE_',user_role) user_role from user_roles where username=?").passwordEncoder(passwordEncoder());
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/admin/**")
			.access("hasRole('ROLE_ADMIN')")
			.antMatchers("/*")
			.permitAll()
		    .anyRequest().authenticated()
			.and()
			.formLogin()
			.loginProcessingUrl("/doLogin")
			.loginPage("/login").permitAll()
			.passwordParameter("pass")
			.usernameParameter("username")
			.defaultSuccessUrl("/list")
			.failureUrl("/login?error")
			.and()
			.logout()
			.permitAll()
			.logoutUrl("/logoutSuccess")
			.logoutSuccessUrl("/login?logout=true")
			.and()
			.csrf().disable()
			;
	}
	
	//chưa mã hóa pass
}