package com.eric.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eric.handler.TalentHandler;
import com.eric.model.TalentDetail;

@Component
public class TalentController implements RequestHandler<Map, List<TalentDetail>> {

	@Autowired
	private TalentHandler talentHandler;
	
	@Override
	public List<TalentDetail> handleRequest(Map user, Context context) {
		context.getLogger().log("user:"+user.get("pid"));
		try {
			return talentHandler.getTalent(Long.valueOf(user.get("pid").toString())).getDetails();
		} catch (Exception e) {
			context.getLogger().log("Error:"+e.toString());
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
}
