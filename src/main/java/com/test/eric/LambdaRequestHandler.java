package com.test.eric;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaRequestHandler implements RequestHandler<User, String> {
	
	private static ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	
	private FakeDAO fakeDAO;
	
	public LambdaRequestHandler() {
		fakeDAO = ctx.getBean(FakeDAO.class);
	}

	@Override
	public String handleRequest(User input, Context context) {
		context.getLogger().log("input:"+input.getName());
		context.getLogger().log("fake:"+fakeDAO.getUserList().get(0).getName());
		return "Hello! "+input.getName();
	}
}
