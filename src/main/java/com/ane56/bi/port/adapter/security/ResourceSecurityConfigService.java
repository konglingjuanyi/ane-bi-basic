package com.ane56.bi.port.adapter.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 权限资源配置服务
 * @author Louis Huang
 * @since 1.0
 */
public class ResourceSecurityConfigService {
	
	private ResourceSecurityMetadataSource resourceSecurityMetadataSource;
	
	
	public Map<RequestMatcher, Collection<ConfigAttribute>> buildResources(){
		Map<RequestMatcher, Collection<ConfigAttribute>> map = new ConcurrentHashMap<>();
//		for (Resource res : getAllResources()) {
//			if(! StringUtils.isEmpty(res.getUrl())) {
//				map.put(new AntPathRequestMatcher(res.getUrl()), getCongfigs(res));
//			}
//		}
		return map;
	}
	
	public void rebuild(){
		 Map<RequestMatcher, Collection<ConfigAttribute>> resourcesMap =  buildResources();
		 this.resourceSecurityMetadataSource.setResources(resourcesMap);
	}
	
	private Collection<ConfigAttribute> getCongfigs() {
		Set<ConfigAttribute> configs = new HashSet<>();
//		for (Role r : res.getRoles()) {
//			configs.add(new SecurityConfig("ROLE_" +  r.getName()));
//		}
		return configs;
	}

//	private List<Resource> getAllResources() {
//		List<Resource> resources = this.resourceService.findAll(this.defaultUserSystem);
//		return resources;
//	}

	public void setResourceSecurityMetadataSource(
			ResourceSecurityMetadataSource resourceSecurityMetadataSource) {
		this.resourceSecurityMetadataSource = resourceSecurityMetadataSource;
	}

}
