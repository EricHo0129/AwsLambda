package com.eric.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
@ComponentScan(basePackages="com.eric")
public class AppConfig {

	@Bean
	@Scope("singleton")
	public DynamoDBMapper mapperBean() throws Exception {		
		AmazonDynamoDB adb = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.AP_NORTHEAST_1).build();		
		return new DynamoDBMapper(adb);
	}
}
