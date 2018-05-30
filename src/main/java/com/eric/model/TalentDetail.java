package com.eric.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.DynamoDBAttributeType;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;

@DynamoDBDocument
public class TalentDetail {

	@DynamoDBTyped(DynamoDBAttributeType.S)
	private String tag;				//專長技能值
	@DynamoDBTyped(DynamoDBAttributeType.S)
	private String description;		//專長技能描述
	@DynamoDBTyped(DynamoDBAttributeType.N)
	private Integer grade = 0;		//專長技能自評(1-10)
	
	public TalentDetail() {
		super();
	}
	
	public TalentDetail(String tag) {
		super();
		this.tag = tag;
	}
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		if (grade != null) {			
			this.grade = grade;
		}
	}
	
}
