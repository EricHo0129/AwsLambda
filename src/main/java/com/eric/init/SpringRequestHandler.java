package com.eric.init;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public abstract class SpringRequestHandler<I, O> implements ApplicationContextProvider, RequestHandler<I, O> {

	@SuppressWarnings("rawtypes")
	private final RequestHandler handler;
	
	public SpringRequestHandler() {
		handler = getApplicationContext().getBean(RequestHandler.class);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public O handleRequest(I input, Context context) {
		return (O) handler.handleRequest(input, context);
	}
}
