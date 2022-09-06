package com.axteam.gateway.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/swagger-ui/index.html#/").anonymous()
				.antMatchers("/gateway/**").authenticated()
				.and()
				.formLogin()
				.and()
				.logout().logoutSuccessUrl("/");
	}

	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder()
				.username("bob")
				.password("{bcrypt}$2a$10$yc/dQH.i7kzC3m/Ih1.Qh.so0O1.tsMtHdNhPK4Fe68g6WpnBTVsa")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}
}
