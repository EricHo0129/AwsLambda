package com.eric.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eric.config.AppConfig;
import com.eric.init.SpringRequestHandler;

@SuppressWarnings("rawtypes")
public class MainHandler extends SpringRequestHandler {
	
	@Override
	public ApplicationContext getApplicationContext() {
		return new AnnotationConfigApplicationContext(AppConfig.class);
	}
	
}
