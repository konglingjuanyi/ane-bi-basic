package com.ane56.bi.g7.service;
import java.sql.SQLException;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.ane56.bi.g7.dao.ClasslineDao;
import com.ane56.bi.g7.domain.Classline;
import com.ane56.bi.g7.domain.PageResult;
import com.ane56.bi.g7.domain.Test;

public class ClasslineService {
	private ClasslineDao classlineDao = new ClasslineDao();
	
	public Classline findByBid(String cid) {
		try {
			return classlineDao.findByBid(cid);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	 public void addTest(Test test){
		 classlineDao.addTest(test);
	 }
	

	 public void addClassLine(PageResult pageResult) throws Exception{
		 if(pageResult!=null){
			 List<Classline> classLine = pageResult.getResult();
			 if(!CollectionUtils.isEmpty(classLine)){
				 for(int i=0;i<classLine.size();i++){
					 Classline g7bean = classLine.get(i);
						classlineDao.addClassLine(g7bean);
				 }
				
				 
			 }
		 }
		 
	 }
}
