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
				.usersByUsernameQuery("SELECT ID, pass, true FROM user WHERE ID=?")
				.authoritiesByUsernameQuery("SELECT u.ID, concat(\"ROLE_\", r.user_role)\r\n"
						+ "FROM user_role ur \r\n"
						+ "INNER JOIN user u \r\n"
						+ "ON u.id = ur.ID_USER \r\n"
						+ "INNER JOIN role r \r\n"
						+ "ON r.ID = ur.ID_ROLE \r\n"
						+ "WHERE u.ID= ?;")
				.passwordEncoder(passwordEncoder());
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
			//Quyền admin
			.antMatchers("/admin/**")
			//.antMatchers("/list")
			.access("hasRole('ROLE_ADMIN')")
			//Quyền User
			.antMatchers("/about")
			.access("hasRole('ROLE_USER')")
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