package br.com.gt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

import br.com.gt.model.repository.UserRepository;
import br.com.gt.model.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.formLogin()
				.loginPage("/")
				.defaultSuccessUrl("/announcements")
			.and()
				.logout()
					.logoutSuccessUrl("/announcements")
			.and()
				.authorizeRequests()
					.antMatchers("/myoffers/**", "/mygames/**", "/announce/**").authenticated()
					.antMatchers(HttpMethod.POST, "/announcements/**").authenticated()
					.antMatchers("/**").permitAll()
			.and()
				.rememberMe()
			.and()
				.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(new UserService(userRepository));
	}
	
    @Bean
    public TextEncryptor textEncryptor() {
        return Encryptors.noOpText();
    }
    
}
