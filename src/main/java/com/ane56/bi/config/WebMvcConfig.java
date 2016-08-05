package com.ane56.bi.config;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { 
	"com.ane56.bi.port.adapter.web.controller" ,
	"com.ane56.bi.port.adapter.web.resource"
})
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/styles/**").addResourceLocations(
				"/build/public/styles/");
		registry.addResourceHandler("/js/**").addResourceLocations(
				"/build/public/js/");
		registry.addResourceHandler("/images/**").addResourceLocations(
				"/build/public/images/");
		registry.addResourceHandler("/fonts/**").addResourceLocations(
				"/build/public/fonts/");
		registry.addResourceHandler("/sound/**").addResourceLocations(
				"/build/public/sound/");
		registry.addResourceHandler("/public/**").addResourceLocations(
				"/build/views/public/");

		
		registry.addResourceHandler("/views/**").addResourceLocations("/build/views/");
	}
	
	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);

		ByteArrayHttpMessageConverter byteArrayMessageConverter = new ByteArrayHttpMessageConverter();
		converters.add(byteArrayMessageConverter);

		GsonHttpMessageConverter httpMessageConverter = new GsonHttpMessageConverter();
		GsonBuilder builder = new GsonBuilder();
		builder.serializeNulls()
				.registerTypeAdapter(java.util.Date.class,
						new JsonSerializer<Date>() {
							@Override
							public JsonElement serialize(Date arg0, Type arg1,
									JsonSerializationContext arg2) {
								return new JsonPrimitive(arg0.getTime());
							}
						})
				.registerTypeAdapter(java.util.Date.class,
						new JsonDeserializer<Date>() {
							@Override
							public Date deserialize(JsonElement arg0,
									Type arg1, JsonDeserializationContext arg2)
									throws JsonParseException {
								try {
									return DateUtils.parseDate(
											arg0.getAsString(),
											"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd");
								} catch (ParseException e) {
								}
								return null;
							}
						}).setDateFormat(DateFormat.LONG).disableHtmlEscaping();
		httpMessageConverter.setGson(builder.create());
		converters.add(httpMessageConverter);

	}

	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setPrefix("/views/");
		view.setSuffix(".html");
		view.setCache(false);
		return view;
	}

	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver mutipartResolver = new CommonsMultipartResolver();
		mutipartResolver.setDefaultEncoding("utf-8");
		mutipartResolver.setMaxUploadSize(20 * 1048576);
		return mutipartResolver;
	}
	

}
