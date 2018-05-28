package com.test.eric;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaRequestHandler implements RequestHandler<User, String> {

	@Override
	public String handleRequest(User input, Context context) {
		context.getLogger().log("input:"+input.getName());
		return "Hello! "+input.getName();
	}
}
