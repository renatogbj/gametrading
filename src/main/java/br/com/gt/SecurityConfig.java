package br.com.gt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

import br.com.gt.model.service.UserService;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
			.and()
			.logout().logoutSuccessUrl("/")
			.and()
			.authorizeRequests()
			.antMatchers("/*/myoffers/**", "/*/mygames/**", "/announce/**").authenticated()
			.antMatchers(HttpMethod.POST, "/announcements/**").authenticated()
			.anyRequest().permitAll()
			.and()
			.rememberMe().tokenValiditySeconds(2419200).key("gametradingKey")
			.and()
			.requiresChannel().antMatchers("/login").requiresSecure()
			.and()
			.requiresChannel().antMatchers("/").requiresInsecure()
			.and()
			.csrf().disable(); // TODO - alter this later on (correct forms)
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(new UserService());
	}
	
    @Bean
    public TextEncryptor textEncryptor() {
        return Encryptors.noOpText();
    }
    
}
