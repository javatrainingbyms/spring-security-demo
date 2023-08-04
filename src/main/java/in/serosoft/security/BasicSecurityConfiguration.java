package in.serosoft.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import in.serosoft.UserInfoUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class BasicSecurityConfiguration  {
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserInfoUserDetailsService();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/welcomeuser","/newuser")
		.permitAll()
		.and()
		.authorizeHttpRequests().requestMatchers("/**")
		.authenticated()
		.and()
		.formLogin()
		.and()
		.build();
		
	}
	
	/*
	@Bean
	public InMemoryUserDetailsManager userDetails(PasswordEncoder encoder) {
		UserDetails user1=User.withUsername("shubham").password(encoder.encode("serosoft")).roles("ADMIN","SUPERVISOR").build();
		UserDetails user2=User.withUsername("abhishek").password(encoder.encode("serosoft")).roles("STUDENT").build();
		UserDetails user3=User.withUsername("rohit").password(encoder.encode("serosoft")).roles("PARENT").build();
	
		List<UserDetails> userList=Arrays.asList(user1,user2,user3);
		//InMemoryUserDetailsManager imudm=new InMemoryUserDetailsManager(userList);
		InMemoryUserDetailsManager imudm=new InMemoryUserDetailsManager(user1,user2,user3);
		return imudm;
	}
	*/
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
