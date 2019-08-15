package com.laxman.project.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.laxman.project.service.AuthenticationService;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AuthenticationService authenticationService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.userDetailsService(authenticationService).passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	
	@Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MySimpleUrlAuthenticationSuccessHandler();
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/","/About","/Create_Student_Account","/test","/s/check_user_name").permitAll()
			.antMatchers("/a/**").hasAuthority("admin")
			.antMatchers("/s/**").hasAuthority("student")
			.antMatchers("/m/**").hasAuthority("mac")
			.and()
				.csrf().disable()
				//for custom login page write .formLogin().loginPage("/login").loginProcessingURL("/doLogin").successHandler(myAuthenticationSuccessHandler);
				//"/login" inside loginPage should be there in controller redirecting to login view. action of login view should be same as "/doLogin"(it can be anything but both should be same)
				//we don't have to write any code for "/doLogin" once we click login button configureGlobal part will run.
				.formLogin().successHandler(myAuthenticationSuccessHandler())
				.failureUrl("/login?error")
				.usernameParameter("username").passwordParameter("password")
			.and()
				.logout().logoutSuccessUrl("/");
		
	}
}
