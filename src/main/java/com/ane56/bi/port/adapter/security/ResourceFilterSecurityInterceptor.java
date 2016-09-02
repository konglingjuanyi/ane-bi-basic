package com.ane56.bi.port.adapter.security;

import java.io.IOException;


/**
 * 权限资源
 * @author Louis Huang
 * @since 1.0
 */
public class ResourceFilterSecurityInterceptor extends AbstractSecurityInterceptor
		implements Filter {

	private SecurityMetadataSource securityMetadataSource;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		FilterInvocation fi = new FilterInvocation(request, response, chain);
		invoke(fi);

	}

	public void invoke(FilterInvocation fi) throws IOException,
			ServletException {
		InterceptorStatusToken token = super.beforeInvocation(fi);
		try {
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		} finally {
			super.finallyInvocation(token);
		}
		super.afterInvocation(token, null);
	}

	@Override
	public void destroy() {
	}

	@Override
	public Class<?> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.securityMetadataSource;
	}

	public void setSecurityMetadataSource(
			SecurityMetadataSource securityMetadataSource) {
		this.securityMetadataSource = securityMetadataSource;
	}

}
