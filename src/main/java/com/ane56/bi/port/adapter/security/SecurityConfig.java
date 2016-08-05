package com.ane56.bi.port.adapter.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void registerAuthentication(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.authenticationProvider(userAuthenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
				.disable()
				.formLogin()
				.successHandler(new SavedRequestAwareAuthenticationSuccessHandler())
				.loginPage("/signin")
//				.loginProcessingUrl("/signin/authenticate")
//				.failureUrl("/signin?error=bad_credentials")
				.permitAll()
				.and()
				.logout()
				.logoutSuccessUrl("/")
				.logoutRequestMatcher(new AntPathRequestMatcher("/signout", "GET"))
				.deleteCookies("JSESSIONID").permitAll();
		
		http.authorizeRequests().antMatchers("/**").permitAll();
		
		http.addFilterAfter(resourceFilterSecurityInterceptor() , UsernamePasswordAuthenticationFilter.class);
	}
	
	
	@Bean
	public UserAuthenticationProvider userAuthenticationProvider(){
		return new UserAuthenticationProvider();
	}
	
	@Bean
	public ResourceFilterSecurityInterceptor resourceFilterSecurityInterceptor() throws Exception{
		ResourceFilterSecurityInterceptor filter = new ResourceFilterSecurityInterceptor();
		List<AccessDecisionVoter<?>> decisionVoters = new ArrayList<>();
		decisionVoters.add(new RoleVoter());
		decisionVoters.add(new WebExpressionVoter());
		AffirmativeBased affirmative = new AffirmativeBased(decisionVoters);
		filter.setAccessDecisionManager(affirmative);
		filter.setAuthenticationManager(authenticationManager());
		filter.setSecurityMetadataSource(resourceSecurityMetadataSource());
		return filter;
	}
	
	@Bean
	public ResourceSecurityMetadataSource resourceSecurityMetadataSource(){
		ResourceSecurityMetadataSource resMetadata = new ResourceSecurityMetadataSource();
		ResourceSecurityConfigService configService = resourceSecurityConfigService();
		configService.setResourceSecurityMetadataSource(resMetadata);
		resMetadata.setResources(configService.buildResources());
		return resMetadata;
	}
	
	@Bean
	public ResourceSecurityConfigService resourceSecurityConfigService(){
		return new ResourceSecurityConfigService();
	}
	
	
}
