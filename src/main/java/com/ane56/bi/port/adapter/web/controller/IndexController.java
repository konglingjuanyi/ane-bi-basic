package com.ane56.bi.port.adapter.web.controller;

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
