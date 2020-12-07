package hu.dw9yg6.semTaskDW9YG6.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	protected void configure (HttpSecurity http) throws Exception {
		http
			.formLogin()
			.loginPage("/login")
			.permitAll()
			.loginProcessingUrl("/login")
			.usernameParameter("username").passwordParameter("password")
			.failureUrl("/login")
		.and()
			.authorizeRequests()
				.antMatchers("/", "/list").permitAll()
				.anyRequest().authenticated();
		}
	
	
	@Override
	protected UserDetailsService userDetailsService() {
		UserDetails user = User.withUsername("username").password("password").roles("ADMIN").build();
		
		return new InMemoryUserDetailsManager(user);
	}
	
	@Autowired
	public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("username").password("{noop}password").roles("ADMIN");
	}
	

	@Override
	public void configure (WebSecurity web) {
		web.ignoring()
		.antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**");
	}
	
}
