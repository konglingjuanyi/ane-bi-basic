package com.ane56.bi.port.adapter.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.ane56.bi.application.UserApplicationService;
import com.ane56.bi.application.command.user.AuthenticationCommand;
import com.ane56.bi.domain.user.AuthticationType;
import com.ane56.bi.domain.user.UserDescripter;

public class UserAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserApplicationService userApplicationService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		UserDescripter userDescripter = this.userApplicationService()
				.authentication(new AuthenticationCommand(username, password, AuthticationType.USERNAME));

		if (userDescripter != null && userDescripter.isEnabled()) {
			return asAuthentication(userDescripter);
		}

		throw new AuthenticationServiceException(
				"UserDetailsService returned null, which is an interface contract violation");
	}

	private Authentication asAuthentication(UserDescripter account) {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : account.getRoles()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		}
		UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(account.getUsername(),
				null, authorities);
		result.setDetails(account);
		return result;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(UsernamePasswordAuthenticationToken.class);
	}

	private UserApplicationService userApplicationService() {
		return this.userApplicationService;
	}

}
