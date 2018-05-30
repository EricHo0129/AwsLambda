package com.eric.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eric.config.AppConfig;
import com.eric.handler.TalentHandler;
import com.eric.model.TalentDetail;
import com.eric.model.User;

public class MainHandler implements RequestHandler<User, List<TalentDetail>> {
	
	private static ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	
	private TalentHandler talentHandler;
	
	public MainHandler() {
		talentHandler = ctx.getBean(TalentHandler.class);
	}

	@Override
	public List<TalentDetail> handleRequest(User user, Context context) {
		context.getLogger().log("user:"+user.getPid());
		try {
			return talentHandler.getTalent(user.getPid()).getDetails();
		} catch (Exception e) {
			context.getLogger().log("Error:"+e.toString());
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
}
