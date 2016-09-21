package com.ane56.bi.g7.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.ane56.bi.g7.dao.ClasslineDao;
import com.ane56.bi.g7.domain.Classline;
import com.ane56.bi.g7.domain.PageResult;
import com.ane56.bi.g7.domain.PassInfoData;
import com.ane56.bi.g7.domain.Test;

public class ClasslineService {
	private ClasslineDao classlineDao = new ClasslineDao();

	public Classline findByBid(String id) {
		try {
			return classlineDao.findClassLineByBid(id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void addTest(Test test) {
		classlineDao.addTest(test);
	}

	public boolean addClassLine(PageResult pageResult) throws Exception {
		if (pageResult != null) {
			List<Classline> classLine = pageResult.getResult();
			if (!CollectionUtils.isEmpty(classLine)) {
				for (int i = 0; i < classLine.size(); i++) {
					Classline classLineBean = null;
					Classline g7bean = classLine.get(i);
					List<PassInfoData> passInfoList = g7bean.getPassinfoList();
					//classlineDao.addClassLine(g7bean);
					String cid = g7bean.getId();
					if (!StringUtils.isEmpty(cid)) {
						classLineBean = classlineDao.findClassLineByBid(cid);
						if (classLineBean == null) {
							classlineDao.addClassLine(g7bean);
						}
					}
					if (!CollectionUtils.isEmpty(passInfoList)) {
						for (int j = 0; j < passInfoList.size(); j++) {
							PassInfoData passInfoBean = null;
							PassInfoData passInfo = passInfoList.get(j);
							passInfo.setClasslineId(g7bean.getId());
							String pid = passInfo.getId();
							//classlineDao.addPassInfoData(passInfo);
							if (!StringUtils.isEmpty(pid)) {
								boolean result  = classlineDao.findPassInfoByBid(pid,g7bean.getId());
								if (!result) {
									classlineDao.addPassInfoData(passInfo);
								}
							}
						}

					}
				}
			}
		}
		return true;
	}
}
