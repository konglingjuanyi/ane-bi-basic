package com.ane56.bi.port.adapter.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController  {
	


	@RequestMapping(value = "/" )
	public String index(){
		return "index";
	}
	
	@RequestMapping(value = "/sidebar" )
	public String sidebar(){
		return "public/admin-sidebar";
	}
	
	@RequestMapping(value = "/{path}" )
	public String app(@PathVariable String path){
		return path;
	}
}
