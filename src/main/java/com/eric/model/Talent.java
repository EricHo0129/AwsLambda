package com.eric.model;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.DynamoDBAttributeType;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;
/**
 * 專長技能(標籤)的資料模型
 * @author yung.ho
 *
 */
@DynamoDBTable(tableName = "cprofile-talent")
public class Talent {

	//主鍵
	@DynamoDBHashKey
	@DynamoDBTyped(DynamoDBAttributeType.N)
	private Long pid;
	//物件的主要存放區
	@DynamoDBTyped(DynamoDBAttributeType.L)
	private List<TalentDetail> details;
	//資料時間
	@DynamoDBTyped(DynamoDBAttributeType.N)
	private Long createDate;
	
	public Talent() {
		super();
	}
	
	public Talent(Long pid) {
		super();
		this.pid = pid;
	}
	
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public List<TalentDetail> getDetails() {
		return details;
	}
	public void setDetails(List<TalentDetail> details) {
		this.details = details;
	}
	public Long getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}
	
	
	
}
