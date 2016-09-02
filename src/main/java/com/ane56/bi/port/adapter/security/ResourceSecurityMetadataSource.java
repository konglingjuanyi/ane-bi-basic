package com.ane56.bi.port.adapter.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 资源授权
 * 
 * @author Louis Huang
 * @since 1.0
 */
public class ResourceSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {

	private Map<RequestMatcher, Collection<ConfigAttribute>> resources;

	public ResourceSecurityMetadataSource() {
	}
	
	public Map<RequestMatcher, Collection<ConfigAttribute>> getResources() {
		return resources;
	}

	public void setResources(Map<RequestMatcher, Collection<ConfigAttribute>> resources) {
		this.resources = resources;
	}



	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		if( SecurityContextHolder.getContext().getAuthentication() == null ) {
			return null;
		}
		
		final HttpServletRequest request = ((FilterInvocation) object).getRequest();
		
		for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : resources
				.entrySet()) {
			if (entry.getKey().matches(request)) {
				return entry.getValue();
			}
		}
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		Set<ConfigAttribute> allAttributes = new HashSet<>();
		for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : resources
				.entrySet()) {
			allAttributes.addAll(entry.getValue());
		}
		return allAttributes;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}
}
