package com.eric.handler;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.eric.model.Talent;
import com.eric.model.TalentDetail;

/**
 * 技能專長處理器
 * @author yung.ho
 *
 */
@Component
public class TalentHandler {

	@Resource(name="mapperBean")
	private DynamoDBMapper mapper;
	
	/**
	 * 寫入專長技能資料
	 * @param pid 使用者編號
	 * @param detailList 專長技能資料
	 * @throws Exception
	 */
	public void saveTalent(Long pid, List<TalentDetail> details) throws Exception {
		Talent talent = new Talent(pid);
		talent.setDetails(details);
		talent.setCreateDate(System.currentTimeMillis());
		mapper.save(talent);
	}
	
	
	/**
	 * 取得全部專長技能資料
	 * @param pid 使用者編號
	 * @return
	 * @throws Exception
	 */
	public Talent getTalent(Long pid) throws Exception {
		return mapper.load(Talent.class, pid);
	}
	
	
}
